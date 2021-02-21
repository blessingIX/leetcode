package cn.edu.jsu.leetcode.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 22. 括号生成
 * @author: blessing
 * @create: 2021-02-21 13:50
 */
public class Question22 {
//    https://leetcode-cn.com/problems/generate-parentheses/

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        func(res, "", 0, 0, n);
        return res;
    }

    public void func(List<String> res, String str, int l, int r, int n) {
        if (l > n || r > n || r > l) return;
        if (l == n && r == n) {
            res.add(str);
            return;
        }
        func(res, str + '(', l + 1, r, n);
        func(res, str + ')', l, r + 1, n);
    }

    public static void main(String[] args) {
        Question22 question = new Question22();
        System.out.println(question.generateParenthesis(3));
    }

}
