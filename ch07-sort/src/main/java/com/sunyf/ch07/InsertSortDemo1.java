package com.sunyf.ch07;

/**
 * @program: data-structures
 * @description:
 *
 * 1、插入排序，此栗子来自《数据结构与算法分析》P187
 * 2、用for循环实现插入排序
 *
 * @author: sunyf
 * @create: 2018-11-19 12:36
 **/
public class InsertSortDemo1 {

    public static <T extends Comparable<? super T>> T[] insertionSort(T[] a) {
        int j;
        // 外层循环，从1开始自增
        for (int p = 1; p < a.length; p++) {
            // 先将p位置上的数据暂存
            T tmp = a[p];
            // 内存循环，从p开始自减
            for (j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--){
                //t
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
        return a;
    }

    public static String toString(Integer[] a){
        String str = "";
        for (int i = 0; i < a.length; i++) {
            str += a[i].toString() + " ";
        }
        return str + "\n";
    }

    public static void main(String[] args) {
        Integer[] arr = {34, 8, 64, 51, 32, 21};
        // 排序前
        System.out.println("排序前:" + toString(arr));
        // 排序
        insertionSort(arr);
        // 排序后
        System.out.println("排序后:" + toString(arr));

    }

}
