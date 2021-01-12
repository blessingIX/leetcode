package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 填充每个节点的下一个右侧节点指针 II
 * @author: blessing
 * @create: 2020-08-07 14:25
 */
public class Question117 {
//    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null && root.right != null)    // 左右孩子都不为空，直接左孩子连接右孩子
            root.left.next = root.right;

        Node node = (root.right == null) ? root.left : root.right;  // 右孩子不为空时，选择右孩子为需要寻找next的节点，否则选择左孩子
        if (node != null)   // 排除左孩子为空的情况（右孩子为空情况已经在上一条语句中排除）
            node.next = firstNextNode(root);
        connect(root.right);    // 注意需要先递归遍历右子树，因为后续递归调用firstNextNode方法寻找第一个next节点时是从左往右寻找，若右边不先处理完成可能会遗漏部分节点（扩展：若题目改成next指针由右指向向左则是先遍历左子树）
        connect(root.left);
        return root;
    }

    public Node firstNextNode(Node node) {
        return (node.next == null ? null : ((node.next.left != null) ? node.next.left : (node.next.right != null) ? node.next.right : firstNextNode(node.next)));
//        上述嵌套三元表达式转成if-else语句：
//        if (node.next == null)  // 当前节点的next为空，即当前节点是当前层的最后一个节点，返回null
//            return null;
//        else {  // 当前节点的next不为空，即当前节点不是当前层的最后一个节点
//            if (node.next.left != null) // 当前节点的next有左孩子
//                return node.next.left;
//            else {  // 当前节点的next没有左孩子
//                if (node.next.right != null)    // 当前节点的next有右孩子（前提：没有左孩子）
//                    return node.next.right;
//                else    // 当前节点的next既没有左孩子有没有右孩子
//                    return firstNextNode(node.next);    // 递归寻找第一个有孩子节点的next
//            }
//        }
    }

    public static void main(String[] args) {
        Question117 question = new Question117();
        Node nodes = new Node(1);
        nodes.left = new Node(2);
        nodes.left.left = new Node(4);
//        nodes.left.right = new Node(5);
        nodes.right = new Node(3);
//        nodes.right.left = new Node(6);
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
