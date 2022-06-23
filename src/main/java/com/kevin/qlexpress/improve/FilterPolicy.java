package com.kevin.qlexpress.improve;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.kevin.qlexpress.Rule;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2019/12/25 14:23
 */
public class FilterPolicy implements Comparable<FilterPolicy> {
    private List<Rule> rules = new ArrayList<>();
    private List<List<Rule>> upTimeRules = new ArrayList<>();
    private int id;
    private int status;
    private String name;
    private String content;
    private String desc;
    private int priority;
    private String featureCode;

    public FilterPolicy() {
    }

    public FilterPolicy(List<Rule> rules, List<List<Rule>> upTimeRules, int id, int status, String name, String content, String desc, int priority,
                        String featureCode) {
        this.rules = rules;
        this.upTimeRules = upTimeRules;
        this.id = id;
        this.status = status;
        this.name = name;
        this.content = content;
        this.desc = desc;
        this.priority = priority;
        this.featureCode = featureCode;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<List<Rule>> getUpTimeRules() {
        return upTimeRules;
    }

    public void setUpTimeRules(List<List<Rule>> upTimeRules) {
        this.upTimeRules = upTimeRules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.parseRule();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    @Override
    public int compareTo(FilterPolicy fp) {
        if (this.getPriority() == fp.getPriority()) {
            return 0;
        } else if (this.getPriority() > fp.getPriority()) {
            return 1;
        } else {
            return -1;
        }
    }

    private void parseRule() {
        JSONObject jsonObject = JSONObject.parseObject(this.content);
        JSONArray array = (JSONArray) jsonObject.get("rules");
        JSONArray upTimeArray = (JSONArray) jsonObject.get("upTimeCon");
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                try {
                    JSONObject json = (JSONObject) array.get(i);
                    String fieldName = json.getString("name");
                    String expression = buildExp(json);
                    if (StringUtils.isEmpty(expression)) {
                        continue;
                    }
                    Rule rule = new Rule();
                    rule.setExpression(expression);
                    rule.setFieldName(fieldName);
                    rules.add(rule);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * @Description 针对时间的规则做封装
         * @Author Liuws
         * @Date 2022/2/22 17:57
         */
        if (upTimeArray != null && upTimeArray.size() > 0) {
            for (int i = 0; i < upTimeArray.size(); i++) {
                try {
                    List<Rule> timeConList = new ArrayList<>();
                    JSONArray timeCon = upTimeArray.getJSONArray(i);
                    for (int j = 0; j < timeCon.size(); j++) {
                        JSONObject json = timeCon.getJSONObject(j);
                        String fieldName = json.getString("name");
                        String expression = buildExp(json);
                        if (StringUtils.isEmpty(expression)) {
                            continue;
                        }
                        Rule rule = new Rule();
                        rule.setExpression(expression);
                        rule.setFieldName(fieldName);
                        timeConList.add(rule);
                    }
                    if (timeConList.size() > 0) {
                        upTimeRules.add(timeConList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String buildExp(JSONObject json) {
        String fieldValue = "fieldValue ";
        String preHandle = json.getString("preHandle");
        String operator = json.getString("operator");
        String value = json.getString("value");
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        if (StringUtils.isNotEmpty(preHandle)) {
            fieldValue = preHandle + " (fieldValue) ";
        }
        value = toStringExp(value);
        String exp = fieldValue + operator + " (" + value + ")";
        return exp;
    }

    private String toStringExp(String value) {
        String result;
        if (value.startsWith("[")) {
            result = StringUtils.substringBetween(value, "[", "]");
        } else {
            result = value;
        }

        String[] str = StringUtils.split(result, ",");
        for (int i = 0; i < str.length; i++) {
            str[i] = "\"" + str[i] + "\"";

        }
        result = StringUtils.join(str, ",");
        if (value.startsWith("[")) {
            result = "[" + result + "]";
        }

        return result;
    }

    /**
     * 存在多个规则时，有一个规则不匹配则整个策略不匹配
     *
     * @param alarm
     * @return
     */
    public boolean doMatch(Object alarm) {
        boolean result = false;
        for (int i = 0; i < rules.size(); i++) {
            if (i == 0) {
                result = rules.get(i).match(alarm);
            } else {
                result = result && rules.get(i).match(alarm);
            }
            if (!result) {
                break;
            }
        }
        //时间规则判断
        if (upTimeRules.size() > 0) {
            boolean b = upTimeDoMatch(alarm);
            return result && b;
        } else {
            return result;
        }
    }

    /**
     * @param alarm
     * @return boolean
     * @Description 时间条件规则判断;有一个规则匹配则整个策略就匹配
     * @Author Liuws
     * @Date 2022/2/22 17:58
     */
    private boolean upTimeDoMatch(Object alarm) {
        boolean result = false;
        for (int i = 0; i < upTimeRules.size(); i++) {
            List<Rule> timeRules = upTimeRules.get(i);
            boolean a = false;
            for (int j = 0; j < timeRules.size(); j++) {
                if (j == 0) {
                    a = timeRules.get(j).match(alarm);
                } else {
                    a = a && timeRules.get(j).match(alarm);
                }
                if (!a) {
                    break;
                }
            }
            if (i == 0) {
                result = a;
            } else {
                result = result || a;
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
