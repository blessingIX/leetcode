package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 03. 数组中重复的数字
 * @author: 易子建
 * @create: 2021-01-10 21:07
 */
public class CodingInterviews3 {
//    https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof

    public int findRepeatNumber(int[] nums) {
        int[] bucket = new int[nums.length];
        for (int num : nums) {
            bucket[num]++;
            if (bucket[num] > 1) return num;
        }
        return 0;
    }

    public static void main(String[] args) {
        CodingInterviews3 codingInterviews = new CodingInterviews3();
        int[][] cases = new int[][] {
                {2,3,1,0,2,5,3}
        };

        for(int[] aCase : cases) {
            System.out.println(codingInterviews.findRepeatNumber(aCase));
        }
    }
}
