package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 162. 寻找峰值
 * @author: blessing
 * @create: 2021-02-20 12:28
 */
public class Question162 {
//    https://leetcode-cn.com/problems/find-peak-element/

//    爱学习的饲养员：https://www.bilibili.com/video/BV1sy4y1q79M?p=52
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 2);
            if (nums[mid] <= nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
