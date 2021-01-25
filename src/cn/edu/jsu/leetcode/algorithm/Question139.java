package cn.edu.jsu.leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 单词拆分
 * @author: blessing
 * @create: 2020-09-15 15:44
 */
public class Question139 {
//    https://leetcode-cn.com/problems/word-break/

    public boolean wordBreakTimout(String s, List<String> wordDict) {
//        超出时间限制
        if (s.equals(""))
            return true;
        boolean bool = false;
        for (String string : wordDict) {
            if (s.length() < string.length() || !s.substring(0, string.length()).equals(string)) {
                continue;
            }
            bool = (bool || wordBreak(s.substring(string.length()), wordDict));
        }
        return bool;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
//        动态规划。dp[i]表示字符串s的前i个字符能否拆分成wordDict。
//        https://leetcode-cn.com/submissions/detail/108464288/
        int n = s.length();
        boolean[] dp = new boolean[n];
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
        return dp[n-1];
    }

    public static void main(String[] args) {
        Question139 question = new Question139();

        String[][][] cases = new String[][][]{
                {{"leetcode"},{"leet","code"}},
                {{"applepenapple"},{"apple","pen"}},
                {{"catsandog"},{"cats","dog","sand","and","cat"}},
                {{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"},{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}}
        };

        for (String[][] aCase : cases) {
            System.out.println(question.wordBreak(aCase[0][0], new ArrayList<>(Arrays.asList(aCase[1]))));
        }
    }
}
