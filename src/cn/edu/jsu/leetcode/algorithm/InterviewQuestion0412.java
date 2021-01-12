package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 求和路径
 * @author: blessing
 * @create: 2020-08-12 14:24
 */
public class InterviewQuestion0412 {
//    https://leetcode-cn.com/problems/paths-with-sum-lcci/

    public int pathSum(TreeNode root, int sum) {
//        https://leetcode-cn.com/submissions/detail/97303273/
//        无脑嵌套递归
//        执行用时：9 ms, 在所有 Java 提交中击败了50.19%的用户
//        内存消耗：39.9 MB, 在所有 Java 提交中击败了12.85%的用户
        if (root == null)
            return 0;
        int count = helper(root, sum);
        return count + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int remaining = sum-root.val;
        return (remaining == 0 ? 1 : 0) + helper(root.left, remaining) + helper(root.right, remaining);
    }

//    提交记录执行用时1ms范例（start）
    int res = 0;
    public int pathSum1ms(TreeNode root, int sum) {
        int dep = depth(root);
        int[] paths = new int[dep]; // 创建一个长度与树高度相同的数组辅助计算
        pathSum(root,sum,0,paths);
        return res;
    }

    private void pathSum(TreeNode root, int sum, int level, int[] paths) {  // 先序遍历二叉树
        if (root == null) return;
        paths[level] = root.val;
        int t = 0 ;
        for (int i = level; i >= 0; i--) {  // 计算当前节点到根节点路径的整数和
            t += paths[i];
            if (t == sum) res++;  // 若整数和满足条件，res+1，但不可break，因为接下来可能有val为0的节点
        }
        pathSum(root.left,sum,level+1,paths);
        pathSum(root.right,sum,level+1,paths);
    }

    private int depth(TreeNode root) {  // 计算树的高度
        if (root==null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
//    提交记录执行用时1ms范例（end）

    public static void main(String[] args) {
        InterviewQuestion0412 question = new InterviewQuestion0412();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);
        System.out.println(question.pathSum(tree, 22));

        TreeNode case73 = new TreeNode(1);
        case73.left = new TreeNode(2);
        case73.left.left = new TreeNode(3);
        case73.left.left.left = new TreeNode(4);
        case73.left.left.left.left = new TreeNode(5);
        System.out.println(question.pathSum(case73, 6));
    }
}
