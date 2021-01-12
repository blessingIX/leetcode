package cn.edu.jsu.leetcode.algorithm;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description: 二叉搜索树迭代器
 * @author: blessing
 * @create: 2020-08-09 14:49
 */
public class Question173 {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(tree);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class BSTIterator {

    private Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null) {
            stack.addFirst(p);
            p = p.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.removeFirst();
        if (node.right != null) {
            TreeNode p = node.right;
            while (p != null) {
                stack.addFirst(p);
                p = p.left;
            }
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */