package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 二进制求和
 * @author: blessing
 * @create: 2020-06-23 06:59
 */
public class Question67 {
//    https://leetcode-cn.com/problems/add-binary/
    public String addBinary(String a    , String b) {
        int len = Math.max(a.length(), b.length());
        char c = '0';
        char[] res = new char[len];
        for (int i = 1; i <= len; i++) {
            char addend1 = a.length() - i >= 0 ? a.charAt(a.length() - i) : '0';
            char addend2 = b.length() - i >= 0 ? b.charAt(b.length() - i) : '0';
            char sum = (char) (addend1 + addend2 + c - '0' * 2);
            switch (sum) {
                case '0':
                case '1':
                    res[res.length - i] = sum;
                    c = '0';
                    break;
                case '2':
                    res[res.length - i] = '0';
                    c = '1';
                    break;
                case '3':
                    res[res.length - i] = '1';
                    c = '1';
                    break;
            }
        }
        return c == '1' ? "1" + new String(res) : new String(res);
    }

    public static void main(String[] args) {
        Question67 question = new Question67();
        String[][] cases = {
                {"1010", "1011"},
                {"11", "1"}
        };
        for (String[] aCase : cases) {
            System.out.println(question.addBinary(aCase[0], aCase[1]));
        }
    }
}
