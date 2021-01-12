package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 二叉树的最近公共祖先
 * @author: blessing
 * @create: 2020-08-10 08:36
 */
public class Question236 {
//    https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) // 树为空或遍历到叶子节点 || 当前节点是需要找的p节点 || 当前节点是需要找的q节点
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);  // 在左子树中查找p或q（未找到返回null）
        TreeNode right = lowestCommonAncestor(root.right, p, q);    // 在右子树中查找p或q（未找到返回null）
        if (left != null && right != null)  // p、q分布在当前节点左右子树中
            return root;
        return left != null ? left : right; // p、q同时分布在当前节点的左子树或右子树中
    }

    public static void main(String[] args) {
        Question236 question = new Question236();
        TreeNode tree = new TreeNode(3);
        TreeNode p1 = tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(2);
        tree.left.right.left = new TreeNode(7);
        TreeNode q2 = tree.left.right.right = new TreeNode(4);
        TreeNode q1 = tree.right = new TreeNode(1);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(8);
        System.out.println(question.lowestCommonAncestor(tree, p1, q1).val);
        System.out.println(question.lowestCommonAncestor(tree, p1, q2).val);
    }
}
