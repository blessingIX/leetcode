package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 14- I. 剪绳子
 * @author: 易子建
 * @create: 2021-01-12 13:11
 */
public class CodingInterviews14_1 {
//    https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
//    与 https://leetcode-cn.com/problems/integer-break/ 相同

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CodingInterviews14_1 codingInterviews = new CodingInterviews14_1();
        int[] cases = new int[]{
                2, 10
        };

        for (int aCase : cases) {
            System.out.println(aCase + " => " + codingInterviews.cuttingRope(aCase));
        }
    }
}
