package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 分割回文串
 * @author: blessing
 * @create: 2021-01-25 12:39
 */
public class Question131 {
//    https://leetcode-cn.com/problems/palindrome-partitioning/

    public List<List<String>> partition(String s) {
//        代码参考：LeetCode题解
//        回溯    全排列
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) { // 空字符串不用计算，直接返回空的list
            return res;
        }
        Stack<String> path = new Stack<>(); // 通过画出递归树可知，将字符创进行拆分成n个子串，stack用于保存拆分过程中的子串
        backtracking(s, 0, len, path, res); // 进行回溯
        return res;
    }

    /**
     * 回溯拆分出多个子串
     * @param s 原始字符串
     * @param start 剩余未截取字符串的起始下标在原始字符串中的下标
     * @param len 剩余未截取字符串的长度
     * @param path 用于存储子串的路径栈
     * @param res 符合题目要求的结果集
     */
    public void backtracking(String s, int start, int len, Stack<String> path, List<List<String>> res) {
        if (start == len) { // 当子串截取起点超过原始字符串的长度时，能走到这一步说明前边所有的子串都符合回文串的要求
            res.add(new ArrayList<>(path)); // 将路径栈中的元素创建为一个新的list存入结果集
            return;
        }
        for (int i = start; i < len; i++) { // 截取start-i的子串
            if (!isPalindrome(s, start, i)) {   // 若不是回文进行剪枝，提高效率
                continue;
            }
            path.push(s.substring(start, i + 1));   // 当前start-i的子串符合回文要求加入路径栈
            backtracking(s, i + 1, len, path, res); // 递归，继续讲剩余的字符串(i+1, len)进行拆分
            path.pop(); // 当前start~i的子串弹栈
        }
    }

    /**
     * 判断字符串是否是回文串
     * @param s 需验证的字符串
     * @param left 截取的左端点
     * @param right 截取的右端点
     * @return 是否是回文串
     */
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

//    TODO: 使用DP进行优化，可参考第5题（已解决）

    public static void main(String[] args) {
        Question131 question = new Question131();
        String[] cases = new String[]{
                "ababa"
        };

        for (String aCase : cases) {
            System.out.println(question.partition(aCase));
        }
    }
}
