package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 13. 机器人的运动范围
 * @author: 易子建
 * @create: 2021-01-11 12:34
 */
public class CodingInterviews13 {
//    https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

    public int movingCount(int m, int n, int k) {
        return dfs(0, 0, m, n, k, new boolean[m][n]);
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] mark) {
        if (i < 0 || j < 0 || i >= m || j >= n || mark[i][j] || (digit(i) + digit(j)) > k) return 0;
        mark[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, mark) + dfs(i - 1, j, m, n, k, mark) + dfs(i, j + 1, m, n, k, mark) + dfs(i , j - 1, m, n, k, mark);
    }

    public int digit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        CodingInterviews13 codingInterviews = new CodingInterviews13();
        int[][] cases = new int[][]{
//               m, n, k
                {2,3,1},
                {3,1,0}
        };

        for (int[] aCase : cases) {
            System.out.printf("m=%d, n=%d, k=%d, res=%d\n", aCase[0], aCase[1], aCase[2], codingInterviews.movingCount(aCase[0], aCase[1], aCase[2]));
        }
    }
}
