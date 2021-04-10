package stacksAndQueues;
import java.util.Stack;
/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/4/8 11:22
 */
 
public class LeetCode20 {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='{' || c == '['  || c== '('){
                stack.push(c);
            }else {
                if(stack.empty())
                    return false;
                char topchar = stack.pop();
                if (c == ')' && topchar != '(')
                    return false;
                if (c == ']' && topchar != '[')
                    return false;
                if (c == '}' && topchar != '{')
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        System.out.println((new LeetCode20()).isValid("()[]{}"));
        System.out.println((new LeetCode20()).isValid("([)]"));
    }
}
