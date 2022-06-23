package com.kevin.qlexpress;

import com.ql.util.express.Operator;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperatorGetIpAddress extends Operator {

    private static final Logger logger = LoggerFactory.getLogger(OperatorGetIpAddress.class);
    
    public OperatorGetIpAddress(String name) {
        this.name = name;
    }

    public OperatorGetIpAddress(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        logger.info("in OperatorGetIpAddress.executeInner()");
        String ipAddress = "";
        Object o1 = list[0];

        if(o1 instanceof String) {
            String originalMsg = (String) o1;
            logger.info("args:" + originalMsg);
            if(StringUtils.isNotEmpty(originalMsg)) {
                //截取ip地址
                ipAddress = StringUtils.substringBetween(originalMsg, "source:=", "<&&>");
                logger.info("截取出ip地址:" + ipAddress);
            }
        }
        else {
            String msg = "没有定义类型" + o1 + " 的 " + this.name + "操作";
            throw new Exception(msg);
        }
        return ipAddress;
    }
}
