package cn.edu.jsu.leetcode.algorithm;

import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description: 剑指 Offer 09. 用两个栈实现队列
 * @author: blessing
 * @create: 2020-06-30 09:50
 */
public class CodingInterviews9 {
//    https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
    public static void main(String[] args) {
        String[] ops1 = new String[]{"CQueue","appendTail", "deleteHead", "deleteHead"};
        int[] nums1 = new int[]{0, 3, 0, 0};
        System.out.println(testMethod(ops1, nums1));
        String[] ops2 = new String[]{"CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"};
        int[] nums2 = new int[]{0, 0, 5, 2, 0, 0};
        System.out.println(testMethod(ops2, nums2));
    }

    public static String testMethod(String[] ops, int[] nums) {
//        用于返回形如 [null,-1,null,null,5,2] 测试结果
        CQueue cQueue = new CQueue();
        int len = Math.min(ops.length, nums.length);
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < len; i++) {
            switch (ops[i]) {
                case "CQueue":
                    cQueue = new CQueue();
                    stringBuilder.append("null");
                    break;
                case "appendTail":
                    cQueue.appendTail(nums[i]);
                    stringBuilder.append("null");
                    break;
                case "deleteHead":
                    int value = cQueue.deleteHead();
                    stringBuilder.append(Integer.toString(value));
                    break;
            }
            if (i != len - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class CQueue {
        LinkedList<Integer> stack1; // stack1负责入队操作
        LinkedList<Integer> stack2; // stack2负责出队操作

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
//            执行CQueue出队时，试图从stack2中直接取，若stack2为空则试图将stack1中元素全部出栈，入栈到stack2，再从stack2去一个元素返回，若两栈皆空则返回-1
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */