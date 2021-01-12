package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 后继者
 * @author: blessing
 * @create: 2020-08-12 17:38
 */
public class InterviewQuestion0406 {
//    https://leetcode-cn.com/problems/successor-lcci/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        TreeNode successor = null;
        if (root.val > p.val)
            successor = root;
        TreeNode left = inorderSuccessor(root.left, p);
        TreeNode right = inorderSuccessor(root.right, p);
        if (successor == null) {
            successor = left != null ? left : right;
        } else {
            successor = (left != null && left.val > p.val && left.val < successor.val) ? left : successor;
            successor = (right != null && right.val > p.val && right.val < successor.val) ? right : successor;
        }
        return successor;
    }

    public static void main(String[] args) {
        InterviewQuestion0406 question = new InterviewQuestion0406();
        TreeNode tree1 = new TreeNode(2);
        TreeNode p1 = tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        TreeNode node1 = question.inorderSuccessor(tree1, p1);
        System.out.println(node1 == null ? null : node1.val);

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(3);
        tree2.left.left = new TreeNode(2);
        tree2.left.left.left = new TreeNode(1);
        tree2.left.right = new TreeNode(4);
        TreeNode p2 = tree2.right = new TreeNode(6);
        TreeNode node2 = question.inorderSuccessor(tree2, p2);
        System.out.println(node2 == null ? null : node2.val);

        TreeNode case12 = new TreeNode(2);
        case12.right = new TreeNode(3);
        TreeNode node12 = question.inorderSuccessor(case12, case12);
        System.out.println(node12 == null ? null : node12.val);

        TreeNode case13 = new TreeNode(5);
        case13.left = new TreeNode(3);
        case13.left.left = new TreeNode(2);
        case13.left.right = new TreeNode(4);
        TreeNode p13 = case13.left.left.left = new TreeNode(1);
        case13.right = new TreeNode(6);
        TreeNode node13 = question.inorderSuccessor(case13, p13);
        System.out.println(node13 == null ? null : node13.val);

    }
}
