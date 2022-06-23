package com.kevin.IKExpression;

import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/3/5 14:22
 */
public class Test1 {

    public static void main(String[] args) {
        if (args.length == 0){
            args = new String[1];
            args[0] = "IK Expression";
        }
        //定义表达式
        String expression = "\" Hello World \" + 用户名";
        //给表达式中的变量“用户名”赋上下文值
        List<Variable> variables = new ArrayList<>();
        variables.add(Variable.createVariable("用户名",args[0]));
        //执行表达式
        Object result = ExpressionEvaluator.evaluate(expression, variables);

        System.out.println("Result = " + result);

    }

}
