package leetcode.algorithm.section6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaoxq
 * @ClassName Solution150
 * @description: 逆波兰表达式求值
 * @date 2024年03月01日
 * <p>
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 *
 * 提示：
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 */

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        String[] operators = {"+", "-", "*", "/"};
        List<String> strings = Arrays.asList(operators);
        for (String token : tokens) {
            if (strings.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                if ("+".equals(token)) {
                    stack.push(a + b);
                } else if("-".equals(token)){
                    stack.push(a - b);
                } else if("*".equals(token)){
                    stack.push(a * b);
                } else if("/".equals(token)){
                    stack.push(a / b);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int idx = -1;
    public int evalRPN2(String[] tokens) {
        idx = tokens.length-1;
        return eval(tokens);
    }
    private int eval(String[] tokens) {
        String op = tokens[idx];
        idx -= 1;

        if ("+".equals(op)) {
            return eval(tokens) + eval(tokens);
        } else if ("-".equals(op)) {
            return -(eval(tokens)-eval(tokens)) ;
        } else if ("*".equals(op)) {
            return eval(tokens) * eval(tokens);
        } else if ("/".equals(op)) {
            int x = eval(tokens);
            return eval(tokens) / x;
        } else {
            return Integer.parseInt(op);
        }
    }

    @Test
    public void test(){
        String[] a ={"4","13","5","/","+"};
        evalRPN(a);
    }
}
