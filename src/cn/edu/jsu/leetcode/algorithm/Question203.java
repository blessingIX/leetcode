package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 203. 移除链表元素
 * @author: 易子建
 * @create: 2021-01-13 13:58
 */
public class Question203 {
//    https://leetcode-cn.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = head;
        head = pre;
        while (p != null) {
            if (p.val == val) {
                p = p.next;
                pre.next = p;
            } else {
                pre = p;
                p = p.next;
            }

        }
        return head.next;
    }

    public static void main(String[] args) {
        Question203 question = new Question203();
        String[] cases = new String[]{
                "1->2->6->3->4->5->6",
                "1->1"
        };
        int[] values = new int[]{
                6,
                1
        };
        for (int i = 0; i < cases.length; i++) {
            ListNode listNode = Util.createListNodeByString(cases[i], "->");
            Util.ergodicList(listNode);
            Util.ergodicList(question.removeElements(listNode, values[i]));
        }
    }
}
