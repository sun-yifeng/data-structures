package com.sunyf.ch03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structures
 * @description: 操作list
 * @author: sunyf
 * @create: 2018-11-15 14:39
 **/
public class MakeList {

    // 在list的末端插入元素
    public static void makeList1(List<Integer> list, int n) {
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    // 在list的前端插入元素
    public static void makeList2(List<Integer> list, int n) {
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
    }

    // 在list中求和
    public static int makeList3(List<Integer> list) {
        int total = 0;
        int length = list.size();
        for (int i = 0; i < length; i++) {
            total += list.get(i);
        }
        return total;
    }

    public static void main(String[] args) {
        int _n = 99999;
        long l1 = 0l;
        long l2 = 0l;
        //
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
        // 1、在末端添加元素
        l1 = System.currentTimeMillis();
        MakeList.makeList1(list1, _n);
        l2 = System.currentTimeMillis();
        System.out.println("数组，在末端添加元素耗费的时间：" + (l2-l1));

        l1 = System.currentTimeMillis();
        MakeList.makeList1(list2, _n);
        l2 = System.currentTimeMillis();
        System.out.println("链表，在末端添加元素耗费的时间：" + (l2-l1));

        // 2、在前端添加元素
        l1 = System.currentTimeMillis();
        MakeList.makeList2(list1, _n);
        l2 = System.currentTimeMillis();
        System.out.println("数组，在前端添加元素耗费的时间：" + (l2-l1));

        l1 = System.currentTimeMillis();
        MakeList.makeList2(list2, _n);
        l2 = System.currentTimeMillis();
        System.out.println("链表，在前端添加元素耗费的时间：" + (l2-l1));


        // 3、在List中求和
        l1 = System.currentTimeMillis();
        int sum1 = MakeList.makeList3(list1);
        l2 = System.currentTimeMillis();
        System.out.println("数组，求和耗费的时间：" + (l2-l1) + ",sum1:" + sum1);

        l1 = System.currentTimeMillis();
        int sum2 = MakeList.makeList3(list2);
        l2 = System.currentTimeMillis();
        System.out.println("链表，求和耗费的时间：" + (l2-l1) + ",sum2:" + sum2);
    }
}

/** output
 数组，在末端添加元素耗费的时间：10
 链表，在末端添加元素耗费的时间：9
 数组，在前端添加元素耗费的时间：1190
 链表，在前端添加元素耗费的时间：25
 数组，求和耗费的时间：9,sum1:704882705
 链表，求和耗费的时间：7237,sum2:704882705
**/
