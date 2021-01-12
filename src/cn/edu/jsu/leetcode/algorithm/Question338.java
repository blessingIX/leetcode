package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:  比特位计数
 * @author: blessing
 * @create: 2020-09-17 14:54
 */
public class Question338 {
//    https://leetcode-cn.com/problems/counting-bits/
//    各个2的幂的二进制中 1 的个数都是 1。而处于这些2的幂之间的数的二进制的 1 的个数有如下规律：
//    i 的二进制中 1 的个数 = (i -【小于i且最大的2的幂】)的二进制中 1 的个数 + 1

    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        if (num == 1) return new int[]{0, 1};
        int[] dp = new int[num + 1];
        dp[1] = 1;
        int s = 1;
        int l = s * 2;
        for (int i = 2; i < dp.length; i++) {
            if (i == l) {
                dp[i] = 1;
                s = l;
                l *= 2;
                continue;
            }
            dp[i] = dp[i - s] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        Question338 question = new Question338();

        int[] cases = new int[]{
                2,
                5,
                16,
                0,
                1
        };
        for (int aCase : cases) {
            System.out.println(Arrays.toString(question.countBits(aCase)));
        }
    }
}
