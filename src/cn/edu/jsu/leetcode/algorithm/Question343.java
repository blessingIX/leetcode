package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 整数拆分
 * @author: blessing
 * @create: 2020-09-17 15:41
 */
public class Question343 {
//    https://leetcode-cn.com/problems/integer-break/

    public int integerBreak(int n) {
//        https://leetcode-cn.com/submissions/detail/108955712/
        if (n == 0) return 0;
        int[] dpAdd = new int[n + 1];
        int[] dpMul = new int[n + 1];
        dpMul[0] = 1;
        for (int i = 1; i < dpMul.length; i++) {
            for (int j = 1; j < n; j++) {
                if (i- j < 0 || dpAdd[i - j] + j != i) {
                    continue;
                } else {
                    dpAdd[j] = i;
                }
                dpMul[i] = Math.max(dpMul[i - j] * j, dpMul[i]);
            }
        }
        return dpMul[n];
    }

    public int integerBreakHahaha(int n) {  // 说明: 你可以假设 n 不小于 2 且不大于 58。
//        全站最高效率解法（滑稽）
        return new int[]{0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243, 324, 486, 729, 972, 1458, 2187, 2916, 4374, 6561, 8748, 13122, 19683, 26244, 39366, 59049, 78732, 118098, 177147, 236196, 354294, 531441, 708588, 1062882, 1594323, 2125764, 3188646, 4782969, 6377292, 9565938, 14348907, 19131876, 28697814, 43046721, 57395628, 86093442, 129140163, 172186884, 258280326, 387420489, 516560652, 774840978, 1162261467, 1549681956}[n];
    }

    public static void main(String[] args) {
        Question343 question = new Question343();

        int[] cases = new int[]{
                2,
                10,
                0,
                1
        };
        for (int aCase : cases) {
            System.out.println(question.integerBreak(aCase));
        }
        System.out.println("hahaha");
        for (int aCase : cases) {
            System.out.println(question.integerBreakHahaha(aCase));
        }
    }

    public int[] hahaha() { // 说明: 你可以假设 n 不小于 2 且不大于 58。
        int[] res = new int[59];
        for (int i = 2; i < 59; i++) {
            res[i] = integerBreak(i);
        }
        return res;
    }
}
