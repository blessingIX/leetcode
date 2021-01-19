package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 88. 合并两个有序数组
 * @author: blessing
 * @create: 2021-01-19 20:35
 */
public class Question88 {
//    https://leetcode-cn.com/problems/merge-sorted-array/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < m) {
            arr[k++] = nums1[i++];
        }
        while (j < n) {
            arr[k++] = nums2[j++];
        }
        for (i = 0; i < m + n; i++)
            nums1[i] = arr[i];
    }
}
