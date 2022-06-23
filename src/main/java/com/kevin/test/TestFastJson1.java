package com.kevin.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: LWS
 * @Date: 2020/5/9 17:10
 */
public class TestFastJson1 {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject object = new JSONObject();
        object.put("lunResourceId","11111");
        object.put("storageId","222");
        object.put("poolName","3333");
        jsonArray.add(object);
        jsonObject.put("result",jsonArray);
        System.out.println(JSONObject.toJSONString(jsonObject));

        JSONArray result = (JSONArray) jsonObject.get("result");
        for(Object json : result){
            JSONObject jo = (JSONObject) json;
            Object lunResourceId = jo.get("lunResourceId");
            Object storageId = jo.get("storageId");
            Object poolName = jo.get("poolName");
            System.out.println("======================");
        }
    }

}
