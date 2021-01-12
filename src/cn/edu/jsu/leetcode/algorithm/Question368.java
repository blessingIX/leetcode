package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 最大整除子集
 * @author: blessing
 * @create: 2020-09-17 19:07
 */
public class Question368 {
//    https://leetcode-cn.com/problems/largest-divisible-subset/

    public List<Integer> largestDivisibleSubset(int[] nums) {
//        FIXME:
        int n = nums.length;
        if (n < 2) {
            List<Integer> ls = new ArrayList<>();
            for (int num : nums) {
                ls.add(num);
            }
            return ls;
        }
//        int[] dp = new int[n];
//        dp[0] = 1;
        List<List<Integer>> lss = new ArrayList<>(n);
        ArrayList<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        lss.add(l);
        for (int i = 1; i < n; i++) {
            List<Integer> ls = new ArrayList<>();
            boolean flag = true;
            for (int integer : lss.get(i - 1)) {
                if (integer % nums[i] == 0 || nums[i] % integer == 0) {
                    ls.add(integer);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ls.add(nums[i]);
            } else {
                ls = lss.get(i - 1);
            }
            lss.add(ls);
//            dp[i] = Math.max(dp[i - 1], ls.size());
        }
        return lss.get(n - 1);
    }

    public static void main(String[] args) {
        Question368 question = new Question368();

        int[][] cases = new int[][]{
                {1,2,3},
                {1,2,4,8},
                {},
                {1},
                {4,8,10,240},
                {1,2,4,8,16},
                {3,4,16,8}
        };
        for (int[] aCase : cases) {
            System.out.println(question.largestDivisibleSubset(aCase));
        }
    }
}
