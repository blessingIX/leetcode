package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 350. 两个数组的交集 II
 * @author: blessing
 * @create: 2021-01-26 16:55
 */
public class Question350 {
//    https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length > nums1.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int end = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = end; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    swap(nums1, end, i);
                    swap(nums2, end, j);
                    end++;
                    break;
                }
            }
        }
        return Arrays.copyOf(nums1, end);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
