package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 最大正方形
 * @author: blessing
 * @create: 2020-09-16 14:09
 */
public class Question221 {
//    https://leetcode-cn.com/problems/maximal-square/

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                while (isSquare(matrix, i, j, max +  1)) {
                    max++;
                }
            }
        }
        return max * max;
    }

    public boolean isSquare(char[][] matrix, int x, int y, int level) {
        for (int i = x, j = y; i < x + level && j < y + level; i++, j++) {
            if (i >= matrix.length || j >= matrix[i].length || matrix[i][j] == '0')
                return false;
        }
        for (int i = x; i < x + level; i++) {
            for (int j = y; j < y + level; j++) {
                if (matrix[i][j] == '0')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question221 question = new Question221();

        char[][][] cases = new char[][][]{
                {
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                },
                {
                        {'1', '0', '1', '0', '0', '1', '1', '1', '1', '1'},
                        {'1', '0', '1', '1', '1', '1', '0', '0', '1', '0'},
                        {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                        {'1', '0', '1', '0', '0', '1', '0', '1', '1', '1'},
                        {'1', '0', '1', '1', '1', '1', '0', '1', '0', '0'},
                        {'1', '1', '1', '1', '1', '1', '0', '1', '0', '0'},
                        {'1', '0', '0', '1', '0', '1', '0', '1', '1', '1'}
                },
                {
                        {'1', '1'},
                        {'1', '1'}
                }
        };

        for (char[][] aCase : cases) {
            System.out.println(question.maximalSquare(aCase));
        }
    }
}
