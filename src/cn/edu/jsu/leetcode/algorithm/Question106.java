package cn.edu.jsu.leetcode.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 从中序与后序遍历序列构造二叉树
 * @author: blessing
 * @create: 2020-08-06 16:19
 */
public class Question106 {
//    https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return null;
        int len = postorder.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree( 0, len-1, postorder, len-1, 0, idxMap);
    }

    public TreeNode buildTree(int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> idxMap) {
        if (ps < pe)
            return null;
        TreeNode node = new TreeNode(postorder[ps]);
        if (ps == pe)
            return node;
        int mid = idxMap.get(postorder[ps]);
        int llen = mid - is;
        int rlen = ie - mid;
        node.right = buildTree(mid+1, ie, postorder, ps-1, ps-rlen, idxMap);
        node.left = buildTree(is, mid-1, postorder, pe+llen-1, pe, idxMap);
        return node;
    }

//    int post_idx;
//    HashMap<Integer, Integer> idx_map = new HashMap<>();
//
//    public TreeNode helper(int in_left, int in_right, int[] postorder) {
//        if (in_left > in_right)
//            return null;
//        int rootVal = postorder[post_idx--];
//        TreeNode root = new TreeNode(rootVal);
//        int index = idx_map.get(rootVal);
//        root.right = helper(index+1, in_right, postorder);
//        root.left = helper(in_left, index-1, postorder);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        post_idx = postorder.length - 1;
//        int idx = 0;
//        for (Integer val : inorder)
//            idx_map.put(val, idx++);
//        return helper(0, inorder.length - 1, postorder);
//    }

    public static void main(String[] args) {
        Question106 question = new Question106();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder  = new int[]{9,15,7,20,3};
        TreeNode tree = question.buildTree(inorder, postorder);
        Util.preOrder(tree, "null");
    }
}
