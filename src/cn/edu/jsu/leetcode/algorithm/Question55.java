package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 跳跃游戏
 * @author: blessing
 * @create: 2020-06-03 09:35
 */
public class Question55 {
//    https://leetcode-cn.com/problems/jump-game/
    public boolean canJump1(int[] nums) {
        return jump1(nums, 0, nums.length - 1);
    }

    private boolean jump1(int[] nums, int pos, int end) {
//        回溯算法
//        超出时间限制    https://leetcode-cn.com/problems/jump-game/submissions/
        if (pos == end) return true;
        for (int i = pos + nums[pos] > end ? end - pos : nums[pos]; i > 0 ; i--) {
            if (jump1(nums, pos + i, end)) return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
//
        int maxReachDist = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachDist) return false;
            maxReachDist = Math.max(maxReachDist, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Question55 question = new Question55();
        int[] example1 = new int[]{2,3,1,1,4};
        System.out.println(question.canJump(example1));
        int[] example2 = new int[]{3,2,1,0,4};
        System.out.println(question.canJump(example2));
        int[] case6 = new int[]{2,0};
        System.out.println(question.canJump(case6));
        int[] case11 = new int[]{1,2,3};
        System.out.println(question.canJump(case11));
    }
}
