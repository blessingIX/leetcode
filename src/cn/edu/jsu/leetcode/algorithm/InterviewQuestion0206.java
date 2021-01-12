package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 回文链表
 * @author: blessing
 * @create: 2020-05-20 08:34
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InterviewQuestion0206 {
//    https://leetcode-cn.com/problems/palindrome-linked-list-lcci/

    public boolean isPalindrome(ListNode head) {
//        利用快慢指针遍历链表，使得慢指针走到链表中点。
//        慢指针在前半段边走边使用头插法复制走过的节点建立一个新链表copy。(头插法保证了复制后的链表是反转的）
//        慢指针继续走完链表后半段，边走边比较两个链表的节点。
        ListNode fast = head;
        ListNode slow = head;
        ListNode copy = new ListNode(0);
        while (fast != null) {
            ListNode temp = new ListNode(slow.val);
            temp.next = copy.next;
            copy.next = temp;
            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pointer = copy.next;
        while (slow != null) {
            if (slow.val != pointer.val) {
                return false;
            }
            slow = slow.next;
            pointer = pointer.next;
        }
        return true;
    }

    public static void main(String[] args){
        ListNode ls = new ListNode(-1);
        ListNode pointer = ls;
        int[] number = new int[]{1, 2, 1, 3};
        for (int i = 0; i < number.length; i++) {
            pointer.next = new ListNode(number[i]);
            pointer = pointer.next;
        }

        pointer = ls.next;
        while (pointer != null) {
            System.out.print(pointer.val);
            pointer = pointer.next;
        }

        InterviewQuestion0206 interviewQuestion0206 = new InterviewQuestion0206();
        System.out.println(": " + interviewQuestion0206.isPalindrome(ls.next));
    }
}