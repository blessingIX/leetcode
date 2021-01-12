package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 长度最小的子数组
 * @author: blessing
 * @create: 2020-06-28 09:30
 */
public class Question209 {
//    https://leetcode-cn.com/problems/minimum-size-subarray-sum/
//    **题目描述中子数组包含原数组
    public int minSubArrayLen(int s, int[] nums) {
//        执行用时：145 ms，相当低效（原因：每次计算sum时都重新从left位置算到right位置，没有利用之前计算好的sum来计算下一个sum）
//        思路：从数组开头开始遍历利用left、right两个变量计算sum和diff
//        每计算出一个符合要求的sum就将diff和len进行比较得出最小值
        int len = nums.length;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = right = i;
            int sum = 0;
            while (sum < s && right < nums.length) {
                sum += nums[right];
                right++;
            }
            if (sum < s) {
                if (left == 0 && right == nums.length)
                    return 0;
                continue;
            }
            int diff = right - left;
            len = Math.min(diff, len);
        }
        return len;
    }

    public int minSubArrayLen1(int s, int[] nums) {
//        参考提交记录执行用时为 1 ms 的范例代码
//        效率高的原因：利用前一个sum减去left位置元素来计算下一个sum,再将left向后移为下一次计算sum和len做准备（ sum -= nums[left++]; ）
        int len = nums.length + 1;
        int left = 0, sum = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= s){
                if(right - left + 1 < len) {
                    len = right - left + 1;
                }
                sum -= nums[left];  // **关键**
                left++;
            }
        }
        return len == nums.length + 1 ? 0 : len;
    }

    public static void main(String[] args) {
        Question209 question = new Question209();
        int[][] cases = new int[][]{
                {2, 3, 1, 2, 4, 3},
                {0, 1, 2, 3, 3, 3, 5, 7, 8, 9},
                {1, 2, 3, 4, 5},
                {1, 1}
        };
        int[] ss = new int[]{15, 16, 15, 3};
        for (int i = 0; i < Math.min(cases.length, ss.length); i++) {
            System.out.println(question.minSubArrayLen1(ss[i], cases[i]));
        }
    }
}
