package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 206. 反转链表
 * @author: 易子建
 * @create: 2021-01-13 14:24
 */
public class Question206 {
//    https://leetcode-cn.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return reversList(head, null);
    }

    public ListNode reversList(ListNode head, ListNode pre) {
        if (head.next == null) {
            head.next = pre;
            return head;
        }
        ListNode listNode = reversList(head.next, head);
        head.next = pre;
        return listNode;
    }

    public ListNode reverseListDummy(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode dNext = dummy.next;
            ListNode hNext = head.next;
            dummy.next = head.next;
            head.next = hNext.next;
            hNext.next = dNext;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Question206 question = new Question206();
        String[] cases = new String[]{
                "1->2->3->4->5"
        };
        for (String aCase : cases) {
            ListNode listNode = Util.createListNodeByString(aCase, "->");
            System.out.print("before reverse: ");
            Util.ergodicList(listNode);
            System.out.print(" after reverse: ");
            Util.ergodicList(question.reverseListDummy(listNode));
        }
    }
}
