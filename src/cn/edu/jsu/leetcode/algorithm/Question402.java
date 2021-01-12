package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description:
 * @author: blessing
 * @create: 2020-05-31 13:21
 */
public class Question402 {
//    https://leetcode-cn.com/problems/remove-k-digits/
//    这题足足提交了7次才通过：https://leetcode-cn.com/problems/remove-k-digits/submissions/
//    问题：最开始的想法是用String转char[]再转LinkedList进行删除、Integer删除前导0来解决，
//    其实只要用StringBuilder就能解决，需要加强StringBuilder的练习

    public String removeKdigits(String num, int k) {
//        每次删除剩余字符串递增前缀的最后一个数字字符，循环k次，并且在删除之后需要删除剩余字符串的前导0
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {   // 删除k个字符
            int max = -1;
            int idx = -1;
            for (int j = 0; j < s.length(); j++) {
                int cur = Integer.parseInt(String.valueOf(s.charAt(j)));
                // 获取字符串递增前缀的最后一个数字字符下标
                if (cur > max) {
                    max = cur;
                    idx = j;
                } else if (cur < max) {
                    idx = j - 1;
                    break;
                }
                // 如果未获取到则说明是最后一个
                if (idx == -1) idx = j;
            }
            s.delete(idx, idx + 1); // 删除增前缀的最后一个数字字符
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);    // 循环删除前导0
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Question402 question = new Question402();
        System.out.println(question.removeKdigits("1432219", 2));
        System.out.println(question.removeKdigits("10200", 1));
        System.out.println(question.removeKdigits("10", 2));
        System.out.println(question.removeKdigits("9", 1));
        System.out.println(question.removeKdigits("112", 1));
        System.out.println(question.removeKdigits("1111111", 3));
    }
}
