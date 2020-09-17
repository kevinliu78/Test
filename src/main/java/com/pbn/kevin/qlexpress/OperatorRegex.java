package com.pbn.kevin.qlexpress;

import com.ql.util.express.Operator;

import java.util.regex.Pattern;

/**
 * @Author: LWS
 * @Date: 2020/9/15 16:40
 */
public class OperatorRegex extends Operator {
    public OperatorRegex(String name) {
        this.name = name;
    }

    public OperatorRegex(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        boolean result;
        Object o1 = list[0];
        Object o2 = list[1];
        if(o1 instanceof String && o2 instanceof String) {
            String src = (String) o1;
            String des = (String) o2;
//            String start = des.substring(0, des.indexOf("*")).trim();
//            String end = des.substring(des.indexOf("*")+1).trim();
            String regex = des.replaceAll("%wildcard%", ".*");
            regex = ".*"+regex+".*";
            System.out.println("regex = "+regex);
            result = Pattern.matches(regex, src);
        }
        else {
            String msg = "没有定义类型" + o1 + "和" + o2 + " 的 " + this.name + "操作";
            throw new Exception(msg);
        }
        return result;
    }
}
