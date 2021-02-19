package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 42. 接雨水
 * @author: blessing
 * @create: 2021-02-19 15:10
 */
public class Question42 {
//    https://leetcode-cn.com/problems/trapping-rain-water/
    public int trap(int[] height) {
        // 直观解法
        // 85ms
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left_max = height[i];
            int right_max = height[i];
            for (int j = i - 1; j >= 0; j--) {
                left_max = Math.max(height[j], left_max);
            }
            for (int j = i + 1; j < height.length; j++) {
                right_max = Math.max(height[j], right_max);
            }
            res += (Math.min(left_max, right_max) - height[i]);
        }
        return res;
    }

    public int trapDp(int[] height) {
        // 动态规划 官方题解
        // 1ms
        int ans = 0;
        int len = height.length;
        int[] left_max_arr = new int[len + 2];
        int[] right_max_arr = new int[len + 2];
        for (int i = 1; i < len + 1; i++) {
            left_max_arr[i] = Math.max(left_max_arr[i - 1], height[i - 1]);
        }
        for (int i = len; i > 0; i--) {
            right_max_arr[i] = Math.max(right_max_arr[i + 1], height[i - 1]);
        }
        for (int i = 1; i < len + 1; i++) {
            ans += (Math.min(left_max_arr[i], right_max_arr[i]) - height[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Question42 question = new Question42();
        int[][]  cases = new int[][]{
                {0,1,0,2,1,0,1,3,2,1,2,1},
                {4,2,0,3,2,5},
                {1,2,3,4,3,2,1},
                {4,3,2,1,2,3,4}
        };
        for (int[] aCase : cases) {
            System.out.println(Arrays.toString(aCase) + " => " + question.trapDp(aCase));
        }
    }
}
