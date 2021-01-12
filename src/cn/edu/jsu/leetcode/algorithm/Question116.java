package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 填充每个节点的下一个右侧节点指针
 * @author: blessing
 * @create: 2020-08-06 21:08
 */
public class Question116 {
//    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    public void helper(Node root) {
        if (root == null) return;
        if (root.left != null) {    // 由于题目给的是完全二叉树，所以只要有左孩子，就一定有右孩子，直接连接左右孩子。
            root.left.next = root.right;
            if (root.next != null)  // 若当前节点next指针不为空（且有左右孩子，上一层判断已经判断出），则当前节点右孩子与其亲兄弟节点左孩子需要连接
                root.right.next = root.next.left;
        }
        helper(root.left);  // 递归遍历整棵二叉树
        helper(root.right);
    }

    public static void main(String[] args) {
        Question116 question = new Question116();
        Node nodes = new Node(1);
        nodes.left = new Node(2);
        nodes.left.left = new Node(4);
        nodes.left.right = new Node(5);
        nodes.right = new Node(3);
        nodes.right.left = new Node(6);
        nodes.right.right = new Node(7);
        nodes = question.connect(nodes);
        test(nodes);
    }

    public static void test(Node root) {
        Node p = root;
        while (p != null) {
            Node q = p;
            while (q != null) {
                System.out.print(q.val + ",");
                q = q.next;
            }
            System.out.println();
            p = p.left;
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}