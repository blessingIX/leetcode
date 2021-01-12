package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 不同路径
 * @author: blessing
 * @create: 2020-08-14 12:48
 */
public class Question62 {
//    https://leetcode-cn.com/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Question62 question = new Question62();
        int[][] cases = new int[][]{
                {3, 2},
                {7, 3}
        };
        for (int[] aCase : cases) {
            System.out.println(question.uniquePaths(aCase[0], aCase[1]));
        }
    }
}
