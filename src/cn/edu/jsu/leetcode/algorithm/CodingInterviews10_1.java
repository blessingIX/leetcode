package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @author: 易子建
 * @create: 2021-01-11 09:41
 */
public class CodingInterviews10_1 {
//    https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

    public int fibTimeout(int n) {
//
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fibTimeout(n - 1) + fibTimeout(n - 2)) % 1000000007;
    }

    // https://leetcode-cn.com/u/dongzengjie/
//    public int fib(int n) {
//        if (n == 0 || n == 1)
//            return n;
//
//        int a = 1, b = 0;
//        for (int i = 1; i < n; i++) {
//            a = a + b;
//            b = a - b;
//            a %= 1000000007;
//        }
//        return a;
//    }

    // https://leetcode-cn.com/u/loveshes/
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        int a = 0, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            if (c >= 1000000007) c -= 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        CodingInterviews10_1 codingInterviews = new CodingInterviews10_1();
        int[] cases = new int[]{
                2, 5, 20, 100
        };
        for (int aCase : cases) {
            System.out.println(aCase + " ==> " + codingInterviews.fib(aCase));
        }
    }

}
