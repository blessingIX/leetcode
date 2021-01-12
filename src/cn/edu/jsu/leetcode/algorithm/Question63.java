package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 不同路径 II
 * @author: blessing
 * @create: 2020-08-14 13:19
 */
public class Question63 {
//    https://leetcode-cn.com/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        简洁代码参考：https://leetcode-cn.com/u/wu-ai-4/
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i-1][j-1] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Question63 question = new Question63();
        int[][][] cases = new int[][][]{
                {
                        {0,0,0},
                        {0,1,0},
                        {0,0,0}
                },
                {
                        {1,0}
                }
        };
        for (int[][] aCase : cases) {
            System.out.println(question.uniquePathsWithObstacles(aCase));
        }
    }
}
