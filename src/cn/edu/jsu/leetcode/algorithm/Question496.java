package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @description: 496. 下一个更大元素 I
 * @author: blessing
 * @create: 2021-01-14 10:42
 */
public class Question496 {
//    https://leetcode-cn.com/problems/next-greater-element-i/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 双栈解法
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for (int i : nums2) {
            stack.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int max = -1;
            boolean isFound = false;
            while (!stack.isEmpty() && !isFound) {
                int top = stack.pop();
                if (top > nums1[i]) max = top;
                else if (top == nums1[i]) isFound = true;
                temp.push(top);
            }
            result[i] = max;
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
        return result;
    }

    public int[] nextGreaterElementStackAndHashMap(int[] nums1, int[] nums2) {
//        栈+哈希表 解法
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && i > stack.peek()) {
                hashMap.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            hashMap.put(stack.pop(), -1);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElementTraverse(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int len = nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            result[i] = -1;
            for (int j = len - 1; j >= 0; j--) {
                if (nums2[j] > nums1[i]) result[i] = nums2[j];
                if (nums2[j] == nums1[i]) break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question496 question = new Question496();
        int[][][] cases = new int[][][]{
                {
                        {4,1,2}, {1,3,4,2}
                },
                {
                        {2,4},{1,2,3,4}
                },
                {
                        {4,1,2},
                        {1,2,3,4}
                },
                {
                        {1,3,5,2,4},
                        {6,5,4,3,2,1,7}
                }
        };
        int i = 1;
        for (int[][] aCase : cases) {
            System.out.printf("=====case%d=====\n", i++);
            System.out.println("nums1 = " + Arrays.toString(aCase[0]));
            System.out.println("nums2 = " + Arrays.toString(aCase[1]));
            System.out.println(Arrays.toString(question.nextGreaterElementTraverse(aCase[0], aCase[1])));
            System.out.println(Arrays.toString(question.nextGreaterElementStackAndHashMap(aCase[0], aCase[1])));
        }
    }
}
