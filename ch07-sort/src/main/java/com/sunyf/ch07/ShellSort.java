package com.sunyf.ch07;

/**
 * @program: data-structures
 * @description: 希尔排序
 * @author: sunyf
 * @create: 2018-11-19 16:53
 **/
public class ShellSort {

    public static int[] shellSort(int[] a) {
        //
        int j;
        //
        for (int gap = a.length / 2; gap > 0; gap /= 2 ) {
            //
            for (int i = gap; i < a.length; i++) {
                //
                int tmp = a[i];
                //
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap ) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }

        }

        return a;
    }

    public static String toString(int[] a) {
        String s = "";
        for (int i : a) {
            s += i + " ";
        }
        return s + "\n";
    }

    public static void main(String[] args) {
        //
        int[] a = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
        //
        System.out.println("gap值：" + a.length + "\n");
        System.out.println("gap/2:" + (a.length)/2 + "\n");
        //
        System.out.println("排序前：" + toString(a));
        shellSort(a);
        System.out.println("排序后：" + toString(a));
    }

}
