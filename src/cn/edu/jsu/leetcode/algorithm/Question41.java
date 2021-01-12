package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description:  缺失的第一个正数
 * @author: blessing
 * @create: 2020-06-27 10:55
 */
public class Question41 {
//    https://leetcode-cn.com/problems/first-missing-positive/
    public int firstMissingPositive(int[] nums) {
//        思路：遍历一遍数组，将当前下标元素放到其下标对应位置（即 nums[i] 与 nums[nums[i] - 1]交换）
//        *需要交换的情况：当前元素在0 < nums[i] <= nums.length 的范围内且目标位置元素与当前元素不相等
//        最后遍历一遍num，返回第一个 nums[i] != i + 1 时的 下标值 + 1 (i + 1)，若遍历完nums都没有不相等的，则说明nums是一个从1开始的连续的正整数序列，应该返回nums.length + 1。
//        **简单说就是将数组中每个元素放在对应的位置上（即 index -> value: 0 -> 1, 1 -> 2, ......），再找第一个空缺的位置（即index + 1 != nums[index]））**
        int len = nums.length;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }

    public static void main(String[] args) {
        Question41 question = new Question41();
        int[][] lss = new int[][]{
//           {9, 7, 7, 6, 5, 4, 3, 2, 0, 0},
//           {0, 0, 2, 4, 5, 6, 6, 8, 8, 8},
//           {2, 6, 8, 9, 7, 2, 9, 6, 9, 8},
//           {1, 2, 0},
//           {3, 4, -1, 1},
//           {7, 8, 9, 11, 12},
            {-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15},
            {99,94,96,11,92,5,91,89,57,85,66,63,84,81,79,61,74,78,77,30,64,13,58,18,70,69,51,12,32,34,9,43,39,8,1,38,49,27,21,45,47,44,53,52,48,19,50,59,3,40,31,82,23,56,37,41,16,28,22,33,65,42,54,20,29,25,10,26,4,60,67,83,62,71,24,35,72,55,75,0,2,46,15,80,6,36,14,73,76,86,88,7,17,87,68,90,95,93,97,98},
            {98,93,95,10,91,4,90,88,56,84,65,62,83,80,78,60,73,77,76,29,63,12,57,17,69,68,50,11,31,33,8,42,38,7,0,37,48,26,20,44,46,43,52,51,47,18,49,58,2,39,30,81,22,55,36,40,15,27,21,32,64,41,53,19,28,24,9,25,3,59,66,82,61,70,23,34,71,54,74,-1,1,45,14,79,5,35,13,72,75,85,87,6,16,86,67,89,94,92,96,97}
        };
        for (int i = 0; i < lss.length; i++) {
            System.out.println(question.firstMissingPositive(lss[i]));
        }
    }
}
