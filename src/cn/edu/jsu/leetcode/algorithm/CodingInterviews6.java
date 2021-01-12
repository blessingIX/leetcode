package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * @author: 易子建
 * @create: 2021-01-10 23:14
 */
public class CodingInterviews6 {
//    https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int[] arr = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            arr[list.size() - 1 - i] = list.get(i);
        }
        return arr;
    }

    //
//    public int[] reversePrint(ListNode head) {
//        int length = 0;
//        ListNode pre = head;
//        while(pre!=null){
//            length++;
//            pre = pre.next;
//        }
//        int[] res = new int[length];
//        while(head!=null){
//            length--;
//            res[length] = head.val;
//            head = head.next;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        CodingInterviews6 codingInterviews = new CodingInterviews6();

        ListNode ls = new ListNode(1);
        ls.next = new ListNode(3);
        ls.next.next = new ListNode(2);

        System.out.println(Arrays.toString(codingInterviews.reversePrint(ls)));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */