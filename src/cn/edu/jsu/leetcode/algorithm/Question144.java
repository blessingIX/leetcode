package cn.edu.jsu.leetcode.algorithm;


import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树的前序遍历
 * @author: blessing
 * @create: 2020-08-07 21:54
 */
public class Question144 {
//    https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;   // node表示当前遍历的节点，初始化为root
        while (node != null || !stack.isEmpty()) {  // node != null 表示还有为遍历到的元素可以压栈， !stack.isEmpty()表示栈中还有元素可以弹栈
            while (node != null) {  // 左孩子不断压栈
                list.add(node.val); // 获取node.val
                stack.push(node);
                node = node.left;
            }
            node = stack.pop(); // 弹栈
            node = node.right;  // 将当前遍历节点改为右孩子
        }
        return list;
    }

    public List<Integer> postordeTraversal(TreeNode root) { // 扩展：非递归后序遍历
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        Collections.reverse(list);  // 反转list，因为前后序遍历结果完全相反
        return list;
    }

    public static void main(String[] args) {
        Question144 question = new Question144();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(question.preorderTraversal(tree).toArray()));
        System.out.println(Arrays.toString(question.postordeTraversal(tree).toArray()));
    }
}
