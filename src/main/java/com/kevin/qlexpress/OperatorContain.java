package com.kevin.qlexpress;

import com.ql.util.express.Operator;
import org.apache.commons.lang.StringUtils;

public class OperatorContain extends Operator {
    public OperatorContain(String name) {
        this.name = name;
    }

    public OperatorContain(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        boolean result = false;
        Object o1 = list[0];
        Object o2 = list[1];
        if(o1 instanceof String && o2 instanceof String) {
            String src = (String) o1;
            String des = (String) o2;
            result = StringUtils.contains(src, des);
        }
        else {
            String msg = "没有定义类型" + o1 + "和" + o2 + " 的 " + this.name + "操作";
            throw new Exception(msg);
        }
        return Boolean.valueOf(result);
    }
}
