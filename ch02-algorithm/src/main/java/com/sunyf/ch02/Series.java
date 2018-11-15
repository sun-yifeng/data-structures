package com.sunyf.ch02;

/**
 * @program: data-structures
 * @description: 级数
 * @author: sunyf
 * @create: 2018-11-15 00:44
 **/
public class Series {

    public static long sum(long l) {
        long r = 0;
        for (long i = 0l; i < l; i++) {
            r += i * i * i * i * i* i * i * i * i;
        }
        return r;
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        long l = sum(1000);
        long t2 = System.currentTimeMillis();
        System.out.println(l);
        System.out.println("耗费时间：" + (t2-t1));
    }

}
