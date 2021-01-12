package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: K 个一组翻转链表
 * @author: blessing
 * @create: 2020-05-22 11:54
 */
public class Question25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1 || head.next == null) return head;
        ListNode fast = head;
        int j = k;
        while (fast != null) {
            j--;
            fast = fast.next;
            if (j == 0) break;
        }
        if (j > 0) return head;
        ListNode pre = reverseKGroup(fast, k);
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = pre;
            pre = cur;
            cur = cur.next;
            pre.next = temp;
        }
        return pre;
    }

    public ListNode reverseLinkedList(ListNode head) {
//        链表为空 或者 链表只有一个元素，直接返回此链表
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k == 1) return head;
        ListNode[] stack = new ListNode[k];
        int i = 0;
        ListNode result = new ListNode(0);
        ListNode p1 = head;
        ListNode p2 = result;
        while (p1 != null) {
            stack[i++] = p1;
            if (i == k) {
                i--;
                while (true) {
                    p2.next = new ListNode(stack[i--].val);
                    p2 = p2.next;
                    if (i == -1) {
                        i = 0;
                        break;
                    }
                }
            }
            p1 = p1.next;
        }
        if (i > 0) {
            i--;
            while (true) {
                p2.next = new ListNode(stack[i--].val);
                p2 = p2.next;
                if (i == -1) {
                    i = 0;
                    break;
                }
            }
        }
        return result.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1 || head.next == null) return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode slow = result;
        ListNode fast = head;
        int j;
        ListNode start;
        ListNode pre;
        ListNode cur;
        ListNode next;
        ListNode end;
        while (fast != null) {
            j = 0;
            pre = null;
            cur = start = end = fast;
            next = cur.next;
            for (int i = 0; i < k; i++) {
                j++;
                fast = fast.next;
                if (fast == null) break;
            }
            if (j == k) {
                while (next != fast) {
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    next = next.next;
                }
                cur.next = pre;
                end.next = fast;
                start = cur;
            }
            slow.next = start;
            slow = end;
        }
        return result.next;
    }

    public static void main(String[] args){
        Question25 question = new Question25();
        ListNode list = Util.createListNodeByString("1,2,3,4,5,6,7,8,9,10");
        Util.ergodicList(list);
        System.out.println("==========");
        list = question.reverseKGroup(list, 3);
        Util.ergodicList(list);


        ListNode case1 = Util.createListNodeByString("1");
        case1 = question.reverseLinkedList(case1);
        Util.ergodicList(case1);
        System.out.println("k=1时：");
        Util.ergodicList(question.reverseKGroup(Util.createListNodeByString("1,2,3,4,5,6,7,8,9,10"), 1));
        System.out.println("k=2时：");
        Util.ergodicList(question.reverseKGroup(Util.createListNodeByString("1,2,3,4,5,6,7,8,9,10"), 2));
        System.out.println("k=3时：");
        Util.ergodicList(question.reverseKGroup(Util.createListNodeByString("1,2,3,4,5,6,7,8,9,10"), 3));
        System.out.println("链表为空时：");
        Util.ergodicList(question.reverseKGroup(null, 2));
    }
}
