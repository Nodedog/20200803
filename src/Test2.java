import java.util.Queue;
import java.util.LinkedList;
/*
*使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空

*你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size,
*  和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 
* , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。


*
*
* */
public class Test2 {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new  LinkedList<>();
    //入栈
    public void push(int x){
        queue1.offer(x);
    }

    //出栈
    public Integer pop(){
        if (empty()){
            return null;
        }
        while (queue1.size() > 1){
            Integer ret = queue1.poll();
            queue2.offer(ret);
        }
        swap(queue1,queue2);
        return queue1.poll();
    }

    private void swap(Queue<Integer> queue1, Queue<Integer> queue2) {
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    //取栈顶元素
    public Integer top(){
        if (empty()){
            return null;
        }
        while (queue1.size() > 1){
            Integer ret = queue1.poll();
            queue2.offer(ret);
        }
        int ret = queue1.poll();
        queue2.offer(ret);//top和pop唯一的区别
        swap(queue1,queue2);
        return queue1.poll();
    }

    //判断栈是否为空
    public boolean empty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
