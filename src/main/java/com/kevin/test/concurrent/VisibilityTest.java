package com.kevin.test.concurrent;
/**
 * @author kevin
 * @version 创建时间: 2018年7月3日下午4:53:50
 * @ClassName 类名称
 * @Description 类描述
 */
public class VisibilityTest {
	private static boolean ready;
    private static int number;
 
    private static class ReaderThread extends Thread {
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!ready) {
                System.out.println(ready);
            }
            System.out.println(number);
        }
    }
 
    private static class WriterThread extends Thread {
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 100;
            ready = true;
        }
    }
 
    public static void main(String[] args) {
        new WriterThread().start();
        new ReaderThread().start();
    }
}
