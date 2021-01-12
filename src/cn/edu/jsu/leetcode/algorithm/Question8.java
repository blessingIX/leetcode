package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 字符串转换整数 (atoi)
 * @author: blessing
 * @create: 2020-04-04 20:10
 */
public class Question8 {
    public int myAtoi(String str) {
        String[][] table = {
                {"start", "signed", "inNumber", "end"},
                {"end", "end", "inNumber", "end"},
                {"end", "end", "inNumber", "end"},
                {"end", "end", "end", "end"}
        };
        StringBuilder ans = new StringBuilder();
        String status = "start";
        char[] strArr = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            switch (status) {
                case "start":
                    status = table[0][getCol(strArr[i])];
                    break;
                case "signed":
                    status = table[1][getCol(strArr[i])];
                    break;
                case "inNumber":
                    status = table[2][getCol(strArr[i])];
                    break;
                case "end":
                    status = table[3][getCol(strArr[i])];
                    break;
            }
            if (status.equals("inNumber") || status.equals("signed")) {
                ans.append(strArr[i]);
            }
        }
        if (ans.toString().equals("") || ans.toString().equals("+") || ans.toString().equals("-")) {
            return 0;
        }
        try {
            return Integer.parseInt(ans.toString());
        } catch (NumberFormatException e) {
            return strArr[0] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    private int getCol(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (c >= '0' && c <= '9') {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args){
        Question8 question8 = new Question8();
        System.out.println(question8.myAtoi("mynameis"));
        System.out.println(question8.myAtoi("42"));
        System.out.println(question8.myAtoi("     -42"));
        System.out.println(question8.myAtoi("4193 with words"));
        System.out.println(question8.myAtoi("words and 987"));
        System.out.println(question8.myAtoi("-91283472332"));
        System.out.println(question8.myAtoi("20000000000000000000"));
        System.out.println(question8.myAtoi("      -11919730356x"));

//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
    }
}
