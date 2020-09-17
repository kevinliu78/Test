package com.pbn.kevin.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * @Author: LWS
 * @Date: 2019/12/25 14:24
 */
public class RuleExecutor {
    private static RuleExecutor instance;

    private ExpressRunner runner;

    private RuleExecutor() {
        runner = new ExpressRunner();
        OperatorTimeRangeIn op = new OperatorTimeRangeIn("timeRangeIn");
        OperatorContain con = new OperatorContain("contains");
        OperatorRegex regex = new OperatorRegex("regex");
        OperatorGetWeek week = new OperatorGetWeek("getWeek");
        OperatorGetHour hour = new OperatorGetHour("getHour");
        OperatorGetIpAddress ip = new OperatorGetIpAddress("getIp");
        runner.addFunction("getIp", ip);
        try {
            runner.addOperator("timeRangeIn", op);
            runner.addOperator("contains", con);
            runner.addOperator("regex", regex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        runner.addFunction("getWeek", week);
        runner.addFunction("getHour", hour);
    }

    public static RuleExecutor getInstance() {
        if (instance == null) {
            instance = new RuleExecutor();

        }
        return instance;
    }

    public Boolean excute(String expression, String value) throws Exception {
        if (expression.startsWith("fieldValue equal")) {
            String val = expression.substring(expression.indexOf("(\"") + 2, expression.indexOf("\")"));
            return val.equals(value);
        }

        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("fieldValue", value);
        Boolean result = (Boolean) runner.execute(expression, context, null, false, false);
        return result;
    }

}
