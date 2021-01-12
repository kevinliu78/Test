package com.pbn.kevin.grok;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LWS
 * @Date: 2020/10/20 16:17
 */
public class GrokUtils {
    public static final GrokCompiler compiler = GrokCompiler.newInstance();
    public static Grok grok = null;

    public static Map<String, Object> toMap(String pattern, String message){
        // 此处我把预定义的pattern放在/patterns.properties下
        compiler.registerPatternFromClasspath("/patterns.properties");
        grok = compiler.compile(pattern);
        if(grok!=null){
            Match match = grok.match(message);
            return match.capture();
        } else {
            return new HashMap();
        }
    }
}
