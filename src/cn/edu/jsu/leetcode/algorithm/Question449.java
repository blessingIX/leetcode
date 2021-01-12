package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 序列化和反序列化二叉搜索树
 * @author: blessing
 * @create: 2020-08-10 15:34
 */
public class Question449 {
//    https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
    public static void main(String[] args) {
        Question449 question = new Question449();
        Codec codec = new Codec();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(1);
        tree.right = new TreeNode(7);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(8);

        System.out.print("before serialize: ");
        question.preorder(tree);
        System.out.println();
        String data = codec.serialize(tree);
        System.out.print("after serialize: ");
        System.out.println(data);
        TreeNode res = codec.deserialize(data);
        System.out.print("after deserialize: ");
        question.preorder(res);
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        preorder(root.left);
        System.out.print(root.val + ",");
        preorder(root.right);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        return String.valueOf(root.val) + ',' + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) // 前三次提交没有考虑data为""的情况，https://leetcode-cn.com/problems/serialize-and-deserialize-bst/submissions/
            return null;
        String[] strings = data.split(",");
        int len = strings.length;
        int[] ints = new int[len];
        TreeNode tree = null;
        for (String string : strings) {
            if (tree == null)
                tree = new TreeNode(Integer.parseInt(string));
            else
                insert(tree, Integer.parseInt(string));
        }
        return tree;
    }

    private void insert(TreeNode root, int val) {
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));