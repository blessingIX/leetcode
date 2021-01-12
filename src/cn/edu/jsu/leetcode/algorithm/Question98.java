package cn.edu.jsu.leetcode.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 验证二叉搜索树
 * @author: blessing
 * @create: 2020-08-06 11:05
 */
public class Question98 {
//    https://leetcode-cn.com/problems/validate-binary-search-tree/

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>(2);
        return inorder(root, list);
    }

    public boolean inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return true;
        if (!inorder(root.left, list)) return false;
        switch (list.size()) {
            case 0:
                list.add(root.val);
                break;
            case 1:
                list.add(root.val);
                if (list.get(1) <= list.get(0))
                    return false;
                break;
            case 2:
                list.set(0, list.get(1));
                list.set(1, root.val);
                if (list.get(1) <= list.get(0))
                    return false;
                break;
        }
        if (!inorder(root.right, list)) return false;
        return true;
    }

    public static void main(String[] args) {
        Question98 question = new Question98();
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        Util.preOrder(tree1, "null");
        System.out.println(question.isValidBST(tree1));

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(4);
        tree2.right.left = new TreeNode(3);
        tree2.right.right = new TreeNode(6);
        Util.preOrder(tree2, "null");
        System.out.println(question.isValidBST(tree2));
    }
}
