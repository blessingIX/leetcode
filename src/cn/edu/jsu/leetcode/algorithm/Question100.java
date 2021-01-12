package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 相同的树
 * @author: blessing
 * @create: 2020-08-05 18:16
 */
public class Question100 {
//    https://leetcode-cn.com/problems/same-tree/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Question100 question = new Question100();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right = new TreeNode(2);
        tree1.right.right = new TreeNode(3);
        tree1.right.left = new TreeNode(4);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.left.left = new TreeNode(3);
        tree2.left.right = new TreeNode(4);
        tree2.right = new TreeNode(2);
        tree2.right.right = new TreeNode(3);
        tree2.right.left = new TreeNode(4);

        System.out.println(question.isSameTree(tree1, tree2));
    }
}
