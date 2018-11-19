package com.sunyf.ch03;

import java.util.Iterator;

/**
 * @program: data-structures
 * @description:
 * 简单数组链表的实现
 * @author: sunyf
 * @create: 2018-11-15 15:53
 **/
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;   // 元素个数
    private T[] theItems;  // 存储元素

    // 构造方法
    public MyArrayList() {
        doClear();
    }

    // 清除
    public void clear() {
        doClear();
    }

    // 清除
    private void doClear() {
        theSize = 0;
        // TODO:
        ensureCapacity(DEFAULT_CAPACITY);
    }

    // 元素个数
    public int size() {
        return theSize;
    }

    // 是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 释放多余的空间
    public void trimToSize() {
        ensureCapacity(size());
    }

    // 获取元素
    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    // 替换元素
    public T set(int idx, T newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    // 扩充容量
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }

        T[] old = theItems;
        // FIXME 不能创建一个泛型对象，所以用了转换
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    // 添加元素（末端添加）
    public boolean add(T e) {
        add(size(), e);
        return true;
    }

    // 添加元素（中间位置）
    public void add(int idx, T e) {
        if (theItems.length == size()) {
            // 扩充容量
            ensureCapacity(size() * 2 + 1);
        }
        // TODO 前面的元素不动，元素向后挪动
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = e;
        theSize ++;
    }

    // 删除元素
    public T remove(int idx) {
        T removeItem = theItems[idx];
        // TODO 前面的元素不动，元素向前移动
        for (int i = idx; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }

        theSize--;
        return removeItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    // 迭代器
    private class ArrayListIterator implements java.util.Iterator<T> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }

    /**
     * @program: data-structures
     * @description: 双端链表的实现
     * @author: Mr.Sun
     * @create: 2018-03-31 19:41
     **/
    public static class LinkedListDoubleTest {

        private Node head; //头节点
        private Node tail; //尾节点
        private int size; //节点的个数

        private class Node {
            private Object data;
            private Node next;

            public Node(Object data) {
                this.data = data;
            }
        }

        // 构造方法
        public LinkedListDoubleTest() {
            size = 0;
            head = null;
            tail = null;
        }

        //链表头新增节点
        public void addHead(Object data) {
            Node node = new Node(data);
            if (size == 0) {//如果链表为空，那么头节点和尾节点都是该新增节点
                head = node;
                tail = node;
                size++;
            } else {
                node.next = head;
                head = node;
                size++;
            }
        }

        //链表尾新增节点
        public void addTail(Object data) {
            Node node = new Node(data);
            if (size == 0) {//如果链表为空，那么头节点和尾节点都是该新增节点
                head = node;
                tail = node;
                size++;
            } else {
                tail.next = node;
                tail = node;
                size++;
            }
        }

        //删除头部节点，成功返回true，失败返回false
        public boolean deleteHead() {
            if (size == 0) {//当前链表节点数为0
                return false;
            }
            if (head.next == null) {//当前链表节点数为1
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            size--;
            return true;
        }

        //判断是否为空
        public boolean isEmpty() {
            return (size == 0);
        }

        //获得链表的节点个数
        public int getSize() {
            return size;
        }

        //显示节点信息
        public void display() {
            if (size > 0) {
                Node node = head;
                int tempSize = size;
                if (tempSize == 1) {//当前链表只有一个节点
                    System.out.println("[" + node.data + "]");
                    return;
                }
                //
                while (tempSize > 0) {
                    if (node.equals(head)) {
                        System.out.print("[" + node.data + "->");
                    } else if (node.next == null) {
                        System.out.print(node.data + "]");
                    } else {
                        System.out.print(node.data + "->");
                    }
                    node = node.next;
                    tempSize--;
                }
                System.out.println();
            } else {//如果链表一个节点都没有，直接打印[]
                System.out.println("[]");
            }
        }

        public static void main(String[] args) {
            LinkedListDoubleTest link = new LinkedListDoubleTest();
            //链表头新增
            link.addHead("A");
            link.addHead("B");
            link.addHead("C");
            //链表尾新增
            link.addTail("1");
            link.addTail("2");
            link.addTail("3");
            //打印
            link.display();
        }

    }
}
