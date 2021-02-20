package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 74. 搜索二维矩阵
 * @author: blessing
 * @create: 2021-02-20 12:39
 */
public class Question74 {
//    https://leetcode-cn.com/problems/search-a-2d-matrix/
//    二分查找法的嵌套
//    外层的二分查找法：boolean searchMatrix(int[][] matrix, int target) 查找是否存在有target的行（将搜索范围由矩阵缩小至行）
//    内层的二分查找法：boolean search(int[] nums, int target) 在行中查找target是否存在

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int l = 0;
        int r = matrix.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return search(matrix[mid], target);
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return search(matrix[l], target);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == target) return true;
            else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l] == target;
    }

//    TODO: 二分查找法的另一种思路，由于矩阵已排好序的条件，按行遍历矩阵能得到一个有序的数组。我们可以写一个二位坐标(x,y)转化为一维坐标(i)的方法，将问题转化为常规的二分查找进行求解。

//    TODO：另一种思路（已在另一题中写过了）：从矩阵右上角往左下角看，可以看做一颗二叉搜索树，按照二叉搜索树的算法可以进行求解。
}
