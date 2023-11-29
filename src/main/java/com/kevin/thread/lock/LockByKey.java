package com.kevin.thread.lock;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2023-06-05 15:19:33
 **/
public interface LockByKey<T> {

    /**
     * 加锁
     */
    void lock(T key);

    /**
     * 解锁
     */
    void unlock(T key);
}
