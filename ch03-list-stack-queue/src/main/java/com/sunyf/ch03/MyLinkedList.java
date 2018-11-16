package com.sunyf.ch03;

/**
 * @program: data-structures
 * @description: 链表列表
 * @author: sunyf
 * @create: 2018-11-15 20:09
 **/
public class MyLinkedList<T> {
    //
    private int theSize;
    private int modCount = 0;
    private Node<T> bgnMarker;
    private Node<T> endMarker;

    // 节点（内部类）
    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    // 清空
    public void clear() {
        doClear();
    }

    // 清空
    public void doClear() {
        //
        theSize = 0;
        modCount++;
        //
        bgnMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, bgnMarker, null);
        bgnMarker.next = endMarker;
    }

    // 大小
    public int size() {
        return theSize;
    }

    // 是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 添加元素（末端添加）
    public boolean add(T e) {
        add(size(), e);
        return true;
    }

    // 插入元素（中间插入）
    public void add(int idx, T e) {
        addBefore(getNode(idx, 0, size()), e);
    }

    // 取出元素
    public T get(int idx) {
        return getNode(idx).data;
    }

    // 更新元素
    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    // 删除元素
    public T remove(int idx) {
        return remove(getNode(idx));
    }

    // 插入头节点
    private void addBefore(Node<T> p, T e) {
        Node<T> newNode = new Node<>(e, p.prev, p);
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    // 删除
    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    // 获取元素
    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    // 获取元素
    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        //此处用了二分查找，提高效率
        if (idx < size() / 2) {
            p = bgnMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return  p;
    }


}

