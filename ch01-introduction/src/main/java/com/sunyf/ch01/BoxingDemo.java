package com.sunyf.ch01;

/**
 * @program: data-structures
 * @description: 菱形运算符
 * @author: sunyf
 * @create: 2018-11-19 10:03
 **/
public class BoxingDemo {

    public static void main(String[] args) {
        // 比较字符
        String str1 = "S";
        int i = str1.compareTo("Y");
        System.out.println(i);

        // 比较数字
        Integer i1 = 1, i2 = 50;
        int k = i1.compareTo(i2);
        System.out.println(k);
    }

}
