package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 53. 最大子序和
 * @author: blessing
 * @create: 2021-02-21 13:06
 */
public class Question53 {
//    https://leetcode-cn.com/problems/maximum-subarray/

//    动态规划
//    https://mp.weixin.qq.com/s/3GAD0a-aI_hQJo7IZMQTlQ
    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

//    进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
//    视频：https://www.bilibili.com/video/BV1sy4y1q79M?p=63
//    代码：https://mp.weixin.qq.com/s/3GAD0a-aI_hQJo7IZMQTlQ
//    public int maxSubArray(int[] nums);
//    public int getMax(int[] nums, int l, int r);
//    public int crossSum(int[] nums, int l, int r)
    public int maxSubArray(int[] nums) {
        return getMax(nums, 0, nums.length - 1);
    }

    public int getMax(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = l + (r - l >> 1);
        int lMax = getMax(nums, l, mid);
        int rMax = getMax(nums, mid + 1, r);
        int cMax = crossSum(nums, l, r);
        return Math.max(cMax, Math.max(lMax, rMax));
    }

    public int crossSum(int[] nums, int l, int r) {
        int mid = l + (r - l >> 1);

        int lSum = nums[mid];
        int lMax = lSum;
        for (int i = mid - 1; i >= l; i--) {
            lSum += nums[i];
            lMax = Math.max(lMax, lSum);
        }

        int rSum = nums[mid + 1];
        int rMax = rSum;
        for (int i = mid + 2; i <= r; i++) {
            rSum += nums[i];
            rMax = Math.max(rMax, rSum);
        }

        return lMax + rMax;
    }
}
