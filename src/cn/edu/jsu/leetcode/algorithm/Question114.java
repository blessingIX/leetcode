package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 二叉树展开为链表
 * @author: blessing
 * @create: 2020-08-06 19:19
 */
public class Question114 {
//    https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/

    public void flatten(TreeNode root) {
        helper(root);
    }

    public TreeNode helper (TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = helper(root.left);
        TreeNode right = root.right;
        TreeNode last = (left == null) ? root : lastRightNode(left);
        root.left = null;
        root.right = left;
        last.right = helper(right);
        return root;
    }

    public TreeNode lastRightNode(TreeNode root) {
        TreeNode slow = root;
        TreeNode fast = root;
        while (fast != null) {
            slow = fast;
            fast = fast.right;
        }
        return slow;
    }

    public static void main(String[] args) {
        Question114 question = new Question114();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);
        question.flatten(tree);
        Util.preOrder(tree, "null");
    }
}
