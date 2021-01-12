package cn.edu.jsu.leetcode.algorithm;


import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description: 对称二叉树
 * @author: blessing
 * @create: 2020-08-05 16:15
 */
public class Question101 {
//    https://leetcode-cn.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) { // 递归
        return check(root.left, root.right);
    }

    public boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;
        return  l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
    }

    public boolean isSymmetric1(TreeNode root) {    // 迭代
        if (root == null)
            return true;
        LinkedList<TreeNode> left = new LinkedList<>();
        LinkedList<TreeNode> right = new LinkedList<>();
        left.addLast(root.left);
        right.addLast(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.pollFirst();
            TreeNode r = right.pollFirst();
            if (l == null && r == null)
                continue;
            if ((l == null || r == null) || (l.val != r.val))
                return false;
            left.addLast(l.left);
            left.addLast(l.right);
            right.addLast(r.right);
            right.addLast(r.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Question101 question = new Question101();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        System.out.println(question.isSymmetric(null));
        tree.left.left = null;
        System.out.println(question.isSymmetric1(tree));
    }
}

