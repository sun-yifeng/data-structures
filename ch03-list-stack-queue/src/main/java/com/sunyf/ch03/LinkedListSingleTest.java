package com.sunyf.ch03;

/**
 * @program: data-structures
 * @description: 单向链表
 * @author: Mr.Sun
 * @create: 2018-03-31 17:59
 **/
public class LinkedListSingleTest {

    private int size; //链表节点的个数
    private Node head; //头节点

    public LinkedListSingleTest() {
        size = 0;
        head = null;
    }

    //链表的每个节点类（内部类）
    private class Node {
        private Object data; //每个节点的数据
        private Node next;   //每个节点指向上一个节点（不是下一个的意思）

        //节点构造方法
        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj); //新节点
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head; //新节点的next指向原来的节点位置
            head = newHead; //当前节点为新节点
        }
        size++;
        return obj;
    }

    //在链表头删除元素，返回删除的节点
    public Object delHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null
    public Node find(Object obj) {
        Node current = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功返回true
    public boolean delete(Object value) {
        if (size == 0) {
            return false;
        }
        Node current = head; //当前节点
        Node previous = head; //上一个节点
        // 取当前节点、下一个节点
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //如果删除的节点是第一个节点
        if (current == head) {
            head = current.next;
            size--;
        } else {//删除的节点不是第一个节点
            previous.next = current.next;
            size--;
        }
        return true;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    //显示节点信息
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            //链表有一个节点
            if (tempSize == 1) {
                System.out.println("[" + node.data + "]");
                return;
            }
            //链表有多个节点
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
        } else {
            //如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }

    public static void main(String[] args) {
        LinkedListSingleTest singleList = new LinkedListSingleTest();
        singleList.addHead("A");
        singleList.addHead("B");
        singleList.addHead("C");
        singleList.addHead("D");
        singleList.addHead("E");
        singleList.addHead("F");
        //打印当前链表信息
        singleList.display();
        //删除C
        singleList.delete("C");
        singleList.display();
        //查找B
        System.out.println(singleList.find("B"));
        //删除头元素
        singleList.delHead();
        singleList.display();
        //链表是否为空
        System.out.println(singleList.isEmpty());
    }

}