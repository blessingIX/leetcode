package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 剑指 Offer29. 顺时针打印矩阵
 * @author: blessing
 * @create: 2021-01-09 15:07
 */
public class CodingInterviews29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int count = 0;
        int h = 0;
        int v = 0;
        int i = 0;
        int j = -1;
        int[] ans = new int[matrix.length * matrix[0].length];
        int direCount = 0;
        int direct = 0;
        while (true) {
            direct = direCount % 4;
            int step = 0;
            if (direct == 1 || direct == 3) {
                step = matrix.length - v;
                h++;
            } else {
                step = matrix[0].length - h;
                v++;
            }
            if (step <= 0)
                break;
            for (int k = 0; k < step; k++) {
                switch (direct) {
                    case 0:
                        j++;
                        break;
                    case 1:
                        i++;
                        break;
                    case 2:
                        j--;
                        break;
                    case 3:
                        i--;
                        break;
                }
                ans[count++] = matrix[i][j];
            }
            direCount++;
        }
        return ans;
    }

    public static void main(String[] args) {
        CodingInterviews29 question = new CodingInterviews29();
        int[][][] cases = new int[][][]{
                null,
                {

                },
                {
                        {1}
                },
                {
                        {1,2},
                        {3,4}
                },
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                },
                {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}
                }
        };

        for (int[][] aCase : cases) {
            System.out.println(Arrays.toString(question.spiralOrder(aCase)));
        };
    }
}
