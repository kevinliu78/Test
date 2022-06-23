package com.kevin.grok;

import com.alibaba.fastjson2.JSONObject;
import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

import java.util.Map;

/**
 * @Author: LWS
 * @Date: 2020/10/20 15:31
 */
public class Test2 {

    public static void main(String[] args) {
        String pattern="%{MONTH}\\s+%{MONTHDAY}\\s+%{TIME}\\s+%{YEAR}.*%{fromIP}";
        String message = "Mon Nov  9 06:47:33 2015; UDP; eth1; 461 bytes; from 88.150.240.169:tag-pm";

        /* Create a new grokCompiler instance */
        GrokCompiler grokCompiler = GrokCompiler.newInstance();
        grokCompiler.registerDefaultPatterns();
//        grokCompiler.register("fromIP", "%{IPV4}");
        grokCompiler.register("fromIP", "(?<![0-9])(?:(?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})[.](?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})[.](?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})[.](?:25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2}))(?![0-9])");

        /* Grok pattern to compile, here httpd logs */
        final Grok grok = grokCompiler.compile(pattern);


        Match gm = grok.match(message);

        /* Get the map with matches */
        final Map<String, Object> capture = gm.capture();

        System.out.println(JSONObject.toJSONString(capture));

        System.out.println((System.currentTimeMillis() - (60 * 60 * 1000L)));
    }

}
