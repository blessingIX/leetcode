package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 04. 二维数组中的查找
 * @author: 易子建
 * @create: 2021-01-10 21:25
 */
public class CodingInterviews4 {
//    https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        return search(matrix, target, 0, matrix[0].length - 1);
    }

    public boolean search(int[][] matrix, int target, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return false;
        if (target == matrix[i][j]) return true;
        else if (target < matrix[i][j])
            return search(matrix, target, i, j - 1);
        else
            return search(matrix, target, i + 1, j);
    }

    public static void main(String[] args) {
        CodingInterviews4 codingInterviews = new CodingInterviews4();
        int[][][] matrixs = new int[][][]{
                {
                        {1,   4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                }
        };
        int[] targets = new int[] {
                5, 20, 1, 18, 0
        };

        for (int target : targets) {
            System.out.println(codingInterviews.findNumberIn2DArray(matrixs[0], target));
        }
    }
}
