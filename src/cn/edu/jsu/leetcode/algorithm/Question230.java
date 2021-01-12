package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 二叉搜索树中第K小的元素
 * @author: blessing
 * @create: 2020-08-09 17:26
 */
public class Question230 {
//    https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/

    int kthSmallest;
    boolean found;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest = 0;
        found = false;
        this.k = k;
        inorder(root);
        return kthSmallest;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (--k == 0 && !found) {
            kthSmallest = root.val;
            found = true;
        }
        if (found)
            return;
        inorder(root.right);
    }

    public static void main(String[] args) {
        Question230 question = new Question230();
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);
        tree1.right = new TreeNode(4);
        System.out.println(question.kthSmallest(tree1, 1));

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(3);
        tree2.left.left = new TreeNode(2);
        tree2.left.left.left = new TreeNode(1);
        tree2.left.right = new TreeNode(4);
        tree2.right = new TreeNode(6);
        System.out.println(question.kthSmallest(tree2, 3));
    }
}
