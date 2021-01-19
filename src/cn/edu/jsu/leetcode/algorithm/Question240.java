package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 240. 搜索二维矩阵 II
 * @author: blessing
 * @create: 2021-01-18 20:43
 */
public class Question240 {
//    https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
//    与 剑指 Offer 04. 二维数组中的查找 同题
//    https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

    public boolean searchMatrixError(int[][] matrix, int target) {
//      错误的做法！！！
//        FIXME: 二分查找行不通（例如：[[1,4],[2,5]] 2）
        int i = 0;
        int j = 0;
        int mLen = matrix.length;
        int nLen = matrix[0].length;
        int m = mLen - 1;
        int n = nLen - 1;
        while (i < m || j < n) {
            int iMid = i;
            int jMid = j;
            if (i < m) iMid = i + (m - i >> 1);
            if (j < n) jMid = j + (n - j >> 1);
            if (target < matrix[iMid][jMid]) {
                if (i < m) m = iMid - 1;
                if (j < n) n = jMid - 1;
            } else if (target > matrix[iMid][jMid]) {
                if (i < m) i = iMid + 1;
                if (j < n) j = jMid + 1;
            } else {
                return true;
            }
        }
        return matrix[i][j] == target;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        return search(matrix, target, 0, matrix[0].length - 1);
    }

//    从matrix[0][matrix[0].length - 1]（即右上角）忘左下角方向看，可以看作是一颗二叉搜索树
//    按照二叉搜索树的搜索规则进行搜索
    public boolean search(int[][] matrix, int target, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return false;
        if (target == matrix[i][j]) return true;
        else if (target < matrix[i][j])
            return search(matrix, target, i, j - 1);
        else
            return search(matrix, target, i + 1, j);
    }

    public static void main(String[] args) {
        Question240 question = new Question240();
        int[][][] cases = new int[][][]{
                {
                        {1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}

                },
                {
                        {1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}
                },
                {
                        {1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}
                },
                {
                        {-1,3}
                },
                {
                        {1,3,5}
                },
                {
                        {1,4},
                        {2,5}
                }
        };
        int[] targets = new int[]{
                5,
                20,
                0,
                3,
                1,
                2
        };

        for (int i = 0; i < cases.length; i++) {
            System.out.println(question.searchMatrix(cases[i], targets[i]));
        }
    }
}
