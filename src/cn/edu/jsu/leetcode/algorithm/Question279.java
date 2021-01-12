package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 完全平方数
 * @author: blessing
 * @create: 2020-09-16 15:12
 */
public class Question279 {
//    https://leetcode-cn.com/problems/perfect-squares/

    public int numSquaresPoorEfficiency(int n) {
//        https://leetcode-cn.com/submissions/detail/108624200/
//        执行用时：294 ms, 在所有 Java 提交中击败了10.20%的用户
//        内存消耗：38.7 MB, 在所有 Java 提交中击败了22.20%的用户
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {  // List添加所有小于 n 的完全平方数后，问题就演变为【找零钱】问题。完全平方数相当于钱币面值，参数n相当于需要凑的零钱
            int num = i * i;
            if (num > n)
                break;
            ls.add(num);
        }

//        以下为找零钱问题解答步骤（参考 labuladong算法小抄）
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (Integer l : ls) {
                if (i - l < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - l]);
            }
        }
        return (dp[n] == n + 1) ? 0 : dp[n];
    }

    public int numSquares(int n) {  // 数学
//        用户评论：https://leetcode-cn.com/u/fibonacciwh/
//        四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
//        推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)

        // 先根据上面提到的公式来缩小n
        while(n % 4 == 0) {
            n /= 4;
        }
        // 如果满足公式 则返回4
        if(n % 8 == 7) {
            return 4;
        }
        // 在判断缩小后的数是否可以由一个数的平方或者两个数平方的和组成
        int a = 0;
        while ((a * a) <= n) {
            int b = (int) Math.sqrt((n - a * a));
            if(a * a + b * b == n) {
                //如果可以 在这里返回
                if(a != 0 && b != 0) {
                    return 2;
                } else{
                    return 1;
                }
            }
            a++;
        }
        //如果不行，返回3
        return 3;
    }

    public static void main(String[] args) {
        Question279 question = new Question279();

        int[] cases = new int[]{12,13};
        for (int aCase : cases) {
            System.out.println(question.numSquares(aCase));
        }
    }
}
