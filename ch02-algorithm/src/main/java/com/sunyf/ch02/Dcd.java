package com.sunyf.ch02;

/**
 * @program: data-structures
 * @description: 求最大公约数
 * @author: sunyf
 * @create: 2018-11-14 21:25
 **/
public class Dcd {

    /**
     * 求最大公约数，欧几里得算法：
     * 1、m大于n，则连续计算求余r，m跟n交换，n跟r交换；
     * 2、得到的非零整数则是最大公约数
     */
    public static long gcd(long m, long n) {
        //
        while (n != 0) {
            long r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void main(String[] args) {
        //
        //long l = gcd(50l, 15l);
        long l = gcd(9999l, 345l);
        System.out.println(l);
    }
}
