package cn.edu.jsu.leetcode.algorithm;


/**
 * @program: LeetCode
 * @description:
 * @author: blessing
 * @create: 2020-08-09 16:19
 */
public class Question222 {
//    https://leetcode-cn.com/problems/count-complete-tree-nodes/

    int height;
    public int countNodes1(TreeNode root) {
        TreeNode p = root;
        height = 0;
        while (p != null) {
            height++;
            p = p.left;
        }
        int missingCount = missingNodesCount(root, 1);
        int count = 0;
        for (int i = 0; i < height; i++) {
            count += Math.pow(2, i);
        }
        return count - missingCount;
    }

    public int missingNodesCount(TreeNode root, int deep) {
        if (root == null)
            return 0;
        int missingCount = 0;
        if (deep == height - 1) {
            if (root.right == null) {
                missingCount++;
                if (root.left == null)
                    missingCount++;
            }
        }
        return missingCount + missingNodesCount(root.right, deep+1) + missingNodesCount(root.left, deep+1);
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        Question222 question = new Question222();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);
        System.out.println(question.countNodes(tree));
    }
}
