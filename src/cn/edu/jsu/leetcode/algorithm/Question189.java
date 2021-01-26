package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 189. 旋转数组
 * @author: blessing
 * @create: 2021-01-26 16:01
 */
public class Question189 {
//    https://leetcode-cn.com/problems/rotate-array/

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i > len - 1 - k; i--) {
            stack.push(nums[i]);
        }
        for (int i = len - 1 - k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        int i = 0;
        while (!stack.empty()) {
            nums[i++] = stack.pop();
        }
    }

    public static void main(String[] args) {
        Question189 question = new Question189();
        int[][] cases = new int[][]{
                {1,2,3,4,5,6,7},
                {-1,-100,3,99}
        };
        int[] steps = new int[]{
                3,
                2
        };

        for (int i = 0; i < cases.length; i++) {
            System.out.printf("=====case%d=====\n", i + 1);
            System.out.println(Arrays.toString(cases[i]));
            question.rotate(cases[i], steps[i]);
            System.out.println(Arrays.toString(cases[i]));
        }
    }
}
