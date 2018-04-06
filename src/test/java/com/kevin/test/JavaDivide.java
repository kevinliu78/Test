package com.kevin.test;
/**
 * @author kevin
 * @version 创建时间: 2018年3月1日下午1:46:44
 * @ClassName 类名称
 * @Description 类描述
 */
public class JavaDivide {  
    public static void main(String[]args)//测试  
    {  
        double a;  
        int b;  
        float c;  
        //如果相除的是两个int类型的数，如“1/3”，则所得结果去掉小数（两个int相除），再赋值给变量  
        a=1/3;  
        b=1/3;  
        c=1/3;  
        System.out.println("1/3:");  
        System.out.println("double:"+String.valueOf(a));  
        System.out.println("int:"+String.valueOf(b));  
        System.out.println("float:"+String.valueOf(c));  
        //如果被除数为double型，除数为int型，则所得结果为double型，相当于两个double相除  
        a=1.0/3;  
        b=(int) (1.0/3);  
        c=(float) (1.0/3);  
        System.out.println("1.0/3:");  
        System.out.println("double:"+String.valueOf(a));  
        System.out.println("int:"+String.valueOf(b));  
        System.out.println("float:"+String.valueOf(c));  
        //如果被除数为int型，除数为double型，则所得结果为double型，相当于两个double相除  
        a=1/3.0;  
        b=(int) (1/3.0);  
        c=(float) (1/3.0);  
        System.out.println("1/3.0:");  
        System.out.println("double:"+String.valueOf(a));  
        System.out.println("int:"+String.valueOf(b));  
        System.out.println("float:"+String.valueOf(c));  
        //除以0的后果  
        a=1/0;  
        b=1/0;  
        c=1/0;  
        System.out.println("1/0:");  
        System.out.println("double:"+String.valueOf(a));  
        System.out.println("int:"+String.valueOf(b));  
        System.out.println("float:"+String.valueOf(c));  
    }  
}  