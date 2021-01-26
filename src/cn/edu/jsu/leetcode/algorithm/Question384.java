package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: 384. 打乱数组
 * @author: blessing
 * @create: 2021-01-26 16:38
 */
public class Question384 {
//    https://leetcode-cn.com/problems/shuffle-an-array/

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}

class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < shuffle.length; i++) {
            Random random = new Random();
            int j = random.nextInt(shuffle.length);
            if (i != j) swap(shuffle, i, j);
        }
        return shuffle;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */