package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 35. 搜索插入位置
 * @author: blessing
 * @create: 2021-02-20 11:07
 */
public class Question35 {
//    https://leetcode-cn.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while (start < end) {
            if (nums[mid] == target) return mid;
            else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;  // 感谢饲养员：https://www.bilibili.com/video/BV1sy4y1q79M?p=51
            }
            mid = start + (end - start) / 2;
        }
        if (start == end && nums[start] == target) return start;    // 若mid在while循环最后计算需要添加此语句，不然通不过[1] 1 这个测试用例
        return target < nums[start] ? start : start + 1;    // https://www.bilibili.com/video/BV1sy4y1q79M?p=51
    }

    public int searchInsertByStockman(int[] nums, int target) {
//        https://www.bilibili.com/read/cv7950304
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }

}
