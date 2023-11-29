package com.kevin.test;

/**
 * @Program: DefaultLockByKeyTest
 * @Description:
 * @Author: Liuws
 * @Date: 2023-04-13 15:00:32
 **/
public class TestHashCode {

    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash

    public static void main(String[] args) {

        Long resourceId = 929940417644921729L;
        Long resourceId1 = 856081239445090035L;

        System.out.println(spread(resourceId.hashCode()));
        System.out.println(spread(resourceId1.hashCode()));
    }

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
}
