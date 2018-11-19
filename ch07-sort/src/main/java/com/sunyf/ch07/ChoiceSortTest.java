package com.sunyf.ch07;

/**
 * @program: data-structures
 * @description: 选择排序
 *
 * 1、在首轮选择最大的数放在第一项，一轮之后第一项是有序的了，第二轮从第二项开始，以此类推，直到整个数组完全有序
 * 2、外层循环，从0开始自增；内存循环，从i+1开始自增
 * 3、先记录下外形循环的下标，做比较，不做数据交换；
 *
 * @author: Mr.Sun
 * @create: 2018-03-31 09:55
 **/
public class ChoiceSortTest {

    public static int[] sort(int[] array) {
        //外层循环，从0开始自增
        for (int i = 0; i < array.length - 1; i++) {
            //记录外层循环
            int min = i;
            //内存循环，从i+1开始自增
            for (int j = i + 1; j < array.length; j++) {
                //如果后面的项小于前面的项
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            //第i轮排序的结果为
            System.out.print("第" + (i + 1) + "轮排序后的结果为:");
            display(array);
        }
        return array;
    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = sort(array);
        System.out.println("-----------------------");
        System.out.println("经过选择排序后的数组顺序为：");
        display(array);
    }
}
