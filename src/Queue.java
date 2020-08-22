/*
*           队列
*
*
* */
public class Queue {
    static class Node{
        public int data;
        Node next = null;

        public Node(int data){
            this.data = data;
        }
    }


    private Node head = null;
    private Node tail = null;

    //入队列
    public void offer(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }


    //出队列
    public Integer poll() {
        if (head == null){
            return null;
        }
        int ret = head.data;
        head = head.next;
        if (head == null){
            //删除当前元素之后，如果变成空队列
            tail = null;
        }
        return ret;
    }


    //取队首元素
    public Integer peek(){
        if (head == null ){
            return null;
        }
        return head.data;
    }

}
