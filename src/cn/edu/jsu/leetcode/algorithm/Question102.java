package cn.edu.jsu.leetcode.algorithm;


import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树的层序遍历
 * @author: blessing
 * @create: 2020-08-06 12:11
 */
public class Question102 {
//    https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.addLast(root);
            while (!deque.isEmpty()) {
                List<Integer> r = new ArrayList<>();
                res.add(r);
                int len = deque.size();
                while (len-- > 0) {
                    TreeNode node = deque.removeFirst();
                    r.add(node.val);
                    if (node.left != null)
                        deque.addLast(node.left);
                    if (node.right != null)
                        deque.addLast(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question102 question = new Question102();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        List<List<Integer>> ll = question.levelOrder(tree);
        for (List<Integer> l : ll) {
            for (Integer integer : l) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }
}
