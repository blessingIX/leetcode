package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 141. 环形链表
 * @author: blessing
 * @create: 2021-02-20 09:40
 */
public class Question141 {
//    https://leetcode-cn.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
