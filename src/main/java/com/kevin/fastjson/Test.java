package com.kevin.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Program: Test
 * @Description:
 * @Author: Liuws
 * @Date: 2022-06-13 16:58:51
 **/
public class Test {

    public static void main(String[] args) {
        SwitchVO switchVO1 = new SwitchVO();
        switchVO1.setName("s1");
        switchVO1.setVendor("Brocade");
        switchVO1.setModel("1111");
        SwitchVO switchVO2 = new SwitchVO();
        switchVO2.setName("s1");
        switchVO2.setVendor("Brocade");
        switchVO2.setModel(null);
        JSONObject jsonObject1 = JSONObject.parseObject(JSONObject.toJSONString(switchVO1, SerializerFeature.WriteNullStringAsEmpty));
        JSONObject jsonObject2 = JSONObject.parseObject(JSONObject.toJSONString(switchVO2, SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(jsonObject1);
        System.out.println(jsonObject2);
    }
}
