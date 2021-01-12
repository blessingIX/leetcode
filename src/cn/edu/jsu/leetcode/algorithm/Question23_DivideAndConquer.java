package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 合并K个排序链表
 * @author: blessing
 * @create: 2020-05-21 11:23
 */
public class Question23_DivideAndConquer {
    // 合并K个排序链表（分治法）
    public ListNode mergeKLists(ListNode[] lists) {
        return merge2Lists(merge(lists, 0, lists.length - 1), null);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
//        递归拆分链表数组（拆分成两个链表一组）并调用merge2Lists方法合并链表并返回

        int length = end - start + 1;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[start];
        } else if (length == 2) {
            return merge2Lists(lists[start], lists[end]);
        }
        int mid = start + (end - start) / 2;
        return merge2Lists(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
//        递归合并两个链表并返回

//        l1为空时，返回l2
        if (l1 == null) return l2;
//        l2为空时 或者 l1和l2都为空时，返回l1
        if (l2 == null) return l1;

//        l1和l2都不为空时，两个链表进行比较
        ListNode head = null;   // 并用head存储合并后的链表
        if (l1.val <= l2.val) {
            head = l1;
            head.next = merge2Lists(l1.next, l2);
        } else {
            head = l2;
            head.next = merge2Lists(l1, l2.next);
        }
        return head;
    }



    public static void main(String[] args){
        Question23_DivideAndConquer question23 = new Question23_DivideAndConquer();
        ListNode[] listNodes = new ListNode[] {
            Util.createListNodeByString("1,4,5"),
            Util.createListNodeByString("1,3,4"),
            Util.createListNodeByString("2,6")
        };
        ListNode[] case60 = new ListNode[] {
                null,
                null,
                Util.createListNodeByString("1,4,6"),
                Util.createListNodeByString("4,5,6")
        };
        case60[1] = new ListNode(-1);
        case60[1].next = new ListNode(5);
        ListNode result = question23.mergeKLists(listNodes);
        Util.ergodicList(result);

        Util.ergodicList(question23.mergeKLists(case60));
    }
}
