package cn.edu.jsu.leetcode.algorithm;


import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树的中序遍历（进阶: 递归算法很简单，你可以通过迭代算法完成吗？）
 * @author: blessing
 * @create: 2020-08-06 09:23
 */
public class Question94 {
//    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Question94 question = new Question94();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.left.left = new TreeNode(3);
        tree1.left.right = new TreeNode(4);
        tree1.right = new TreeNode(2);
        tree1.right.right = new TreeNode(3);
        tree1.right.left = new TreeNode(4);
        System.out.println(Arrays.toString(question.inorderTraversal(tree1).toArray()));
    }
}
