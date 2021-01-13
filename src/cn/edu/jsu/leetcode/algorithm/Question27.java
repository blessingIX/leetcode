package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 27. 移除元素
 * @author: 易子建
 * @create: 2021-01-13 11:40
 */
public class Question27 {
//    https://leetcode-cn.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i <= j) {
            if (nums[i] == val && nums[j] != val) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (nums[i] != val) i++;
            if (nums[j] == val) j--;
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Question27 question = new Question27();
        int[][] cases = new int[][]{
                {3,2,2,3},
                {0,1,2,2,3,0,4,2},
                {1}
        };
        int[] values = new int[]{
                3, 2, 1
        };
        for (int i = 0; i < cases.length; i++) {
            System.out.printf("nums = %s, val = %d\n", Arrays.toString(cases[i]), values[i]);
            System.out.println(question.removeElement(cases[i], values[i]));
            System.out.println(Arrays.toString(cases[i]));
        }
    }
}
