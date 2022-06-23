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
public class Test5 {

    public static void main(String[] args) {

        //定义表达式
//        String expression = "ReadIOTimeCounter/ReadIOs/1000.0";
        String expression = "ReadIOTimeCounter";
        //给表达式中的[版本]赋上下文值
        List<Variable> variables = new ArrayList<>();
        variables.add(Variable.createVariable("ReadIOTimeCounter",100000));
        variables.add(Variable.createVariable("ReadIOs",5));

        //预编译表达式
        PreparedExpression pe = ExpressionEvaluator.preparedCompile(expression, variables);



        //执行表达式
        Object result = pe.execute();
        System.out.println("Result = " + result);

        /**
         * 1、系统结构图，模块划分
         * 2、告警查询根据用户权限
         * 3、时序图根据消息处理
         */

    }

}
