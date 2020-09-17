package com.pbn.kevin.qlexpress;


import org.apache.commons.beanutils.BeanUtils;

/**
 * @Author: LWS
 * @Date: 2019/12/25 14:24
 */
public class Rule {
    private String fieldName;
    private String expression;

    private boolean matched = false;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public boolean match(Object event) {
        boolean result = false;
        try {
            String fieldValue = BeanUtils.getProperty(event, fieldName);
            result = RuleExecutor.getInstance().excute(expression, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
