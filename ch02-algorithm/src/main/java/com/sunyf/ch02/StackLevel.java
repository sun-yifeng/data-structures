package com.sunyf.ch02;

/**
 * @program: data-structures
 * @description: 栈深度
 * @author: sunyf
 * @create: 2018-11-15 01:37
 *
 * -Xms20m -Xmx200m -XX:+HeapDumpOnOutOfMemoryError
 *
 **/
public class StackLevel {

    private int count = 0;

    public void level() {
        count ++;
        level();
    }

    public void test() {
        try {
            level();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("java虚拟机栈深度：" + count);
        }
    }

    public static void main(String[] args) throws Exception {
        //
        long l1 = Runtime.getRuntime().maxMemory(); //最大可用内存，对应-Xmx
        long l2 = Runtime.getRuntime().freeMemory(); //当前JVM空闲内存
        long l3 = Runtime.getRuntime().totalMemory(); //当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和

        System.out.println("当前最大可用堆内存:" + l1);
        System.out.println("当前可用空闲的内存:" + l2);
        System.out.println("当前占用虚拟机内存:" + l3);

        //new StackLevel().test();
        //System.out.println(System.getProperties());

    }
}
