package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description: 217. 存在重复元素
 * @author: blessing
 * @create: 2021-01-14 17:36
 */
public class Question217 {
//    https://leetcode-cn.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
//        https://leetcode-cn.com/submissions/detail/138392199/
        if (nums == null) return false;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }

    public boolean containsDuplicate1ms(int[] nums) {
//        ???
        if (nums == null || nums.length == 0){
            return false;
        }
        int temp = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            if (nums[i] == temp){
                return true;
            } else if (nums[i] > temp){
                temp = nums[i];
            } else {
                for (int j = i - 1 ; j >= 0 ; j--){
                    if (nums[i] == nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question217 question = new Question217();
        int[][] cases = new int[][]{
                {1,2,3,1},
                {1,2,3,4},
                {1,1,1,3,3,4,3,2,4,2}
        };

        for (int[] aCase : cases) {
//            System.out.println(Arrays.toString(aCase) + " => " + question.containsDuplicate(aCase));
            System.out.println(Arrays.toString(aCase) + " => " + question.containsDuplicate1ms(aCase));
        }
    }
}
