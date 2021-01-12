package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 不同的二叉搜索树
 * @author: blessing
 * @create: 2020-09-15 09:03
 */
public class Question96 {
//    https://leetcode-cn.com/problems/unique-binary-search-trees/

    public int numTrees(int n) {
//        https://leetcode-cn.com/submissions/detail/108159570/
//        执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//        内存消耗：36.1 MB, 在所有 Java 提交中击败了95.30%的用户

//        思路（动态规划）：
//        [1, n]整数构建二叉搜索树，先确定根节点（n种情况），在确定了根节点之后不同二叉搜索树的个数取决于左右子树不同二叉搜索树的个数
//        （左子树不同二叉搜索树个数 * 右子树不同二叉搜索树个数），特殊情况：左子树或右子树节点数为0时，左右子树不同二叉搜索树的个数应为1（dp[0] = 1;)
        if (n <= 0) return 0;
        if (n < 3) return n;
        int[] dp = new int[n+1];
//        临界条件
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {  // 确定根节点
                int left = j - 1;   // 确定根节点之后，构建好二叉搜索树后左子树节点数
                int right = i - left - 1;   // 确定根节点之后，构建好二叉搜索树后右子树节点数
                dp[i] = dp[i] + dp[left] * dp[right];   // 状态转移方程
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Question96 question = new Question96();

        System.out.println(question.numTrees(3));

//        cases[i][0]：输入，cases[i][1]：结果
        int[][] cases = new int[][]{
                {4, 14},
                {5, 42}
        };
        for (int[] aCase : cases) {
            int res = question.numTrees(aCase[0]);
            System.out.println(aCase[0] + ":" + aCase[1] + " -> " + res + " " + (res == aCase[1]));
        }
    }
}
