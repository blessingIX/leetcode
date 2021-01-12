package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetCode
 * @description: 数组中的第K个最大元素
 * @author: blessing
 * @create: 2020-06-29 10:48
 */
public class Question215_QuickSort {
//    快速排序
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end)   return;
        int mid = partition(arr, start, end);
        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    public int partition(int[] arr, int start, int end) {
        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        int pivot = arr[index];
        swap(arr, index, end);
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] > pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Question215_QuickSort question = new Question215_QuickSort();
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
        for (int i = 1; i <= nums[1].length; i++) {
            System.out.println(question.findKthLargest(nums[1], i));
        }
    }
}
