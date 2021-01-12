package cn.edu.jsu.leetcode.algorithm.narytree;

import java.util.List;

/**
 * @program: LeetCode
 * @description: N叉树节点
 * @author: blessing
 * @create: 2020-08-10 14:22
 */
public class Node {
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
}
