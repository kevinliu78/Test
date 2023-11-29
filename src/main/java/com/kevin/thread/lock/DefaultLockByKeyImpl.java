package com.kevin.thread.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-05 15:21:51
 **/
public class DefaultLockByKeyImpl<T> implements LockByKey<T> {

    private final Map<T, ReentrantLock> lockMap = new ConcurrentHashMap<>();

    @Override
    public void lock(T key) {
        // 如果key为空，直接返回
        if (key == null) {
            throw new IllegalArgumentException("key 不能为空");
        }
        // 获取或创建一个ReentrantLock对象
        ReentrantLock lock = lockMap.computeIfAbsent(key, k -> new ReentrantLock(true));
        // 获取锁
        lock.lock();
    }

    @Override
    public void unlock(T key) {
        // 如果key为空，直接返回
        if (key == null) {
            throw new IllegalArgumentException("key 不能为空");
        }
        // 从Map中获取锁对象
        ReentrantLock lock = lockMap.get(key);
        // 获取不到报错
        if (lock == null) {
            throw new IllegalArgumentException("key " + key + "尚未加锁");
        }
        // 其他线程非法持有不允许释放
        if (!lock.isHeldByCurrentThread()) {
            throw new IllegalStateException("当前线程尚未持有，key:" + key + "的锁，不允许释放");
        }
        lock.unlock();
    }
}
