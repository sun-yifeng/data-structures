package com.sunyf.ch07;

/**
 * @program: data-structures
 * @description: 冒泡排序算法
 *
 * 1、每次比较相邻的元素，如果大的元素在数组后面，大的往前移动（向上浮动）；
 * 2、外层循环从0开始递增，内存循环从length-1开始递减；
 * 2、内存循环j，要大于外层循环i（j>i）；因为前面i个元素已经排好序了；
 *
 * @author: Mr.Sun
 * @create: 2018-03-31 01:17
 **/
public class BubbleSortTest {

    public static int[] sort(int[] array) {
        //外层循环:控制循环的次数
        for (int i = 0; i < array.length - 1; i++) {
            //设定一个标记
            boolean flag = true;
            int temp = 0;
            //内存循环：控制比较次数。相邻的两个元素做比较，
            for (int j = array.length - 1; j > i; j--) {
                //每次比较相邻的元素，如果大的元素在数组后面，大的往前移动（向上浮动）
                if (array[j - 1] < array[j]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("第" + i + "轮不需要排序");
                break;
            }
            //第i轮排序的结果为
            System.out.print("第" + i + "轮排序后的结果为:");
            display(array);

        }
        return array;

    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // 定义数组
        int[] array = {4, 2, 8, 9, 5, 1, 6, 7, 3};
        //排序前的数组顺序为
        System.out.print("排序前的数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);

    }



}