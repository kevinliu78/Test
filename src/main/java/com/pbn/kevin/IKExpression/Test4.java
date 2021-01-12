package com.pbn.kevin.IKExpression;


import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.PreparedExpression;
import org.wltea.expression.datameta.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LWS
 * @Date: 2020/3/5 14:33
 */
public class Test4 {

    public static void main(String[] args) {

        if (args.length == 0){
            args = new String[1];
            args[0] = "IK Expression V2.0.5";
        }

        //定义表达式
        String expression = "$问好(name)";
        //给表达式中的[版本]赋上下文值
        List<Variable> variables = new ArrayList<>();
        variables.add(Variable.createVariable("name",args[0]));

        //预编译表达式
        PreparedExpression pe = ExpressionEvaluator.preparedCompile(expression, variables);

        //执行表达式
        Object result = pe.execute();
        System.out.println("Result = " + result);

        //更改参数，再次执行预编译式
        pe.setArgument("name","aaa");
        result = pe.execute();
        System.out.println("Result = " + result);
    }

}
