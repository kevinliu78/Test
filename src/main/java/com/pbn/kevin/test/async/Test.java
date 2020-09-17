package com.pbn.kevin.test.async;

/**
 * @Author: LWS
 * @Date: 2020/8/12 10:27
 */
public class Test {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        new Thread(()->{
            try {
                Thread.sleep(10000);
                System.out.println("异步调用结束！");
                System.out.println("cost time = "+(System.currentTimeMillis()-t)/1000 + "s");
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();


        System.out.println("cost time = "+(System.currentTimeMillis()-t)/1000 + "s");
    }
}
