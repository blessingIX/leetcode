package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 541. 反转字符串 II
 * @author: blessing
 * @create: 2021-01-25 20:17
 */
public class Question541 {
//    https://leetcode-cn.com/problems/reverse-string-ii/

    public String reverseStr(String s, int k) {
        if (s == null || "".equals(s)) return s;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = k - 1;
        while (start < s.length()) {
            if (end >= s.length()) end = s.length() - 1;
            reverseStr(chars, start, end);
            start += 2 * k;
            end += 2 * k;
        }
        return new String(chars);
    }

    public void reverseStr(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Question541 question = new Question541();
        String[] cases = new String[]{
                "abcdefg",
                "haseenotebook"
        };
        int[] ks = new int[]{
                2,
                2
        };
        for (int i = 0; i < cases.length; i++) {
            System.out.printf("=====case%d=====\n", i + 1);
            System.out.println(cases[i]);
            System.out.println(question.reverseStr(cases[i], ks[i]));
        }
    }
}
