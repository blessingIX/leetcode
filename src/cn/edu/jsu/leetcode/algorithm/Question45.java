package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 跳跃游戏 II
 * @author: blessing
 * @create: 2020-06-03 10:37
 */
public class Question45 {
    public int jump(int[] nums) {
//        这段代码没有提交到leetcode，不知道能不能通过。。。
        int start = 0;
        int end = 0;
        int step = 0;
        while (start < nums.length - 1) {
            if (nums[start] == 0) break;
            if (start + nums[start] < nums.length - 1) {
                int max = 0;
                end = start;
                for (int i = start + 1; i <= start + nums[start]; i++) {
                    if (i + nums[i] > max) {
                        max = nums[i];
                        end = i;
                    }
                }
                if (max == 0) break;
            } else {
                end = nums.length - 1;
            }
            start = end;
            step++;
        }
        return start < nums.length - 1 ? -1 : step;
    }

    public int jump1(int[] nums) {
//        官方题解代码
//        但是自认为题目给的要求少了，比如[1,0,0]是无法跳到数组最后一位的而这段代码计算的结果是2，题目中没有给出比如跳不到最后一位时返回-1这样的要求。
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Question45 question = new Question45();
        int[] example1 = new int[]{2,3,1,1,4};
        System.out.println(question.jump(example1));
        int[] test1 = new int[]{1,0,0,0};
        System.out.println(question.jump(test1));
        int[] test2 = new int[]{1,2,1};
        System.out.println(question.jump(test2));
        int[] test3 = new int[]{1,3,5,0,4,3,7,0,9,5};
        System.out.println(question.jump(test3));
        int[] case73 = new int[]{10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(question.jump(case73));
        int[] test4 = new int[]{2,3,3,1,2,1};
        System.out.println(question.jump(test4));
    }
}
