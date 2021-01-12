package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 删除二叉搜索树中的节点
 * @author: blessing
 * @create: 2020-08-10 17:40
 */
public class Question450 {
//    https://leetcode-cn.com/problems/delete-node-in-a-bst/
    public TreeNode deleteNode(TreeNode root, int key) {    //
        TreeNode[] keyNode = findNodeAndParent(root, null, key);    // 找到要删除节点左子树中最大节点max，max覆盖眼删除的节点，最后删除max
//        System.out.println((keyNode[0] != null ? keyNode[0].val : "null") + " " + (keyNode[1] != null ? keyNode[1].val : "null"));
        if (keyNode[0] == null)
            return root;
        TreeNode parent = keyNode[0];
        TreeNode max = parent.left;
        if (max == null) {  // 左子树为空
            if (keyNode[1] == null) // 要删除的节点是根节点（即没有父节点），直接返回要删除节点的右子树
                return keyNode[0].right;
            if (keyNode[1].left == keyNode[0])  // 要删除节点是其父节点的左孩子
                keyNode[1].left = keyNode[0].right;
            else    // 要删除节点是其父节点的右孩子
                keyNode[1].right = keyNode[0].right;
            return root;
        }
        while (max.right != null) { // 存在左子树，那么最右端的节点就是最大的节点。拿到最大节点及其父节点
            parent = max;
            max = max.right;
        }
        keyNode[0].val = max.val;   //  要删除节点左子树中的最大节点覆盖要删除的节点
        if (parent.left == max) // // 要删除节点是其父节点的左孩子
            parent.left = max.left; // 最大节点必定没有右子树，所以总是将左子树给要删除节点left或right
        else
            parent.right = max.left;
        return root;
    }

    public TreeNode[] findNodeAndParent(TreeNode root, TreeNode parent, int key) {  // 查找指定节点及其父节点
        if (root == null)
            return new TreeNode[]{null, null};
        if (root.val == key)
            return new TreeNode[]{root, parent};
        TreeNode[] left = findNodeAndParent(root.left, root, key);
        TreeNode[] right = findNodeAndParent(root.right, root, key);
        if (left[0] != null)
            return left;
        return right;
    }

    public static void main(String[] args) {
        Question450 question = new Question450();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        question.test(tree, 3);
        question.test(tree, 6);
        question.test(tree, 5);

    }

    public static void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void test(TreeNode tree, int key) {
        System.out.print("删除"+key+"之前：");
        preorder(tree);
        System.out.println();
        tree = deleteNode(tree, key);
        System.out.print("删除"+key+"之后：");
        preorder(tree);
        System.out.println();
    }
}
