/**
 * @program: data-structures
 * @description: 用单向链表实现栈
 * @author: Mr.Sun
 * @create: 2018-03-31 19:38
 **/
public class LinkedListSingleStackTest {
        private LinkedListSingleTest link;

        public LinkedListSingleStackTest(){
            link = new LinkedListSingleTest();
        }

        //添加元素
        public void push(Object obj){
            link.addHead(obj);
        }

        //移除栈顶元素
        public Object pop(){
            Object obj = link.delHead();
            return obj;
        }

        //判断是否为空
        public boolean isEmpty(){
            return link.isEmpty();
        }

        //打印栈内元素信息
        public void display(){
            link.display();
        }

}
