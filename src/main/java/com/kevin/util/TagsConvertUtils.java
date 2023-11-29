package com.kevin.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.util.*;

/**
 * @Author: LWS
 * @Date: 2020/6/9 15:48
 */
public class TagsConvertUtils {

    /**
     * 将tag中所有value封装在set集合
     * eg 用途:生产,用途:开发测试,服务:FS服务,服务:块服务,区域:开发测试
     *
     * @param tags
     * @return
     */
    public static Set<String> tagToSet(String tags) {
        if (tags == null || tags.isEmpty()) {
            return null;
        } else {
            Set<String> set = new HashSet<>();
            boolean contains = tags.contains(",");
            if (contains) {
                String[] split = tags.split(",");
                for (String tag : split) {
                    String[] strings = tag.split(":");
                    set.add(strings[1]);
                }
                return set;
            } else {
                String[] split = tags.split(":");
                set.add(split[1]);
                return set;
            }
        }
    }

    /**
     * 将已经转换的标签格式封装为map，key=服务，value=[块服务，FS服务]
     * String tags = "用途:开发测试,服务:块服务,服务:FS服务";
     *
     * @param tags
     * @return
     */
    public static Map<String, List<String>> buildTags(String tags) {
        if (tags == null || "".equals(tags)) {
            return new HashMap<>();
        }

        String[] split = tags.split(",");
        Map<String, List<String>> resultMap = new HashMap<>();

        for (String tag : split) {
            String[] tagArr = tag.split(":");
            String key = tagArr[0];
            List<String> strList;
            if (resultMap.containsKey(key)) {
                strList = resultMap.get(key);
            } else {
                strList = new ArrayList<>();
            }

            if (!strList.contains(tagArr[1])) {
                strList.add(tagArr[1]);
            }
            resultMap.put(key, strList);
        }
        return resultMap;
    }

    /**
     * 用户tags处理
     * tags="{\"用途\":[\"开发测试\"],\"服务\":[\"块服务\"],\"区域\":[\"普通生产\"]}";
     * result=用途:开发测试,服务:块服务,区域:普通生产
     *
     * @param tags
     * @return
     */
    public static String userGroupTagsToString(String tags) {
        if (tags == null || "".equals(tags)) {
            return "";
        }
        String result = "";
        JSONObject jsonObject = JSONObject.parseObject(tags);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            List<String> list = JSON.parseArray(value, String.class);
            for (String ss : list) {
                result += (key + ":" + ss + ",");
            }
        }
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 用户tags处理
     * tags="{\"用途\":[\"开发测试\"],\"服务\":[\"块服务\"],\"区域\":[\"普通生产\"]}";
     * result=用途:开发测试,服务:块服务,区域:普通生产
     * <p>
     * eg tagsKey=服务
     * result = 块服务
     *
     * @param tags
     * @return
     */
    public static String queryTasValueByTagsKey(String tags, String tagsKey) {
        String tagsMaps = TagsConvertUtils.userGroupTagsToString(tags);
        String filedValue = "";
        if (!tagsMaps.isEmpty() && tagsMaps.contains(tagsKey)) {
            String[] split = tagsMaps.split(",");
            for (String s : split) {
                if (s.equals(tagsKey)) {
                    filedValue += (s.split(":")[1] + ",");
                }
            }
            if (filedValue.length() > 0) {
                filedValue = filedValue.substring(0, filedValue.length() - 1);
            }
        }
        return filedValue;
    }

    /**
     * 用户tags处理
     * tags="{\"用途\":[\"开发测试\"],\"服务\":[\"块服务\"],\"区域\":[\"普通生产\"]}";
     *
     * @param tags
     * @return
     */
    public static Map<String, List<String>> userGroupTagsToMap(String tags) {
        if (tags == null || "".equals(tags)) {
            return new HashMap<>();
        }

        JSONObject jsonObject = JSONObject.parseObject(tags);

        Map<String, Object> innerMap = jsonObject.to(Map.class);

        Set<Map.Entry<String, Object>> entries = innerMap.entrySet();
        Map<String, List<String>> resultMap = new HashMap<>();

        for (Map.Entry<String, Object> entry : entries) {
            List<String> strList = new ArrayList<>();
            String key = entry.getKey();
            String value = JSON.toJSONString(entry.getValue());

            List<String> valueStrings = JSON.parseArray(value, String.class);
            for (String string : valueStrings) {
                if (!strList.contains(string)) {
                    strList.add(string);
                }
            }
            resultMap.put(key, strList);
        }
        return resultMap;
    }

    public static Map<String, List<String>> stringTagToMapTag(String tags) {
        return tagListToMap(tagToList1(tags));
    }

    //将字符串转换为list
    //tags 格式为 服务:块服务,区域:云
    public static List<String[]> tagToList1(String tags) {

        List<String[]> list = new ArrayList<>();
        boolean contains = tags.contains(",");
        if (contains) {
            String[] split = tags.split(",");
            for (String tag : split) {
                String[] strings = tag.split(":");
                list.add(strings);
            }
            return list;
        } else {
            String[] split = tags.split(":");
            list.add(split);
            return list;
        }
    }

