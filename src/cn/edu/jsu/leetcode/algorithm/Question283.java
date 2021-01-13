package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description:
 * @author: 易子建
 * @create: 2021-01-13 10:46
 */
public class Question283 {
//    https://leetcode-cn.com/problems/move-zeroes/

    // 找连续的零，让连续零的第一个零与第一个不为零的数交换
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        if (zero == -1) return;
        int nonzero = zero + 1;
        while (nonzero < nums.length) {
            if (nums[nonzero] != 0) {
                int temp = nums[zero];
                nums[zero] = nums[nonzero];
                nums[nonzero] = temp;
                zero++;
            }
            nonzero++;
        }
    }

    public static void main(String[] args) {
        Question283 question = new Question283();
        int[][] cases = new int[][]{
                {0,1,0,3,12},
                {0,0,0,0,0},
                {1,2,3,4,5,6},
                {1,0,0,3,0,0,12},
                {0,0,0,0,12},
                {0,1,1,0}
        };
        for (int[] aCase : cases) {
            question.moveZeroes(aCase);
            System.out.println(Arrays.toString(aCase));
        }
    }
}
