package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 05. 替换空格
 * @author: 易子建
 * @create: 2021-01-10 23:01
 */
public class CodingInterviews5 {
//    https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/

    // 3ms
//    public String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
//    }

    // 1ms
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.append(c == ' ' ? "%20" : c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CodingInterviews5 codingInterviews = new CodingInterviews5();
        String[] cases = new String[]{
                "We are happy."
        };

        for (String aCase : cases) {
            System.out.println(aCase + " ==> " + codingInterviews.replaceSpace(aCase));
        }
    }
}
