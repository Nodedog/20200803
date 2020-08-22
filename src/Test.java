import java.util.Stack;
/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

输入: "()"
输出: true
* 输入: "()[]{}"
输出: true
* 输入: "([)]"
输出: false
*
*
* */
public class Test {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ret = str.charAt(i);
            if (ret == '('|| ret == '{' || ret == '['){
                stack.push(ret);
                continue;//直接进入下一次循环
            }
            if (stack.empty()){
                return false;
            }
            Character tmp = stack.pop();
            if (tmp == '(' && ret == ')' ){
                continue;
            }
            if (tmp == '[' && ret == ']'){
                continue;
            }
            if (tmp == '{' && ret == '}'){
                continue;
            }
            return false;
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
