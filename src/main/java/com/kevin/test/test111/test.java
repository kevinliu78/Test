package com.kevin.test.test111;

import java.lang.reflect.Field;

/**
 * @Author: LWS
 * @Date: 2020/4/16 18:53
 */
public class test {
    public static String getClassFiledInfo(Class<?> c) {
        Class<?> superclass = c.getSuperclass();
        System.out.println(superclass);
        String s = "(";
        for (int i = 0; i < superclass.getDeclaredFields().length; i++) {
            Field field = superclass.getDeclaredFields()[i];
            //设置可以获取私人属性
            field.setAccessible(true);
            Class type = field.getType();
            String name = field.getName();
            if (i == superclass.getDeclaredFields().length - 1) {
                s += (name + " " + (type.getSimpleName().equals("Integer") ? "Int" : type.getSimpleName()));
            } else {
                s += (name + " " + (type.getSimpleName().equals("Integer") ? "Int" : type.getSimpleName()) + ", ");
            }
        }
        System.out.println(s);
        for (int i = 0; i < c.getDeclaredFields().length; i++) {
            Field field = c.getDeclaredFields()[i];
            //设置可以获取私人属性
            field.setAccessible(true);
            Class type = field.getType();
            String name = field.getName();
            if (i == c.getDeclaredFields().length - 1) {
                s += (name + " " + (type.getSimpleName().equals("Integer") ? "Int" : type.getSimpleName()));
            } else {
                s += (name + " " + (type.getSimpleName().equals("Integer") ? "Int" : type.getSimpleName()) + ", ");
            }
        }
        return s+")";
    }

    public static void main(String[] args) {
        System.out.println(getClassFiledInfo(Egineer.class));
    }
}
