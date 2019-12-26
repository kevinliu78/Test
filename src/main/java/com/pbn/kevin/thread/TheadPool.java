package com.pbn.kevin.thread;
/**
 * @author kevin
 * @version 创建时间: 2018年8月10日上午9:54:48
 * @ClassName 类名称
 * @Description 线程池学习
 */

import java.util.Collection;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的主要作用：
 * 
 * 通过重用线程池中的线程，来减少每个线程创建和销毁的性能开销。
 *
 * 对线程进行一些维护和管理，比如定时开始，周期执行，并发数控制等等。
 */

/**
 * ThreadPoolExecutor四种构造方法
 * ThreadPollExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue)
 * ThreadPollExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory)
 * ThreadPollExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler)
 * ThreadPollExecutor(int corePoolSize, int maximumPoolSize,long keepAliveTime,TimeUnit unit,
 * BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler)
 * 
 * 构造方法参数说明:
 * corePoolSize
 * 核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
 * maximumPoolSize
 * 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
 * keepAliveTime
 * 非核心线程的闲置超时时间，超过这个时间就会被回收。
 * unit
 * 指定keepAliveTime的单位，如TimeUnit.SECONDS。当将allowCoreThreadTimeOut设置为true时对corePoolSize生效。
 * workQueue
 * 线程池中的任务队列.常用的有三种队列，SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue。
 * threadFactory
 * 线程工厂，提供创建新线程的功能。ThreadFactory是一个接口，只有一个方法
 *	public interface ThreadFactory {
 *		Thread newThread(Runnable r);
 *	}
 *	通过线程工厂可以对线程的一些属性进行定制。
 * RejectedExecutionHandler
 * 也是一个接口，只有一个方法
 * public interface RejectedExecutionHandler {
 *	  void rejectedExecution(Runnable var1, ThreadPoolExecutor var2);
 *	}
 * 当线程池中的资源已经全部使用，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution方法。
 */

/**
 * 线程池规则
 * 线程池的线程执行规则跟任务队列有很大的关系。
 * 一、下面都假设任务队列没有大小限制：
 * 1.如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
 * 2.如果线程数量>核心线程数，但<=最大线程数，并且任务队列是LinkedBlockingDeque的时候，超过核心线程数量的任务会放在任务队列中排队。
 * 3.如果线程数量>核心线程数，但<=最大线程数，并且任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。
 * 	 这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除。
 * 4.如果线程数量>核心线程数，并且>最大线程数，当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。
 *   也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
 * 5.如果线程数量>核心线程数，并且>最大线程数，当任务队列是SynchronousQueue的时候，会因为线程池拒绝添加任务而抛出异常。
 * 二、任务队列大小有限时
 * 1.当LinkedBlockingDeque塞满时，新增的任务会直接创建新线程来执行，当创建的线程数量超过最大线程数量时会抛异常。
 * 2.SynchronousQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。
 */
//验证规则
public class TheadPool {
	
	public static void main(String[] args) {
		/**
		 * 创建任务
		 */
		Runnable testRunnable = new Runnable() {
			@Override
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
		/**
		 * 1.如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
		 * 核心线程数为6，最大线程数为10。超时时间为5秒
		 * 执行结果：
		 *  ---先开三个---
			核心线程数6
			线程池数3
			队列任务数0
			---再开三个---
			核心线程数6
			线程池数6
			队列任务数0
			pool-1-thread-5run
			pool-1-thread-3run
			pool-1-thread-4run
			pool-1-thread-1run
			pool-1-thread-6run
			pool-1-thread-2run
			----8秒之后----
			核心线程数6
			线程池数6
			队列任务数0
		 * 总结：
		 * 可以看到每个任务都是是直接启动一个核心线程来执行任务，一共创建了6个线程，不会放入队列中。8秒后线程池还是6个线程，核心线程默认情况下不会被回收，不收超时时间限制。
		 * 无论是什么队列都不会放入队列
		 */
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		/**
		 * 2.如果线程数量>核心线程数，但<=最大线程数，并且任务队列是LinkedBlockingDeque的时候，超过核心线程数量的任务会放在任务队列中排队。
		 * 核心线程数为3，最大线程数为6。超时时间为5秒,队列是LinkedBlockingDeque
		 * 执行结果：
		 *  ---先开三个---
			核心线程数3
			线程池数3
			队列任务数0
			---再开三个---
			核心线程数3
			线程池数3
			队列任务数3
			pool-1-thread-2run
			pool-1-thread-1run
			pool-1-thread-3run
			pool-1-thread-1run
			pool-1-thread-3run
			pool-1-thread-2run
			----8秒之后----
			核心线程数3
			线程池数3
			队列任务数0
		 *  总结：当任务数超过核心线程数时，会将超出的任务放在队列中，只会创建3个线程重复利用。
		 */
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		/**
		 * 3.如果线程数量>核心线程数，但<=最大线程数，并且任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。
		 * 	 这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除。
		 * 核心线程数为3，最大线程数为6。超时时间为5秒,队列是SynchronousQueue
		 * 执行结果：
		 *  ---先开三个---
			核心线程数3
			线程池数3
			队列任务数0
			---再开三个---
			核心线程数3
			线程池数6
			队列任务数0
			pool-1-thread-1run
			pool-1-thread-3run
			pool-1-thread-2run`
			pool-1-thread-5run
			pool-1-thread-6run
			pool-1-thread-4run
			----8秒之后----
			核心线程数3
			线程池数3
			队列任务数0

		 *  总结：
			当队列是SynchronousQueue时，超出核心线程的任务会创建新的线程来执行，看到一共有6个线程。
			但是这些线程是非核心线程，受超时时间限制，在任务完成后限制超过5秒就会被回收。所以最后看到线程池还是只有三个线程。
		 */
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		/**
		 * 4.如果线程数量>核心线程数，并且>最大线程数，当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。
		 *   也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
		 *   核心线程数是3，最大线程数是4，超时时间为5秒.队列是LinkedBlockingDeque
		 *   执行结果：
		 *   ---先开三个---
			核心线程数3
			线程池数3
			队列任务数0
			---再开三个---
			核心线程数3
			线程池数3
			队列任务数3
			pool-1-thread-1run
			pool-1-thread-3run
			pool-1-thread-2run
			pool-1-thread-1run
			pool-1-thread-2run
			pool-1-thread-3run
			----8秒之后----
			核心线程数3
			线程池数3
			队列任务数0
			总结：
			LinkedBlockingDeque根本不受最大线程数影响。
			但是当LinkedBlockingDeque有大小限制时就会受最大线程数影响了
		 */
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2));
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1),new ThreadPoolExecutor.DiscardOldestPolicy());
		/**
		 * 首先为三个任务开启了三个核心线程1，2，3，然后第四个任务和第五个任务加入到队列中，
		 * 第六个任务因为队列满了，就直接创建一个新线程4，这时一共有四个线程，没有超过最大线程数。
		 * 8秒后，非核心线程收超时时间影响回收了，因此线程池只剩3个线程了。
		 */
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
