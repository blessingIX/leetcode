package cn.edu.jsu.leetcode.algorithm;


import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: blessing
 * @create: 2020-08-09 15:38
 */
public class Question199 {
//    https://leetcode-cn.com/problems/binary-tree-right-side-view/

    public List<Integer> rightSideView(TreeNode root) { // 二叉树层序遍历，获取每层最右边的节点
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null)
            return list;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            list.add(deque.getFirst().val);
            int len = deque.size();
            while (len-- > 0) {
                TreeNode node = deque.removeFirst();
                if (node.right != null)
                    deque.addLast(node.right);
                if (node.left != null)
                    deque.addLast(node.left);
            }
        }
        return list;
    }

//    提交记录0ms执行用时范例 start
    int max_dep = -1;
    public List<Integer> rightSideView0ms(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,0,list);
        return list;
    }
    public void dfs(TreeNode root,int dep,List<Integer> list){
        if (root==null) {
            return;
        }
        if (dep>max_dep) {  // 同一层的TreeNode靠右的节点先于靠左的（遍历次序不连续，因为是递归遍历），每次访问最右侧节点时，max_dep还是上一层的dep，
            list.add(root.val); // 此时该层dep已经是上一层的dep+1，所以最右边的节点必定满足 dep > max_dep，由于max_dep++，导致同层的其他节点必定不满足 dep > max_dep
            max_dep++;
        }
        dfs(root.right,dep+1,list); // 每下一层深度+1
        dfs(root.left,dep+1,list);  // root.right 在前，root.left 在后
    }
//    提交记录0ms执行用时范例 end

    public static void main(String[] args) {
        Question199 question = new Question199();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(4);
        System.out.println(Arrays.toString(question.rightSideView(tree).toArray()));
    }
}
