package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 704. 二分查找
 * @author: blessing
 * @create: 2021-02-20 11:03
 */
public class Question704 {
//    https://leetcode-cn.com/problems/binary-search/
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (start < end) {
            if (nums[mid] == target) return mid;
            else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start >> 2);
        }
        return nums[start] == target ? start : -1;
    }
}
