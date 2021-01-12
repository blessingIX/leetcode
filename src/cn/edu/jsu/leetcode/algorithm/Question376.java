package cn.edu.jsu.leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 摆动序列
 * @author: blessing
 * @create: 2020-09-18 09:31
 */
public class Question376 {
//    https://leetcode-cn.com/problems/wiggle-subsequence/

    public int wiggleMaxLengthAnswerError(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        if (n < 3) return nums[0] == nums[1] ? 1 : n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = nums[0] == nums[1] ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int front = nums[i - 2] - nums[i - 1];
            int back = nums[i - 1] - nums[i];
            boolean isWiggle = (front < 0 && back > 0) || (front > 0 && back < 0);
            dp[i] = isWiggle ? dp[i - 1] + 1 : dp[i - 1];
        }
        return dp[n - 1];
    }

    public int wiggleMaxLength(int[] nums) {
//        参考用户评论：https://leetcode-cn.com/u/nwpucfy/
//        与我自己写的 wiggleMaxLengthAnswerError 思路一致（我的缺少了关键步骤），关键步骤：去除连续重复的数（即一段连续的相等的数只保留一个）。
//        例：[1,1,1,2,2,2,3,3,3] -> [1,2,3]
        int n = nums.length;
        if (n < 1) return 0;
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) ls.add(nums[i]);
        }
        n = ls.size();
        if (n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            int front = ls.get(i - 2) - ls.get(i - 1);
            int back = ls.get(i - 1) - ls.get(i);
            boolean isWiggle = (front < 0 && back > 0) || (front > 0 && back < 0);
            dp[i] = isWiggle ? dp[i - 1] + 1 : dp[i - 1];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Question376 question = new Question376();

        int[][] cases = new int[][]{
                {1,7,4,9,2,5},
                {1,17,5,10,13,15,10,5,16,8},
                {1,2,3,4,5,6,7,8,9},
                {0,0},   // 预期结果：1
                {0,0,0},
                {3,3,3,2,5}
        };
        for (int[] aCase : cases) {
            System.out.println(question.wiggleMaxLength(aCase));
        }
    }
}
