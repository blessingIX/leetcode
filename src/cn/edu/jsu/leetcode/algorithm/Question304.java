package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 二维区域和检索 - 矩阵不可变
 * @author: blessing
 * @create: 2020-09-16 19:24
 */
public class Question304 {
//    https://leetcode-cn.com/problems/range-sum-query-2d-immutable/

    public static void main(String[] args) {
        int[][][] matrix = new int[][][]{
                {
                        {3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}
                },
                {}, // 测试空矩阵
                {   // 测试空矩阵
                        {}
                },
                {
                    {-4,-5}
                }
        };
        int[][][] cases = new int[][][]{
                {
                        {2, 1, 4, 3, 8},
                        {1, 1, 2, 2, 11},
                        {1, 2, 2, 4, 12},
                        {0, 0, 2, 2, 21},   // 测试 row1 col1 处于矩阵左上角
                        {1, 0, 2, 2, 17},   // 测试 col1 处于边界位置，row1 不处于边界位置
                        {0, 1, 2, 2, 12}    // 测试 row1 处于边界位置，col1 不处于边界位置
                },
                {
                        {1, 1, 2, 2, 0}
                },
                {
                        {1, 1, 2, 2, 0}
                },
                {
                        {0, 0, 0, 0, -4},
                        {0, 0, 0, 1, -9},
                        {0, 1, 0, 1, -5}
                }
        };
        for (int i = 0; i < matrix.length; i++) {
            NumMatrix numMatrix = new NumMatrix(matrix[i]);
            for (int j = 0; j < cases[i].length; j++) {
                int res = numMatrix.sumRegion(cases[i][j][0], cases[i][j][1], cases[i][j][2], cases[i][j][3]);
                System.out.println(res + " <> " + cases[i][j][4] + " -> " + (res == cases[i][j][4]));
            }
        }
    }
}

class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            this.matrix = matrix;
            return;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (i == 0) continue;
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) continue;
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.matrix.length == 0 || this.matrix[0].length == 0) return 0;
        if (row1 < 0 || row1 >= this.matrix.length || row2 < 0 || row2 >= this.matrix.length) return 0;
        if (col1 < 0 || col1 >= this.matrix[0].length || col2 < 0 || col2 >= this.matrix[0].length) return 0;
        int l = (col1 == 0) ? 0 : this.matrix[row2][col1 - 1];
        int t = (row1 == 0) ? 0 : this.matrix[row1 - 1][col2];
        int lt = (row1 == 0 || col1 == 0) ? 0 : this.matrix[row1 - 1][col1 - 1];
        return this.matrix[row2][col2] - l - t + lt;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */