package com.kevin.qlexpress;

import com.ql.util.express.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorTimeRangeIn extends Operator {

    private static final Logger logger = LoggerFactory.getLogger(OperatorTimeRangeIn.class);
    
    public OperatorTimeRangeIn(String name) {
        this.name = name;
    }

    public OperatorTimeRangeIn(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        logger.info("in OperatorTimeRangeIn.executeInner()");
        boolean result = false;
        Object o1 = list[0];
        Object o2 = list[1];
        if(o1 instanceof String && o2 instanceof String[]) {
            String value = (String) o1;
            String[] range = (String[]) o2;
            String min = range[0];
            String max = range[1];
            try {
                int v = Integer.parseInt(value);
                int mi = Integer.parseInt(min);
                int ma = Integer.parseInt(max);
                result = v >= mi && v < ma;
                logger.info("判断" + v + "是否在[" + min + "," + max + "] = " + result);
            }
            catch(Exception e) {
                String msg = this.name + "操作参数类型错误";
                logger.info(msg);
                throw new Exception(msg);
            }
        }
        else {
            String msg = "没有定义类型" + o1 + "和" + o2 + " 的 " + this.name + "操作";
            throw new Exception(msg);
        }
        return Boolean.valueOf(result);
    }
}
