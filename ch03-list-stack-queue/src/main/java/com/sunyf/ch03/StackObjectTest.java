package com.sunyf.ch03;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @program: data-structures
 * @description: 栈，可以存任意对象，可以扩容（一倍）
 * @author: Mr.Sun
 * @create: 2018-03-31 13:35
 **/
public class StackObjectTest {
    //存储元素的数组,声明为Object类型能存储任意类型的数据
    private Object[] elementData;
    //指向栈顶的指针
    private int top;
    //栈的总容量
    private int size;


    //默认构造一个容量为10的栈
    public StackObjectTest() {
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public StackObjectTest(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("栈初始容量不能小于0: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.top = -1;
        this.size = initialCapacity;
    }


    //压入元素
    public Object push(Object item) {
        //是否需要扩容
        isGrow(top + 1);
        elementData[++top] = item;
        return item;
    }

    //弹出栈顶元素
    public Object pop() {
        Object obj = peek();
        remove(top);
        return obj;
    }

    //获取栈顶元素
    public Object peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return (top == -1);
    }

    //删除栈顶元素
    public void remove(int top) {
        //栈顶元素置为null
        elementData[top] = null;
        this.top--;
    }

    //是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
    public boolean isGrow(int minCapacity) {
        int oldCapacity = size;
        //如果当前元素压入栈之后总容量大于前面定义的容量，则需要扩容
        if (minCapacity >= oldCapacity) {
            //定义扩大之后栈的总容量
            int newCapacity = 0;
            //栈容量扩大两倍(左移一位)看是否超过int类型所表示的最大范围
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = (oldCapacity << 1);//左移一位，相当于*2
            }
            //新的容量
            this.size = newCapacity;
            //
            //int[] newArray = new int[size];
            elementData = Arrays.copyOf(elementData, size);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        com.sunyf.ch03.StackObjectTest stack = new com.sunyf.ch03.StackObjectTest();
//        String str = "how are you";
//        char[] cha = str.toCharArray();
//        for (char c : cha) {
//            stack.push(c);
//        }
//        while (!stack.isEmpty()) {
//            System.out.print(stack.pop());
//        }

        //
        StackObjectTest stack = new StackObjectTest(3);
        String str = "12<a[b{c}]>";
        char[] cha = str.toCharArray();
        for(char c : cha){
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if(!stack.isEmpty()){
                        char ch = stack.pop().toString().toCharArray()[0];
                        if(c=='}' && ch != '{' || c==']' && ch != '[' || c==')' && ch != '('){
                            System.out.println("Error:"+ch+"-"+c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}