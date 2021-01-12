package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 最长回文子串
 * @author: blessing
 * @create: 2020-08-14 09:14
 */
public class Question5 {
//    https://leetcode-cn.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int maxLen = 1;
        char[] chars = s.toCharArray();
        int len = s.length();
        if (len == 0) return "";
        boolean[][] dp = new boolean[len+1][len];
        for (int i = 0; i < len; i++) {
            dp[1][i] = true;
            dp[0][0] = true;
            if (checkBound(i, 2, len) && chars[i] == chars[i + 1]) {
                dp[2][i] = true;
                dp[0][1] = true;
                maxLen = 2;
            }
        }
        for (int i = 3; i <= len; i++) {
            if (!dp[0][i-2-1]) continue;
            for (int j = 0; j < len; j++) {
                if (!dp[i-2][j]) continue;
                if (checkBound(j-1, i, len) && chars[j-1] == chars[j-1+i-1]) {
                    dp[i][j-1] = true;
                    dp[0][i-1] = true;
                    maxLen = i;
                }
            }
        }
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (dp[maxLen][i]) {
                start = i;
                break;
            }
        }
        return s.substring(start, start+maxLen);
    }

    public boolean checkBound(int offset, int len, int l) {
        if (offset < 0)
            return false;
        return offset + len <= l;
    }

    public boolean checkPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) return false;
        if (len == 1) return true;
        if (len == 2) return chars[0] == chars[1];
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len-i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question5 question = new Question5();
        System.out.println(question.longestPalindrome("babad"));
        System.out.println(question.longestPalindrome("cbbd"));
        System.out.println(question.longestPalindrome("aba"));
        System.out.println(question.longestPalindrome("bb"));
        System.out.println(question.longestPalindrome("ab"));
        System.out.println(question.longestPalindrome("a"));
        System.out.println(question.longestPalindrome(""));

//        checkPalindrome
//        System.out.println(question.checkPalindrome("a"));
//        System.out.println(question.checkPalindrome("aa"));
//        System.out.println(question.checkPalindrome("ab"));
//        System.out.println(question.checkPalindrome("aba"));
//        System.out.println(question.checkPalindrome("abc"));
//        System.out.println(question.checkPalindrome("abba"));
    }
}
