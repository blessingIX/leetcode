package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 20. 表示数值的字符串
 * @author: blessing
 * @create: 2021-01-09 14:27
 */
public class CodingInterviews20 {   // 该题测试用例太恶心
    public static final int START = 0;  // 开始状态
    public static final int DF = 1;     // 底数符号
    public static final int DZ = 2;     // 底数整数
    public static final int D = 3;      // 小数点
    public static final int DX = 4;     // 底数小数
    public static final int E = 5;      // e/E
    public static final int ZF = 6;     // 指数符号
    public static final int ZZ = 7;     // 指数整数
    public static final int END = 8;    // 结束状态

    public static final int[][] TABLE = new int[][]{
            // signed, number, dot, e/E, other
            {DF, DZ, D, END, END}, // START
            {END, DZ, D, END, END},// DF
            {END, DZ, D, E, END},   // DZ
            {END, DX, END, END, END},// D
            {END, DX, END, E, END}, // DX
            {ZF, ZZ, END, END, END},// E
            {END, ZZ, END, END, END},// ZF
            {END, ZZ, END, END, END},// ZZ
            {END, END, END, END, END}// END
    };

    public boolean isNumber(String s) {
        s = s.trim();
        int status = START;
        char[] strArr = s.toCharArray();

        for (char c : strArr) {
            switch (status) {
                case START:
                    status = TABLE[0][getCol(c)];
                    break;
                case DF:
                    status = TABLE[1][getCol(c)];
                    break;
                case DZ:
                    status = TABLE[2][getCol(c)];
                    break;
                case D:
                    status = TABLE[3][getCol(c)];
                    break;
                case DX:
                    status = TABLE[4][getCol(c)];
                    break;
                case E:
                    status = TABLE[5][getCol(c)];
                    break;
                case ZF:
                    status = TABLE[6][getCol(c)];
                    break;
                case ZZ:
                    status = TABLE[7][getCol(c)];
                    break;
                case END:
                    status = TABLE[8][getCol(c)];
                    break;
            }
        }
        if (s.equals(".")) return false;
        return status == DZ || status == DX || status == ZZ || status == D;
    }

    private int getCol(char c) {
        if (c == '+' || c == '-') {
            return 0;
        } else if (c >= '0' && c <= '9') {
            return 1;
        } else if (c == '.') {
            return 2;
        } else if (c == 'e' || c == 'E'){
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        CodingInterviews20 question = new CodingInterviews20();
        String[] cases = {
                "+100",
                "5e2",
                "-123",
                "3.1416",
                "-1E-16",
                "0123",
                "12e",
                "1a3.14",
                "1.2.3",
                "+-5",
                "12e+5.4"
        };
        for (int i = 0; i < cases.length; i++) {
            System.out.println(cases[i] + ": " + question.isNumber(cases[i]));
        }

        System.out.println("===error case===");
        String[] errorCase = {
                "1 ",
                "3.",
                "0",
                ".1",
                ".",
                " .",
                "1 4",
                "+.8",
                "-."    // false
        };
        for (String aCase : errorCase) {
            System.out.println(aCase + ": " + question.isNumber(aCase));
        }
    }
}
