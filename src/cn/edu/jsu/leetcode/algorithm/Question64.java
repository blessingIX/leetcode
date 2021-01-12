package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 最小路径和
 * @author: blessing
 * @create: 2020-08-14 14:26
 */
public class Question64 {
//    https://leetcode-cn.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        Question64 question = new Question64();
        int[][][] cases = new int[][][]{
                {
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                },
                {
                        {1,2,5},
                        {3,2,1}
                }
        };
        for (int[][] aCase : cases) {
            System.out.println(question.minPathSum(aCase));
        }
    }
}
