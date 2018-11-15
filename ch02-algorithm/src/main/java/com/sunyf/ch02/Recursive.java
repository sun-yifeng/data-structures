package com.sunyf.ch02;

/**
 * @program: data-structures
 * @description: 递归调用
 * @author: sunyf
 * @create: 2018-11-15 00:57
 **/
public class Recursive {

    /**
     * 斐波那契数列：数列从第3项开始，每一项都等于前两项之和。如:
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377...
     **/
    public static long fib(long n) {
        if (n == 1)
            return 0;
        else if (n == 2) {
            return 1;
        }
            return fib(n -1) + fib(n - 2);
    }

    public static void main(String[] args) {
        long l = fib(999);
        System.out.println(l);
    }

}


