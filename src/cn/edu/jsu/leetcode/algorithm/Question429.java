package cn.edu.jsu.leetcode.algorithm;

import java.util.*;

import cn.edu.jsu.leetcode.algorithm.narytree.Node;

/**
 * @program: LeetCode
 * @description: N叉树的层序遍历
 * @author: blessing
 * @create: 2020-08-10 14:24
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class Question429 {
//    https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root != null)
            deque.addLast(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                Node node = deque.removeFirst();
                list.add(node.val);
                if (node.children != null)
                    for (Node child : node.children) {
                        deque.addLast(child);
                    }
            }
            lists.add(list);
        }
        return lists;
    }

//    提交记录0ms执行范例（start）递归法
    List<List<Integer>> lists;
    public List<List<Integer>> levelOrder0ms(Node root) {
        lists = new ArrayList<>();
        if (root != null)
            dfs(root, 0);
        return lists;
    }

    public void dfs(Node root, int level) {
        while (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        if (root.children != null)
            for (Node child : root.children) {
                dfs(child, level+1);
            }
    }
//    提交记录0ms执行范例（end）

    public static void main(String[] args) {
        Question429 question = new Question429();
        List<Node> level0 = new ArrayList<>();
        List<Node> level1 = new ArrayList<>();
        List<Node> level2 = new ArrayList<>();
        level2.add(new Node(5));
        level2.add(new Node(6));

        level1.add(new Node(3));
        level1.add(new Node(2));
        level1.add(new Node(4));
        level1.get(0).children = level2;

        level0.add(new Node(1));
        level0.get(0).children = level1;

        List<List<Integer>> lists = question.levelOrder0ms(level0.get(0));
        System.out.println("[");
        for (List<Integer> list : lists) {
            System.out.println("\t" + Arrays.toString(list.toArray()));
        }
        System.out.println("]");
    }
}