    //将字符串转换为list
    //tags 格式为 {"区域": ["云", "普通测试"], "服务": ["块服务"], "用途": ["灾备", "开发测试"], "池类型": ["固态"]}
    public static List<String[]> tagToList2(String tags) {

        JSONObject jsonObject = JSONObject.parseObject(tags);

        Map<String, Object> innerMap = jsonObject.to(Map.class);

        Set<Map.Entry<String, Object>> entries = innerMap.entrySet();

        List<String[]> list = new ArrayList<>();

        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = JSON.toJSONString(entry.getValue());

            List<String> valueStrings = JSON.parseArray(value, String.class);
            for (String string : valueStrings) {
                String[] arr = new String[2];
                arr[0] = key;
                arr[1] = string;
                list.add(arr);
            }
        }
        return list;
    }

    //将list转化为string
    public static String listToString(List<String[]> list) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i);
            if (i != list.size() - 1) {
                buffer.append(strings[0]);
                buffer.append(":");
                buffer.append(strings[1]);
                buffer.append(",");
            } else {
                buffer.append(strings[0]);
                buffer.append(":");
                buffer.append(strings[1]);
            }
        }

        return buffer.toString();
    }

    public static Map<String, List<String>> tagListToMap(List<String[]> list) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] userTag : list) {
            if (map.containsKey(userTag[0])) {
                List<String> valuesList = map.get(userTag[0]);
                for (String values : valuesList) {
                    if (!values.equals(userTag[1])) {
                        ArrayList<String> newList = new ArrayList<>();
                        newList.add(userTag[1]);
                        newList.addAll(valuesList);
                        map.put(userTag[0], newList);
                    }
                }
            } else {
                ArrayList<String> valuesList = new ArrayList<>();
                valuesList.add(userTag[1]);
                map.put(userTag[0], valuesList);
            }
        }
        return map;
    }

    public static Map<String, List<String>> stringToMap(String userTag) {

        HashMap<String, List<String>> map = new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(userTag);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            List<String> list = JSON.parseArray(value, String.class);
            map.put(key, list);
        }
        return map;
    }

    public static List<String[]> mapToList(Map<String, List<String>> map) {
        List<String[]> list = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            for (String value : values) {
                String[] strings = new String[2];
                strings[0] = key;
                strings[1] = value;
                list.add(strings);
            }
        }
        return list;
    }

    //newUserTagMap 参数和用户标签合计
    //oldUserTagMap 用户标签
    public static Map<String, List<String>> tagMerge(Map<String, List<String>> newUserTagMap, Map<String, List<String>> oldUserTagMap) {
        Set<Map.Entry<String, List<String>>> newEntries = newUserTagMap.entrySet();
        Set<Map.Entry<String, List<String>>> oldEntries = oldUserTagMap.entrySet();
        //获取
        Iterator<Map.Entry<String, List<String>>> newIterator = newEntries.iterator();

        while (newIterator.hasNext()) {
            Map.Entry<String, List<String>> next = newIterator.next();
            for (Map.Entry<String, List<String>> oldEntry : oldEntries) {
                String key = oldEntry.getKey();
                List<String> oldValues = oldEntry.getValue();
                if (next.getKey().equals(key)) {

                    List<String> newValues = next.getValue();
                    if (tagCheck(newValues)) {
                        next.setValue(oldValues);
                    } else {
                        newValues.retainAll(oldValues);
                        //两个list是否有交际
                        if (newValues.size() > 0) {
                            next.setValue(newValues);
                        } else {
                            //没有交集 则说明权限越界
//              throw new ApiException(CodeEnum.SECURITY_TAG_MERGE_ERROR);
                        }
                    }
                }
            }
        }
        return newUserTagMap;
    }

    public static Map<String, List<String>> jsonToMap(JSONObject jsonTag) {
        Map<String, List<String>> map = new HashMap<>();
        Iterator it = jsonTag.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            List<String> value = jsonTag.getObject(key, List.class);
            map.put(key, value);
        }
        //        Set<Map.Entry<String, Object>> jsonEntries = jsonTag.entrySet();
        //        for (Map.Entry<String, Object> jsonEntry : jsonEntries) {
        //            String jsonKey = jsonEntry.getKey();
        //            String value = jsonEntry.getValue().toString();
        //            List<String> list = JSON.parseArray(value, String.class);
        //            map.put(jsonKey, list);
        //        }
        return map;
    }

    //校验特殊字符"%"
    public static boolean tagCheck(List<String> newValues) {
        for (String newValue : newValues) {
            if (newValue.contains("%")) {
                return true;
            }
        }
        return false;
    }

    // parameter {"用途": ["生产"], "级别": ["高级", "前端8", "中端1234"]}
    // return ["用途:生产", "级别:高级", "级别:前端8", "级别:中端1234"]
    //方便前端显示标签
    public static String tagFormatConversion(String tag) {
        JSONObject jsonObject = JSONObject.parseObject(tag);
        Map<String, Object> innerMap = jsonObject.to(Map.class);
        Set<Map.Entry<String, Object>> entries = innerMap.entrySet();
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            List<String> strings = JSON.parseArray(value, String.class);
            for (String string : strings) {
                list.add("\"" + key + ":" + string + "\"");
            }
        }
        return list.toString();
    }
}
