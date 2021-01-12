package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 最接近的三数之和
 * @author: blessing
 * @create: 2020-06-24 21:47
 */
public class Question16 {
//    https://leetcode-cn.com/problems/3sum-closest/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - close)) {
                    close = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return close;
    }

    public static void main(String[] args) {
        Question16 question = new Question16();
        int[][] lss = new int[][]{
            {31, 13, 99, 81, 83, 26, 32, 28, 17, 47}
        };
        int[] targets = new int[]{50, 80, 100, 200, 250, 300};
        for (int i = 0; i < targets.length; i++) {
            System.out.println("target = " + targets[i] + ", close = " + question.threeSumClosest(lss[0], targets[i]));
        }
        System.out.println("=======");
        System.out.println(question.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
