package com.sunyf.ch07;

/**
 * @program: data-structures
 * @description:插入排序,此栗子来源于网络，用while循环实现插入排序；
 *
 * 1、插入排序：在排序过程中是局部有序的（部分项是有序的），在插入过程中局部被整体移动；
 * 2、位置p上的元素存在一个临时变量tmp中;每轮外层循环完成之后再将tmp放到合适位置
 * 3、外层循环从位置1开始自增；内存循环总位置p开始自减；
 *
 * @author: Mr.Sun
 * @create: 2018-03-31 10:05
 **/
public class InsertSortDemo2 {

    public static int[] sort(int[] array) {

        // 从下标为1的元素开始比较，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i]; //保存当前元素
            int j = i;
            /**
             *用当前元素跟前一个元素比较，如果当前元素小，则把前一个元素移动到当前位置（此时数组中会有两个相同的元素）
             *一直这样做比较，直到当前元素不小于前一个元素，每次比较完成之后，j--保证跟当前元素比较的元素是向前移动的
             **/
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1]; //当前元素替换成数组的前一个元素
                j--; //
            }
            //在这里确定当前元素的位置
            array[j] = tmp;
        }
        return array;
    }

    // 遍历显示数组
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
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
    }
}
