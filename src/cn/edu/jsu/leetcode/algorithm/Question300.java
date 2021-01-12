package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 最长上升子序列
 * @author: blessing
 * @create: 2020-09-16 17:07
 */
public class Question300 {
//    https://leetcode-cn.com/problems/longest-increasing-subsequence/

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int len = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j]) continue;
                if (dp[j] > max)
                    max = dp[j];
            }
            dp[i] = max + 1;
            if (dp[i] > len)
                len = dp[i];
        }
        return len;
    }

    public static void main(String[] args) {
        Question300 question = new Question300();

        int[][] cases = new int[][]{
                {10,9,2,5,3,7,101,18},
                {1,3,5,0,4,3,7,0,9,5},
                {1,2,3,4,5,6,7,8,9,0}
        };
        for (int[] aCase : cases) {
            System.out.println(question.lengthOfLIS(aCase));
        }
    }
}
