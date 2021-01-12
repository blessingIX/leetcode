package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 11. 旋转数组的最小数字
 * @author: 易子建
 * @create: 2021-01-11 10:32
 */
public class CodingInterviews11 {
//    https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        if (numbers.length == 1) return numbers[0];
        if (numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i + 1] < numbers[i]) return numbers[i + 1];
            if (numbers[j - 1] > numbers[j]) return numbers[j];
            i++;
            j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        CodingInterviews11 codingInterviews = new CodingInterviews11();
        int[][] cases = new int[][]{
                {3,4,5,1,2},
                {2,2,2,0,1},
                {2,2,2,2,2},
                {1,2,3,4,5},
                {3,4,5,1,2,3},
                null,
                {}
        };

        for (int[] aCase : cases) {
            System.out.println(codingInterviews.minArray(aCase));
        }
    }
}
