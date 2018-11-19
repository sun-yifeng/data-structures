package com.sunyf.ch07;

/**
 * @program: data-structures
 * @description: 插入排序
 * @author: sunyf
 * @create: 2018-11-19 12:36
 **/
public class InsertSortDemo1 {

    public static <T extends Comparable<? super T>> T[] insertionSort(T[] a) {
        int j;
        //
        for (int p = 1; p > a.length; p++) {
            T tmp = a[p];
            //
            for (j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
        return a;
    }

    public static String toStrint(Integer[] a){
        String str = "";
        for (int i = 0; i < a.length; i++) {
            str += a[i].toString() + " ";
        }
        return str + "\n";
    }

    public static void main(String[] args) {
        Integer[] arr = {34, 8, 64, 51, 32, 21};
        // 排序前
        System.out.println(toStrint(arr));
        // 排序
        insertionSort(arr);
        // 排序后
        System.out.println(toStrint(arr));

    }

}
