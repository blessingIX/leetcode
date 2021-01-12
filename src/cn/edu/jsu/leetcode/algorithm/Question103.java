package cn.edu.jsu.leetcode.algorithm;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉树的锯齿形层次遍历
 * @author: blessing
 * @create: 2020-08-06 15:08
 */
public class Question103 {
//    https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.addLast(root);
            boolean d = true;
            while (!deque.isEmpty()) {
                List<Integer> r = new ArrayList<>();
                res.add(r);
                int len = deque.size();
                while (len-- > 0) {
                    TreeNode node = d ? deque.removeFirst() : deque.removeLast();
                    r.add(node.val);
                    if (d) {
                        if (node.left != null)
                            deque.addLast(node.left);
                        if (node.right != null)
                            deque.addLast(node.right);
                    } else {
                        if (node.right != null)
                            deque.addFirst(node.right);
                        if (node.left != null)
                            deque.addFirst(node.left);
                    }
                }
                d = !d;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question103 question = new Question103();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        tree.right.left.left = new TreeNode(22);
        tree.right.left.right = new TreeNode(24);
        List<List<Integer>> ll = question.zigzagLevelOrder(tree);
        for (List<Integer> l : ll) {
            for (Integer integer : l) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }
}
