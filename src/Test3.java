import java.util.Stack;

public class Test3 {
    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    //入队列
    public void offer(int x ){
        while (!stack2.isEmpty()){
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        stack1.push(x);
    }

    //出队列
    public Integer poll(){
        if (empty()){
            return null;
        }
        while (!stack1.isEmpty()){
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        return stack2.pop();
    }

    //取队首元素
    public Integer peek(){
        if (empty()){
            return null;
        }
        while (!stack1.isEmpty()){
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        return stack2.peek();
    }

    //判断是否为空
    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
