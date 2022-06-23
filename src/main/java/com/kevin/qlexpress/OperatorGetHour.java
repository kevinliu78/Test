package com.kevin.qlexpress;

import com.ql.util.express.Operator;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

public class OperatorGetHour extends Operator {
    private static final Logger logger = LoggerFactory.getLogger(OperatorGetHour.class);

    public OperatorGetHour(String name) {
        this.name = name;
    }

    public OperatorGetHour(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        logger.info("in OperatorGetHour.executeInner()");
        int result;
        Object o1 = list[0];

        if(o1 instanceof String) {
            String src = (String) o1;
            logger.info(src);
            String[] parsePatterns = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"};
            try {
                Date d = DateUtils.parseDate(src, parsePatterns);
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                result = cal.get(Calendar.HOUR_OF_DAY);
                logger.info("src:" + src + " 解析出 HOUR_OF_DAY：" + result);
            }
            catch(Exception e) {
                String msg = "日期参数格式解析错误:" + src;
                throw new Exception(msg);
            }

        }
        else {
            String msg = "没有定义类型" + o1 + " 的 " + this.name + "操作";
            throw new Exception(msg);
        }
        return String.valueOf(result);
    }

}
