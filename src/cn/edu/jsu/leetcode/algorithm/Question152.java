package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 乘积最大子数组
 * @author: blessing
 * @create: 2020-09-16 09:32
 */
public class Question152 {
//    https://leetcode-cn.com/problems/maximum-product-subarray/

    public int maxProductWrongAnswer(int[] nums) {
//        https://leetcode-cn.com/submissions/detail/108485993/
//        错误原因：由于存在正负数，最小的两个负数相乘可能会成为最大的乘积。（此处忽略了这种情况）
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0, j = 0; i < n; i++, j++) {
            dp[i][j] = nums[i];
            if (j < n - 1)
                dp[i][j + 1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i, k = 0; j < n; j++, k++) {
                dp[j][k] = dp[j - 1][k + 1] == 0 ? 0 : dp[j - 1][k] * dp[j][k + 1] / dp[j - 1][k + 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i, k = 0; j < n; j++, k++) {
                int max = Math.max(dp[j - 1][k], dp[j][k + 1]);
                dp[j][k] = Math.max(dp[j][k], max);
            }
        }
        return dp[n - 1][0];
    }

    public int maxProduct(int[] nums) {
//        参考用户评论：https://leetcode-cn.com/u/z7k/
//        相比 maxProductWrongAnswer，除了维护了一个dpMax还维护了一个dpMin，用于解决当前数 num 与之前最小负数相乘后为最大整数乘积的情况
//        https://leetcode-cn.com/submissions/detail/108553433/
        int n = nums.length;
        int max = nums[0];
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        Question152 question = new Question152();

        int[][] cases = new int[][]{
                {2,3,-2,4},
                {-2,0,-1},
                {0,-1,-4,4,-4,-5,-2,-1,-1,2,3,5,1,3,-6,-1,-1,0,0,-2}    // 预期：345600
        };
        for (int[] aCase : cases) {
            System.out.println(question.maxProduct(aCase));
        }
    }
}
