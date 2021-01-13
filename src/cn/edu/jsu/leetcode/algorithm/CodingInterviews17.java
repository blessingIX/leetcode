package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 17. 打印从1到最大的n位数
 * @author: 易子建
 * @create: 2021-01-12 15:18
 */
public class CodingInterviews17 {
//    https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/

    // 剑指Offer原题并非这么简单（评论，题解都有说），原题需要考虑大数计算，返回值并非int[]应为String[]
    public int[] printNumbers(int n) {
        int count = (int) Math.pow(10, n);
        int[] result = new int[count - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    // 
    public String[] printNumbersString(int n) {
        return null;
    }

    public static void main(String[] args) {
        CodingInterviews17 codingInterviews = new CodingInterviews17();
        int[] cases = new int[]{
                1, 3, 5
        };
        for (int aCase : cases) {
            System.out.println(aCase + " => " + Arrays.toString(codingInterviews.printNumbers(aCase)));
        }
    }
}
