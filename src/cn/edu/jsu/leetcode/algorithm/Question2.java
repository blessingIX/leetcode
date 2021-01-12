package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description:
 * @author: blessing
 * @create: 2020-05-19 22:24
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 同时遍历两个链表直到两个链表都遍历完，相加，进位，存到result链表，再返回result
        ListNode result = null;
        ListNode pointer = null;
        int progression = 0;
        boolean isEnd1 = false;
        boolean isEnd2 = false;
        int val1 = 0;
        int val2 = 0;

        while (true) {
            if (l1 == null)
                isEnd1 = true;
            if (l2 == null)
                isEnd2 = true;
            if (isEnd1 && isEnd2)
                break;

            if (isEnd1) {
                val1 = 0;
            } else {
                val1 = l1.val;
            }
            if (isEnd2) {
                val2 = 0;
            } else {
                val2 = l2.val;
            }
            int x = val1 + val2 + progression;
            if (x > 9) {
                progression = 1;
                x -= 10;
            } else {
                progression = 0;
            }
            if (result == null) {
                result = new ListNode(x);
                pointer = result;
            } else {
                pointer.next = new ListNode(x);
                pointer = pointer.next;
            }

            if (!isEnd1)
                l1 = l1.next;
            if (!isEnd2)
                l2 = l2.next;

        }
        if (progression == 1)
            pointer.next = new ListNode(1);
        return result;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(4);

        Question2 q2 = new Question2();
        ListNode result = q2.addTwoNumbers(l1, l2);

        ListNode p = result;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}