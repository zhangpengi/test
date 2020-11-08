import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//股票价格跨度
class StockSpanner {
    Stack<Integer> prices;//存储价格
    Stack<Integer> weight;//存储在当前价格下 <= price 的个数
    public StockSpanner() {
        prices = new Stack<>();
        weight = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weight.pop();
        }
        prices.push(price);
        weight.push(w);
        return w;
    }
}
//逆波兰表达式
class Solution1 {
    Stack<Integer> stack = new Stack<>();
    int i = 0, left, right;
    public int evalRPN(String[] tokens) {
        while (i < tokens.length) {
            String str = tokens[i];
            if (str.equals("*")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left * right);
            }
            if (str.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left / right);
            }
            if (str.equals("+")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left + right);
            }
            if (str.equals("-")) {
                right = stack.pop();
                left = stack.pop();
                stack.push(left - right);
            }
            i++;
        }
        return stack.pop();

    }
}


//栈的压入和弹出1
class Solution2 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0,j = 0;
        while (i <= pushA.length) {
            if (pushA[i] != popA[j]){
                stack.push(pushA[i]);
                ++i;
            }else {
                stack.pop();
                ++i;
                ++j;
                if (popA[j] == stack.peek()) {
                    ++j;
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
////栈的压入和弹出2改进
class Solution3 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack1 = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack1.push(pushA[i]);
            while (!stack1.isEmpty() && stack1.peek() == popA[j]) {
                stack1.pop();
                j++;
            }
        }
        return stack1.isEmpty();
    }
}
//棒球比赛
class Solution4 {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String str = ops[i];
            if ("C".equals(str)) {
                st.pop();
            }else if ("D".equals(str)) {
                st.push(st.peek()*2);
            }else if ("+".equals(str)) {
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a+b);
            }else {
                st.push(Integer.valueOf(str));
            }
        }
        while (!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}
//比较含退格的字符串是否相等
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] str1 = S.toCharArray();
        char[] str2 = T.toCharArray();
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == '#') {
                st1.pop();
            }else {
                st1.push(str1[i]);
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if (str2[i] == '#') {
                st2.pop();
            }else {
                st2.push(str2[i]);
            }
        }
        for (int i = 0; i < st1.size(); i++ ) {
            for (int j = 0; j < st2.size(); j++) {
                if (st1.pop().equals(st2.pop())) {
                    st1.pop();
                    st2.pop();
                }
            }
        }
        while (st1.isEmpty() && st2.isEmpty()) {
            return true;
        }
        return false;
    }
}


public class Test {

    public static void main2(String[] args) {
        Solution4 solution = new Solution4();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPoints(ops));
    }
    public static void main1(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(10));
    }
}
