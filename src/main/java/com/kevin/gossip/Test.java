package com.kevin.gossip;

public class Test {

    private static long interval = 10000;  //ms

    //Network delay in ms. Default is 200ms
    private static int networkDelay = 2000;

    private static long executeGossipTime = 1000;

    public static void main(String[] args) {
        long l = convictedTime();
        System.out.println(l);
    }

    private static long convictedTime() {
        return bb() + interval;
    }

    private static int convergenceCount() {
        int size = 2;
        int count = (int) Math.floor(Math.log10(size) + Math.log(size) + 1);
        System.out.println("count==" + count);
        return count;
    }

    private static long aa() {
        long aa = (convergenceCount() * (networkDelay * 3 + executeGossipTime));
        System.out.println("aa===" + aa);
        return aa;
    }

    private static long bb() {
        long bb = (aa() << 1);
        System.out.println("bb===" + bb);
        return bb;
    }
}
