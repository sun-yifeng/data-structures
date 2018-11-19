package com.sunyf.ch03;

/**
 * @program: data-structures
 * @description: 优先级队列
 * @author: Mr.Sun
 * @create: 2018-03-31 16:59
 **/
public class QueuePriorityTest {
    private int maxSize; // 队列总大小
    private int[] priQueArray; // 队列数组
    private int nItems; // 实际元素个数

    public QueuePriorityTest(int s) { //构造方法
        maxSize = s;
        priQueArray = new int[maxSize];
        nItems = 0;
    }

    //插入数据
    public void insert(int value) {
        //一个元素不用排序
        if (nItems == 0) {
            priQueArray[nItems++] = value;
            return;
        }
        //多个元素需要排序
        int j = nItems - 1; // 数组最大下标
        //插入排序，按照从大到小的顺序排列，越小的越在队列的顶端
        while (j >= 0 && value > priQueArray[j]) {
            priQueArray[j + 1] = priQueArray[j];
            j--;
        }
        priQueArray[j + 1] = value;
        //插入完元素，个数自增
        nItems++;

    }

    //移除数据,由于是按照大小排序的，所以移除数据我们指针向下移动
    //被移除的地方由于是int类型的，不能设置为null，这里的做法是设置为 -1
    public int remove() {
        int value = priQueArray[nItems - 1]; //暂存要删除的元素
        priQueArray[nItems - 1] = -1; //-1表示这个位置的数据被移除了
        nItems--; // 实际个数自减
        return value;
    }

    //查看优先级最高的元素
    public int peekMin() {
        return priQueArray[nItems - 1];
    }

    //判断是否为空
    public boolean isEmpty() {
        return (nItems == 0);
    }

    //判断是否满了
    public boolean isFull() {
        return (nItems == maxSize);
    }

    //打印
    public String toString() {
        String str = "";
        for (int i = 0; i < priQueArray.length; i++) {
            str += priQueArray[i] + ",";
        }
        return str;
    }

    public static void main(String[] args) {
        QueuePriorityTest queue = new QueuePriorityTest(10);
        queue.insert(4);
        queue.insert(7);
        queue.insert(10);
        queue.insert(3);
        queue.insert(5);
        queue.insert(2);
        queue.insert(9);
        queue.insert(1);
        //
        System.out.println(queue);
    }
}
