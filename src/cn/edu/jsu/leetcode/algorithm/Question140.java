package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 单词拆分 II
 * @author: blessing
 * @create: 2021-01-25 16:46
 */
public class Question140 {
//    https://leetcode-cn.com/problems/word-break-ii/

    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (n >= word.length() && s.substring(0, word.length()).equals(word)) {
                dp[word.length() - 1] = true;

            }
        }
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            for (String word : wordDict) {
                if (i + word.length() < n) {    // 剩余字符串长度足够与字典中单词进行比较
                    String substring = s.substring(i + 1, i + 1 + word.length());   // i + 1 位置开始与字典中单词长度相同的子串
                    if (substring.equals(word)) {
                        dp[i + word.length()] = true;   // dp[i]表示字符串s的前i个字符能否拆分成wordDict。
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
