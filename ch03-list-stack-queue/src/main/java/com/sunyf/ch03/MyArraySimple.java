package com.sunyf.ch03;

/**
 * @program: data-structures
 * @description: 无序数组：按照插入顺序排列，没有按照大小或者其他顺序排列
 * @author: Mr.Sun
 * @create: 2018-03-31 00:10
 **/
public class MyArraySimple {
    //定义数组
    private int[] intArray;
    //有效长度
    private int elems;
    //最大长度
    private int length;

    //默认构造一个长度为50的数组
    public MyArraySimple() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    //构造函数，初始化一个长度为length 的数组
    public MyArraySimple(int length) {
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    //获取数组的有效长度
    public int getSize() {
        return elems;
    }

    // 遍历数组
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    // 添加元素
    public boolean add(int value) {
        if (elems == length) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    // 获取元素
    public int get(int i) {
        if (i < 0 || i > elems) {
            System.out.println("访问下标越界");
        }
        return intArray[i];
    }


    // 查找元素
    public int find(int searchValue) {
        int i;
        for (i = 0; i < elems; i++) {
            if (intArray[i] == searchValue) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    // 删除元素
    public boolean delete(int value) {
        int k = find(value);
        if (k == -1) {
            return false;
        } else {
            if (k == elems - 1) {
                elems--;
            } else {
                for (int i = k; i < elems - 1; i++) {
                    intArray[i] = intArray[i + 1];
                    elems--;
                }
            }
            return true;
        }
    }

    // 修改元素
    public boolean modify(int oldValue, int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            System.out.println("需要修改的数据不存在");
            return false;
        } else {
            intArray[i] = newValue;
            return true;
        }
    }

    public static void main(String[] args) {
        //创建自定义封装数组结构，数组大小为4
        MyArraySimple array = new MyArraySimple(4);
        //添加4个元素分别是1,2,3,4
        array.add(1);
        array.add(3);
        array.add(2);
        array.add(4);
        //显示数组元素
        array.display();
        //根据下标为0的元素
        int i = array.get(0);
        System.out.println(i);
        //删除4的元素
        array.delete(4);
        //将元素3修改为33
        array.modify(3, 33);
        array.display();
    }
}
