package com.pbn.kevin.qlexpress;

import com.ql.util.express.Operator;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

public class OperatorGetWeek extends Operator {

    private static final Logger logger = LoggerFactory.getLogger(OperatorGetWeek.class);
    
    public OperatorGetWeek(String name) {
        this.name = name;
    }

    public OperatorGetWeek(String aAliasName, String aName, String aErrorInfo) {
        this.name = aName;
        this.aliasName = aAliasName;
        this.errorInfo = aErrorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        logger.info("in OperatorGetWeek.executeInner()");
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
                int c = cal.get(Calendar.DAY_OF_WEEK);
                if(c == 1) {
                    result = 7;

                }
                else {
                    result = c - 1;
                }
                logger.info("src:" + src + " 解析出 DAY_OF_WEEK：" + result);
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
