package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 旋转矩阵
 * @author: blessing
 * @create: 2020-05-24 10:27
 */
public class InterviewQuestion0107 {
//    https://leetcode-cn.com/problems/rotate-matrix-lcci/
    public void rotate(int[][] matrix) {
//        先将矩阵左右翻转，再将矩阵按照左下至右上的对称轴翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
        int increment = matrix.length - 1;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < increment; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i + increment - j][j + increment - j];
                matrix[i + increment - j][j + increment - j] = temp;
            }
            increment--;
        }
    }

    public void rotate2(int[][] matrix) {
//        或者先将矩阵上下翻转，再将矩阵按照左上至右下的对称轴翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args){
        InterviewQuestion0107 question = new InterviewQuestion0107();
        int[][] matrix1 = new int[][] {
            new int[]{1,2,3},
            new int[]{4,5,6},
            new int[]{7,8,9}
        };
        System.out.println("旋转前：");
        Util.ergodicMatrix(matrix1);
        question.rotate2(matrix1);
        System.out.println("旋转后：");
        Util.ergodicMatrix(matrix1);
        int[][] matrix2 = new int[][] {
                new int[]{5, 1, 9,11},
                new int[]{2, 4, 8,10},
                new int[]{13, 3, 6, 7},
                new int[]{15,14,12,16}
        };
        System.out.println("旋转前：");
        Util.ergodicMatrix(matrix2);
        question.rotate2(matrix2);
        System.out.println("旋转后：");
        Util.ergodicMatrix(matrix2);
    }
}
