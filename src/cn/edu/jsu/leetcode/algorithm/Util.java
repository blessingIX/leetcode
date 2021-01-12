package cn.edu.jsu.leetcode.algorithm;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 包含一些生成测试案例方法的工具类
 * @author: blessing
 * @create: 2020-05-21 11:25
 */
public class Util {
    public static ListNode createListNodeByString(String string, String separator) {
        String[] strings = string.split(separator);
        int[] array = new int[strings.length];
        for(int i=0; i < array.length; i++){
            array[i]=Integer.parseInt(strings[i].trim());
        }
        ListNode listNode = new ListNode(0);
        ListNode pointer = listNode;
        for (int i = 0; i < array.length; i++) {
            pointer.next = new ListNode(array[i]);
            pointer = pointer.next;
        }
        return listNode.next;
    }

    public static ListNode createListNodeByString(String string) {
        return createListNodeByString(string, ",");
    }

    public static void ergodicList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static ListNode getKNode(ListNode list, int k) {
        if (list == null || k <= 0) return null;
        ListNode pointer = list;
        while (k > 1) {
            if (pointer == null) return null;
            pointer = pointer.next;
            k--;
        }
        return pointer;
    }

    public static void ergodicMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void preOrder(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrder(TreeNode root, String em) {
        if (root == null){
            System.out.println(em);
            return;
        }
        System.out.println(root.val);
        preOrder(root.left, em);
        preOrder(root.right, em);
    }

    public static TreeNode buildTree(String string, String sep) {
//        FIXME: 从形如 1, 2, 3, null, null 的字符串创建二叉树
//        if ("".equals(string))
//            return null;
//        String[] strings = string.split(sep);
//        if (strings.length == 0)
//            return null;
//        Queue<String> queue = new LinkedList<>(Arrays.asList(strings));
//        boolean left = true;
//        for (String s : strings) {
//            TreeNode n
//        }
//        for (String str : strings) {
//            if (queue.isEmpty()) {
//                queue.add(treeNode);
//                continue;
//            }
//            if (left) {
//                queue.peek().left = treeNode;
//                if (treeNode != null)
//                    queue.offer(treeNode);
//                left = false;
//            } else {
//                queue.poll().right = treeNode;
//                if (treeNode != null)
//                    queue.add(treeNode);
//            }
//        }
//        return treeNodes[0];
        return null;
    }

    public static TreeNode buildTree(String string) {
        return buildTree(string, ", ");
    }
}
