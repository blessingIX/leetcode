package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 数组中的第K个最大元素
 * @author: blessing
 * @create: 2020-06-29 09:15
 */
public class Question215 {
//    https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
    public int findKthLargest(int[] nums, int k) {
//        https://leetcode-cn.com/submissions/detail/82936100/
//        执行用时：74 ms，很低效，因为思路只是简单的对此题做了特定优化的冒泡排序
//        先看k是否过数组nums的一半来决定冒泡排序升降序，冒泡k次后直接返回nums[nums.length - k] 或 nums[k - 1]
//        评论和提交记录范例大多数用的是 快速排序 或 堆排序（详见Question215_QuickSort、Question215_HeapSort）
        boolean asc = k <= nums.length / 2;
        int times = k;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (asc) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                } else {
                    if (nums[j] < nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
            if (--times == 0)
                return asc ? nums[nums.length - k] : nums[k - 1];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Question215 question = new Question215();
        int[][] nums = new int[][]{
                {3,2,1,5,6,4},
                {3,2,3,1,2,4,5,5,6}
        };
        int[] ks = new int[]{2,6};
        for (int i = 0; i < Math.min(nums.length, ks.length); i++) {
            System.out.println(Arrays.toString(nums[i]));
            System.out.println(question.findKthLargest(nums[i], ks[i]));
            System.out.println(Arrays.toString(nums[i]));
        }
//        for (int i = 1; i <= nums[1].length; i++) {
//            System.out.println(question.findKthLargest(nums[1], i));
//        }
    }
}
