package com.kevin.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 * @version 创建时间: Nov 7, 20182:34:38 PM
 * @ClassName 类名称
 * @Description 类描述
 */
public class TreadPool1 {
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		/**
		 * 创建任务
		 */
		Runnable testRunnable = new Runnable() {
			public void run() {
				try {
					//睡眠两秒
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + "run");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2));
		//验证核心代码
		executor.execute(testRunnable);
		executor.execute(testRunnable);
		executor.execute(testRunnable);
		System.out.println("---先开三个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		executor.execute(testRunnable);
		executor.execute(testRunnable);
		executor.execute(testRunnable);
		System.out.println("---再开三个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("----8秒之后----");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		
	}
}
