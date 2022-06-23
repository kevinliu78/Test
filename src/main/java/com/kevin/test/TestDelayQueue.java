package com.kevin.test;

import com.kevin.util.ConfigUtil;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LWS
 * @Date: 2020/12/24 10:42
 */
public class TestDelayQueue {

    public static void main(String[] args) {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<DelayedElement>();
        //生产者
        producer(delayQueue);

        //消费者
        consumer(delayQueue);

        while (true){
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 每100毫秒创建一个对象，放入延迟队列，延迟时间1毫秒
     * @param delayQueue
     */
    private static void producer(final DelayQueue<DelayedElement> delayQueue){

        /**
         * 每秒打印延迟队列中的对象个数
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        TimeUnit.MILLISECONDS.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("delayQueue size:"+delayQueue.size()+"=============time=="+ ConfigUtil.formatDate24(new Date()));
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    try {
                        TimeUnit.MILLISECONDS.sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    DelayedElement element = new DelayedElement(10000,"test"+i);
                    delayQueue.offer(element);
                }
            }
        }).start();




    }

    /**
     * 消费者，从延迟队列中获得数据,进行处理
     * @param delayQueue
     */
    private static void consumer(final DelayQueue<DelayedElement> delayQueue){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    DelayedElement element = null;
                    try {
                        element =  delayQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("=============time=="+ ConfigUtil.formatDate24(new Date())+"---"+element);
                }
            }
        }).start();
    }
}
