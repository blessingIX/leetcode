package cn.edu.jsu.leetcode.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 20. 有效的括号
 * @author: 易子建
 * @create: 2021-01-13 20:26
 */
public class Question20 {
//    https://leetcode-cn.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        if (s == null) return false;
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.addLast(s.charAt(i));
                continue;
            }
            if ((chars[i] == ')' && stack.size() > 0 && stack.getLast() == '(')
            || (chars[i] == ']' && stack.size() > 0 && stack.getLast() == '[')
            || (chars[i] == '}' && stack.size() > 0 && stack.getLast() == '{')) {
                stack.removeLast();
            } else return false;
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Question20 question = new Question20();
        String[] cases = new String[]{
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
                "",
                "]"
        };
        for (String aCase : cases) {
            System.out.println(aCase + " => " + question.isValid(aCase));
        }
    }
}
