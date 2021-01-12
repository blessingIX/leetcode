package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 合并K个排序链表
 * @author: blessing
 * @create: 2020-05-21 10:11
 */
public class Question23_loop {
    // 循环迭代
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        ListNode[] pointers = new ListNode[lists.length];
        for (int i = 0; i < pointers.length; i++) {
            pointers[i] = lists[i];
        }
        while (!isEnd(pointers)) {
            int minIndex = -1;
            int minVal = 0;
            boolean[] l = isRemaining(pointers);
            for (int i = 0; i < l.length; i++) {
                if (l[i]) {
                    minIndex = i;
                    minVal = pointers[minIndex].val;
                    break;
                }
            }
            for (int i = minIndex; i < pointers.length; i++) {
                if (l[i] && pointers[i].val < minVal) {
                    minVal = pointers[i].val;
                    minIndex = i;
                }
            }
            pointer.next = new ListNode(minVal);
            pointer = pointer.next;
            if (pointers[minIndex] != null)
                pointers[minIndex] = pointers[minIndex].next;
        }
        return result.next;
    }

    private boolean isEnd(ListNode[] pointers) {
        for (ListNode pointer : pointers) {
            if (pointer != null)
                return false;
        }
        return true;
    }

    private boolean[] isRemaining(ListNode[] pointers) {
        boolean[] array = new boolean[pointers.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = pointers[i] != null;
        }
        return array;
    }

    public static void main(String[] args){
        Question23_loop question23 = new Question23_loop();
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(1);
        listNodes[1].next = new ListNode(3);
        listNodes[1].next.next = new ListNode(4);

        listNodes[2] = new ListNode(2);
        listNodes[2].next = new ListNode(6);

        ListNode result = question23.mergeKLists(listNodes);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
