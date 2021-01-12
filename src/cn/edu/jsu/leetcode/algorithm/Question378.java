package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 有序矩阵中第K小的元素
 * @author: blessing
 * @create: 2020-07-02 11:33
 */
public class Question378 {
//    https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }

    public static void main(String[] args) {
        Question378 question = new Question378();
        int[][] matrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(question.kthSmallest(matrix, 8));
    }
}
