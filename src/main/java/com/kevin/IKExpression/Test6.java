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
public class Test6 {

    public static void main(String[] args) {

        //定义表达式
        String expression = "recvData*800.0/maxSpeed";
        //给表达式中的[版本]赋上下文值
        List<Variable> variables = new ArrayList<>();
        variables.add(Variable.createVariable("recvData",1));
        variables.add(Variable.createVariable("maxSpeed",1));

        //预编译表达式
        PreparedExpression pe = ExpressionEvaluator.preparedCompile(expression, variables);



        //执行表达式
        Object result = pe.execute();
        System.out.println("Result = " + result);

    }

}
