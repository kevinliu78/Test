package com.kevin.IKExpression;

import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.PreparedExpression;
import org.wltea.expression.datameta.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/3/5 14:33
 */
public class Test3 {

    public static void main(String[] args) {

        Integer arg = 900;

        //定义表达式
        String expression = "(申请金额 > 10000) ? \"总经理审批\" : \"部门经理审批\"";
        //给表达式中的[版本]赋上下文值
        List<Variable> variables = new ArrayList<>();
        variables.add(Variable.createVariable("申请金额",arg));

        //预编译表达式
        PreparedExpression pe = ExpressionEvaluator.preparedCompile(expression, variables);

        //执行表达式
        Object result = pe.execute();
        System.out.println("Result = " + result);

        //更改参数，再次执行预编译式
        pe.setArgument("申请金额",20000);
        result = pe.execute();
        System.out.println("Result = " + result);
    }

}
