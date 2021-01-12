package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 计算右侧小于当前元素的个数
 * @author: blessing
 * @create: 2020-07-11 13:28
 */
public class Question315 {
//    https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
    public List<Integer> countSmaller(int[] nums) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            tree.insert(nums[i], i, res);
        }
        List<Integer> list = new ArrayList<>();
        for (int re : res) {
            list.add(re);
        }
        return list;
    }

    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        private int leftCount;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BinarySearchTree {
        private TreeNode root;

        public void insert(int value, int index, int[] res) {
            if (root == null) {
                root = new TreeNode(value);
                return;
            }
            TreeNode p = root;
            while (true) {
                if (value <= p.value) {
                    p.leftCount++;
                    if (p.left == null) break;
                    p = p.left;
                } else {
                    if (p.right == null) break;
                    p = p.right;
                }
            }
            if (value <= p.value) {
                p.left = new TreeNode(value);
            } else {
                res[index] = p.leftCount + 1;
                p.right = new TreeNode(value);
            }
        }

        public void f(TreeNode root) {
            if (root == null)
                return;
            System.out.println(root.value);
            f(root.left);
            f(root.right);
        }
    }

    public static void main(String[] args) {
        Question315 question = new Question315();
        Question315.BinarySearchTree tree = new BinarySearchTree();
//        int[] nums = new int[]{3,2,1,6,3,1};
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length ; i++) {
//            tree.insert(nums[i], i, res);
//        }
//        tree.f(tree.root);
//        System.out.println(Arrays.toString(res));

        int[] case1 = new int[]{5,2,6,1};
        System.out.println(question.countSmaller(case1));
        int[] case2 = new int[]{1,3,6,1,2,3};
        System.out.println(question.countSmaller(case2));
    }
}
