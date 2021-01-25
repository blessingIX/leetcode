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

//    花花酱LeetCode: https://www.bilibili.com/video/BV18J411j7Pb
    /**
     * 求最长回文子串 By花花酱
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindromeHuahua(String s) {
//        https://leetcode-cn.com/submissions/detail/141008070/
//        思路：遍历字符串，每次取一个字符或两个字符（回文有奇偶两种长度的情况），并将其不断向外扩展判断是否是回文，最后得到最长回文的起始下标和长度
        int len = 0;    // 初始最长回文长度0
        int start = 0;  // 初始最长回文起始下标
        for (int i = 0; i < s.length(); i++) {  // 遍历字符串
            // getLen(s, i, i) 对应回文长度为奇数的情况
            // getLen(s, i, i + 1) 对应回文长度为偶数的情况
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));   // 取两种情况的最大值
            if (cur > len) {    // 更新最长回文串的长度和起始下标
                len = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + len); // 截取最长回文串
    }

    /**
     * 以给定的[l,r]子串为基准不断向外扩展得出最长的回文串长度
     * @param s 原始字符串
     * @param l 左端点下标
     * @param r 右端点下标
     * @return 最长的回文串长度
     */
    private int getLen(String s, int l, int r) {
        // 回文的特点：在s[l+1, r-1]满足回文的情况下，若s[l]==s[r]，则s[l,r]也是回文（利用此特点减少计算）
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {    // 若l或r未越界则判断s[l]是否等于s[r],若相等表明s[l~r]是回文
            // 满足回文串条件，尝试向外扩展
            l--;
            r++;
        }
        return r - l - 1;   // 退出循环后，l和r要么越界，要么移动超过符合回文要求的位置所以需要 -1
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
