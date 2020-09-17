package com.pbn.kevin.qlexpress;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;

/**
 * @Author: LWS
 * @Date: 2019/12/25 14:23
 */
public class FilterPolicy implements Comparable<FilterPolicy> {
    private ArrayList<Rule> rules = new ArrayList<Rule>();
    private int id;
    private int status;
    private String name;
    private String content;
    private String desc;
    private int priority;
    private String featureCode;

    public FilterPolicy() {
    }

    public FilterPolicy(ArrayList<Rule> rules, int id, int status, String name, String content, String desc, int priority, String featureCode) {
        this.rules = rules;
        this.id = id;
        this.status = status;
        this.name = name;
        this.content = content;
        this.desc = desc;
        this.priority = priority;
        this.featureCode = featureCode;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
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
                continue;
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
        return result;
    }
}
