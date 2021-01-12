package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 零钱兑换
 * @author: blessing
 * @create: 2020-09-17 11:29
 */
public class Question322 {
//    https://leetcode-cn.com/problems/coin-change/

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);    // 面值最小1，所以凑出amount最多需要amount个硬币
        dp[0] = 0;  // 无法凑出amount=0，所以dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue; // 面值超过需凑的amount
                dp[i] = Math.min(1 + dp[i - coin], dp[i]);
                // dp[i]表示凑出金额i的最优解。
                // 若现在需要添加一枚面值为coin的硬币，
                // 则在金额 i-coin 的最优解dp[i-coin]的基础上添加一枚面值为coin的硬币得到凑出金额i的最优解（1 + dp[i - coin]）
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Question322 question = new Question322();

        int[][] coinsCases = new int[][]{
                {1,2,5},
                {2}
        };
        int[] amountCases = new int[]{11, 3};
        for (int i = 0; i < coinsCases.length; i++) {
            System.out.println(question.coinChange(coinsCases[i], amountCases[i]));
        }
    }
}
