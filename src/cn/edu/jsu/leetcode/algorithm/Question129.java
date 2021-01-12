package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description: 求根到叶子节点数字之和
 * @author: blessing
 * @create: 2020-08-09 13:24
 */
public class Question129 {
//    https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/

    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        childSum(0, root);
        return sum;
    }

    public void childSum(int val, TreeNode root) {
        if (root == null)
            return;
        int num = (val * 10 + root.val);    // val为父节点计算结果，子节点结果=父节点*10+子节点.val
        if (root.left == null && root.right == null)    // 当前节点为叶子节点，将计算结果追加到sum
            sum += num;
        childSum(num, root.left);   // 将当前节点计算结果传递给左孩子用于计算
        childSum(num, root.right);  // 将当前节点计算结果传递给右孩子用于计算
    }

    public static void main(String[] args) {
        Question129 question = new Question129();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        System.out.println(question.sumNumbers(tree1));

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(9);
        tree2.left.left = new TreeNode(5);
        tree2.left.right = new TreeNode(1);
        tree2.right = new TreeNode(0);
        System.out.println(question.sumNumbers(tree2));
    }
}
