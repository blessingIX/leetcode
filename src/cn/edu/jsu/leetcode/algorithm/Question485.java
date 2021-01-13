package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 485. 最大连续1的个数
 * @author: 易子建
 * @create: 2021-01-13 10:33
 */
public class Question485 {
//    https://leetcode-cn.com/problems/max-consecutive-ones/

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 1) count++;
            if (num == 0) count = 0;
            if (count > result) result = count;
        }
        return result;
    }

    public static void main(String[] args) {
        Question485 question = new Question485();
        int[][] cases = new int[][]{
                {1,1,0,1,1,1}
        };

        for (int[] aCase : cases) {
            System.out.println(question.findMaxConsecutiveOnes(aCase));
        }
    }
}
