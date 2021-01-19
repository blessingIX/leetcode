package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 169. 多数元素
 * @author: blessing
 * @create: 2021-01-19 13:31
 */
public class Question169 {
//    https://leetcode-cn.com/problems/majority-element/

    public int majorityElement(int[] nums) {
        int half = nums.length / 2;
        System.out.println("half = " + half);
        int count = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                num = nums[i];
                count = 1;
            }
            if (count > half) {
                break;
            }
        }
        return num;
    }

//    摩尔投票算法
//    相当于多个国家出兵打大混战
//    同国家的士兵（即相同的数字）不会内斗，不同国家的士兵（即不同的数字）会1换1同归于尽
//    打到最后一定是士兵数量超过所有国家士兵的总和的一半的国家胜利（最后至少剩下一个士兵）
    public int majorityElementMooreVote(int[] nums) {
        int count = 0;
        int maj = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maj) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        Question169 question = new Question169();
        int[][] cases = new int[][]{
                {3,2,3},
                {2,2,1,1,1,2,2},
                {1,1,1,1,2,2,2},
                {2,2,3,3,3,3,2},
                {6,5,5},
                {-1,1,1,1,2,1},
        };

        for (int[] aCase : cases) {
//            System.out.println(question.majorityElement(aCase));
            System.out.println(question.majorityElementMooreVote(aCase));
        }
    }
}
