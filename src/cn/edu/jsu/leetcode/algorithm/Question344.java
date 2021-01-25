package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description:
 * @author: blessing
 * @create: 2021-01-25 20:05
 */
public class Question344 {
//    https://leetcode-cn.com/problems/reverse-string/

    public void reverseString(char[] s) {
        if (s == null || s.length < 2) return;
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Question344 question = new Question344();
        char[][] cases = new char[][]{
                {'h','e','l','l','o'},
                {'H','a','n','n','a','h'}
        };
        int num = 1;
        for (char[] aCase : cases) {
            System.out.printf("=====case%d=====\n", num++);
            System.out.println(Arrays.toString(aCase));
            question.reverseString(aCase);
            System.out.println(Arrays.toString(aCase));
        }
    }
}
