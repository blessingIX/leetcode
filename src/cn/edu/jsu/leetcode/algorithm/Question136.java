package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 136. 只出现一次的数字
 * @author: blessing
 * @create: 2021-01-18 20:05
 */
public class Question136 {
//    https://leetcode-cn.com/problems/single-number/

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Question136 question = new Question136();
        int[][] cases = new int[][]{
                {2,2,1},
                {4,1,2,1,2}
        };
        for (int[] aCase : cases) {
            System.out.println(Arrays.toString(aCase) + " ==singleNumber==> " + question.singleNumber(aCase));
        }
    }
}
