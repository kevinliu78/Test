package com.kevin.thread.lock;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-05 15:28:28
 **/
public class DefaultLockByKeyTest {
    private final LockByKey<String> lockByKey = new DefaultLockByKeyImpl<>();

    private final CountDownLatch countDownLatch = new CountDownLatch(7);
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void test() throws InterruptedException {
        List<String> keys = Arrays.asList("a", "a", "a", "b", "c", "b", "d");
        Set<String> executingKeySet = new HashSet<>();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            int finalI = i;
            executorService.submit(() -> {
                lockByKey.lock(key);
                if (executingKeySet.contains(key)) {
                    throw new RuntimeException("存在正在执行的 key:" + key);
                }
                executingKeySet.add(key);

                try {
                    System.out.println("index:" + finalI + "对 [" + key + "] 加锁 ->" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("index:" + finalI + "释放 [" + key + "] ->" + Thread.currentThread().getName());
                    lockByKey.unlock(key);
                    executingKeySet.remove(key);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }
}
