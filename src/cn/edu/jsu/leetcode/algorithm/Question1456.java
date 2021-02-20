package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 1456. 定长子串中元音的最大数目
 * @author: blessing
 * @create: 2021-02-20 13:48
 */
public class Question1456 {
//    https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

    public static char[] yy = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int maxVowels(String s, int k) {
        if (s == null || "".equals(s)) return 0;
        int max = 0;
        int len = s.length() - k + 1;
        char[] chars = s.toCharArray();

        int l = 0, r = k - 1;
        for (int i = 0; i < k; i++) {
            if (yy(chars[i])) max++;
        }
        int count = max;
        while (true) {
            if (yy(chars[l++])) count--;
            if (l >= len) break;
            if (yy(chars[++r])) count++;
            max = Math.max(max, count);
        }
        return max;
    }

    public boolean yy(char ch) {
        for (char c : yy) {
            if (ch == c) return true;
        }
        return false;
    }
}
