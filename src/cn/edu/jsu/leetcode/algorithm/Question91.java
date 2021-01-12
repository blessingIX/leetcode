package cn.edu.jsu.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:  解码方法
 * @author: blessing
 * @create: 2020-08-14 14:55
 */
public class Question91 {
//    https://leetcode-cn.com/problems/decode-ways/

    public int numDecodingsTimeout(String s) {  // 方法名添加Timeout表示此方法运行超时
//        状态：超出时间限制（计算的结果都正确）
//        https://leetcode-cn.com/submissions/detail/98050123/
//        我的做法相当于层序遍历一颗N叉树，且出第一层外的每层的节点是动态建立的，每层节点个数不确定。
        Queue<String> queue = new LinkedList<>();
        queue.offer(s.substring(0, 1));
        if (queue.peek() != null && queue.peek().equals("0"))
            queue.poll();
        int len = s.length();
        for (int i = 1; i < len; i++) {
            int ql = queue.size();
            while (ql-- > 0) {
                String str = queue.poll();
                if (str.length() > 1) {
                    if (s.charAt(i) != '0')
                        queue.offer("" + s.charAt(i));
                } else {
                    if (s.charAt(i) != '0')
                        queue.offer("" + s.charAt(i));
                    String string = str + s.charAt(i);
                    int num = Integer.parseInt(string);
                    if (num > 0 && num < 27)
                        queue.offer(string);
                }
            }
        }
        return queue.size();
    }

    public int numDecodings(String s) { // 参考（进行了空间复杂度优化）：https://leetcode-cn.com/u/chengm15/
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;   // null 空串 0开头（0不能被解码）
        if (s.length() == 1) return 1;  // 长度为1只有一种解码方式（0已经排除）
        int[] dp = new int[3];  // 优化空间复杂度为O(1)，每次循环只需要当前最优解dp[2]和它的前两个dp[1]、dp[0]
        dp[2] = 1;  // 当前最优解是1（单个不为0的数字字符必定可以进行解码）
        for (int i = 0; i < s.length(); i++) {
            dp[0] = dp[1];  // 每次迭代dp数组元素往前移动一位
            dp[1] = dp[2];
            dp[2] = s.charAt(i) == '0' ? 0 : dp[1]; // 单个数字字符0不能进行解码，所以不能加入排列总数
            if (i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')))
                // 当前数字字符与它的前一个数字字符组合成一个两位数的数字（范围需要再 0 < num <= 26 内能够进行解码）
                dp[2] += dp[0];
        }
        return dp[2];
    }

    public static void main(String[] args) {
        Question91 question = new Question91();
        String[] cases = new String[]{
                "12",
                "226",
                "0",
                "10",
                "0",
                "023",
                "100",
                "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"  // 223 / 258 个通过测试用例 状态：超出时间限制
        };
        for (String aCase : cases) {
            System.out.println(question.numDecodings(aCase));
        }
    }
}
