package com.sunyf.ch03;

/**
 * @program: data-structures
 * @description: 栈
 * @author: Mr.Sun
 * @create: 2018-03-31 13:16
 **/
public class StackTest {

    private int[] array; //数组
    private int maxSize; //栈的最大长度
    private int top;     //栈顶（实际长度）

    //构造方法
    public StackTest(int size) {
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    //压入数据
    public void push(int value) {
        if (top < maxSize - 1) {// 数组下标不能越界
            array[++top] = value;
        }
    }

    //弹出栈顶数据
    public int pop() {
        return array[top--];
    }

    //访问栈顶数据
    public int peek() {
        return array[top];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return (top == -1);
    }

    //判断栈是否满了
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackTest stack = new StackTest(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 查看栈顶元素
        System.out.println("查看栈顶元素：" + stack.peek());
        // 打印全部元素
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        //
        System.out.println("栈是否为空："+stack.isEmpty());

    }
}
