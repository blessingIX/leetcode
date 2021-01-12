package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 链表中倒数第k个节点
 * @author: blessing
 * @create: 2020-05-21 09:30
 */
public class InterviewQuestion22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0) return null;
        ListNode pointer = head;
        while (pointer != null) {
            k--;
            pointer = pointer.next;
        }
        if (k > 0)
            return null;
        pointer = head;
        while (k < 0) {
            k++;
            pointer = pointer.next;
        }
        return pointer;
    }

    public static void main(String[] args){
        InterviewQuestion22 interviewQuestion22 = new InterviewQuestion22();

        ListNode ls = new ListNode(1);
        ListNode pointer = ls;
        int[] number = new int[]{2 ,3, 4, 5};
        for (int i = 0; i < number.length; i++) {
            pointer.next = new ListNode(number[i]);
            pointer = pointer.next;
        }
        pointer = interviewQuestion22.getKthFromEnd(ls, 3);
        while (pointer != null) {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }
}
