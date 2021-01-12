package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author: 易子建
 * @create: 2021-01-11 10:19
 */
public class CodingInterviews10_2 {
//    https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

    public int numWays(int n) {
        if (n == 0 || n == 1)
            return 1;

        int a = 1, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            if (c >= 1e9) c -= 1e9;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        CodingInterviews10_2 codingInterviews = new CodingInterviews10_2();
        int[] cases = new int[]{
                2, 7 ,0
        };
        for (int aCase : cases) {
            System.out.println(aCase + " => " + codingInterviews.numWays(aCase));
        }
    }
}
