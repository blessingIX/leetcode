package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 检查子树
 * @author: blessing
 * @create: 2020-08-12 16:03
 */
public class InterviewQuestion0410 {
//    https://leetcode-cn.com/problems/check-subtree-lcci/
    boolean same;
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        same = false;
        dfs(t1, t2);
        return same;
    }

    public void dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null || same)
            return;
        if (t1.val == t2.val)
            same = checkTwoTrees(t1, t2);
        dfs(t1.left, t2);
        dfs(t1.right, t2);
    }

    public boolean checkTwoTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return t1.val == t2.val && checkTwoTrees(t1.left, t2.left) && checkTwoTrees(t1.right, t2.right);
    }

    public static void main(String[] args) {
        InterviewQuestion0410 question = new InterviewQuestion0410();
//        TreeNode tree1 = Util.buildTree("1, 2, 3");
//        Util.preOrder(tree1);
//
//        TreeNode tree2 = Util.buildTree("1, null, 2, 4");
//        Util.preOrder(tree2);
        TreeNode tree11 = new TreeNode(1);
        tree11.left = new TreeNode(2);
        tree11.right = new TreeNode(3);

        TreeNode tree12 = new TreeNode(2);

        System.out.println(question.checkSubTree(tree11, tree12));

        TreeNode tree21 = new TreeNode(1);
        tree21.right = new TreeNode(2);
        tree21.right.left = new TreeNode(4);

        TreeNode tree22 = new TreeNode(3);
        tree22.left = new TreeNode(2);

        System.out.println(question.checkSubTree(tree21, tree22));
    }
}
