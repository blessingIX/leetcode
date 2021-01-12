package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 三角形最小路径和
 * @author: blessing
 * @create: 2020-09-15 14:29
 */
public class Question120 {
//    https://leetcode-cn.com/problems/triangle/

    public int minimumTotal(List<List<Integer>> triangle) {
//        自顶向下
//        https://leetcode-cn.com/submissions/detail/108226898/
//        执行用时：8 ms, 在所有 Java 提交中击败了9.52%的用户
//        内存消耗：39.9 MB, 在所有 Java 提交中击败了57.73%的用户
        int n = triangle.size();
        if (n == 0) return 0;
        if (n == 1) return triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                } else if (i == j) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                } else {
                    int num1 = triangle.get(i-1).get(j-1);
                    int num2 = triangle.get(i-1).get(j);
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(num1, num2));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer i : triangle.get(n - 1)) {
            if (i < min)
                min = i;
        }
        return min;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
//        修改自评论第一代码（与自己写的唯一区别：我 -> 自顶向下，ta -> 自底向上）
//        效率与自己写的差不多，ta的跟简洁
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int num1 = triangle.get(i+1).get(j+1);
                int num2 = triangle.get(i+1).get(j);
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(num1, num2));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        Question120 question = new Question120();

        List<List<Integer>> triangle1 = matrixToList(new int[][] {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        });
        System.out.println(question.minimumTotal1(triangle1));

    }

    /**
     * 二维数组转二维List
     * @param matrix
     * @return
     */
    public static List<List<Integer>> matrixToList(int[][] matrix) {
        List<List<Integer>> lss = new ArrayList<>();
        for (int[] ints : matrix) {
            List<Integer> ls = new ArrayList<>();
            for (int i : ints) {
                ls.add(i);
            }
            lss.add(ls);
        }
        return lss;
    }
}
