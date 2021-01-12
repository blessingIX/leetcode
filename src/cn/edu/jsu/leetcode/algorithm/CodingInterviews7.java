package cn.edu.jsu.leetcode.algorithm;

import cn.edu.jsu.leetcode.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 剑指 Offer 07. 重建二叉树
 * @author: blessing
 * @create: 2020-08-05 19:02
 */
public class CodingInterviews7 {
//    https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0)
//            return null;
//        return build(inorder, preorder, 0, preorder.length-1);
//    }
//
//    public TreeNode build(int[] preorder, int[] inorder, int start, int end) {
//        int len = end - start + 1;
//        if (len == 0) return null;
//        if (len == 1) return new TreeNode(preorder[start]);
//        int mid = find(inorder, start, len, preorder[start]);
//        TreeNode node = new TreeNode(preorder[mid]);
//        node.left = build(preorder, inorder, start, mid-1);
//        node.right = build(preorder, inorder, mid+1, end);
//        return node;
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        int len = preorder.length;
        return buildTree(preorder, 0, len -1, inorder, 0, len - 1, idxMap);
    }

    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> idxMap) {
//        通过前序遍历确定每棵子树的根节点，再在中序遍历中查找根节点的位置mid，mid左边为左子树节点，右边为右子树节点
//        中序遍历中mid左边的节点个数llen，前序遍历的根节点后紧跟的llen个节点
//        每棵树的节点分布情况：
//        前序遍历 [根节点, 左子树节点...(llen), 右子树节点...(rlen)]
//        中序遍历 [左子树节点...(llen), 根节点, 右子树节点...(rlen)]
//        前中序遍历的左子树区间节点个数一定相等，但顺序不一定相同（因为这些节点还可以构成一个左子树），右子树区间同理。
        if (ps > pe) return null;   // preorder遍历完成，没有节点，直接返回null
        TreeNode root = new TreeNode(preorder[ps]);
        if (ps == pe) return root;  // preorder中只剩下一个节点，构造节点直接返回
        int mid = idxMap.get(preorder[ps]);
        int llen = mid - is;    // 左子树区间长度
        int rlen = ie - mid;    // 右子树区间长度
        root.left = buildTree(preorder, ps+1, ps+llen, inorder, is, mid-1, idxMap); // 递归构建左子树
        root.right = buildTree(preorder, pe-rlen+1, pe, inorder, mid+1, ie, idxMap);    // 递归构建右子树
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        int len = end - start + 1;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(preorder[start]);
        int mid = find(inorder, start, len, preorder[start]);
        TreeNode node = new TreeNode(preorder[mid]);
        node.left = build(preorder, inorder, start, mid-1);
        node.right = build(preorder, inorder, mid+1, end);
        return node;
    }

    public int find(int[] arr, int offset, int len, int val) {
        // 前序遍历确定每棵子树的根节点，通过此方法在中序遍历数组中查找根节点的位置mid，
        // mid左边都是左子树的节点，mid右边都是右子树的节点。
        // 循环查找效率太低，官方题解使用HashMap加快查找根节点
        for (int i = offset; i < offset + len; i++) {
            if (arr[i] == val)
                return i;
        }
        return offset;
    }

    public static void main(String[] args) {
        CodingInterviews7 codingInterviews = new CodingInterviews7();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode tree = codingInterviews.buildTree(preorder, inorder);
        Util.preOrder(tree);
        System.out.println("case34:");
        int[][] case34 = new int[][]{
                {1,2,3},
                {3,2,1}
        };
        Util.preOrder(codingInterviews.buildTree(case34[0], case34[1]));

    }

}
