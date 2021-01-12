package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 生命游戏
 * @author: blessing
 * @create: 2020-05-24 15:26
 */
public class Question289 {
//    https://leetcode-cn.com/problems/game-of-life/
    public void gameOfLife(int[][] board) {
//        死细胞记为0    活细胞记为1
//        通过liveCellCount方法计算细胞周围的活细胞个数（周围的状态值为-2||0||2的细胞为死细胞，周围的状态值为-1||1||3的细胞为活细胞）
//        根据周围活细胞个数改变细胞状态：
//        即将死去的细胞状态值-2（0 -> 0 => -2, 1 -> 0 => -1）
//        即将复活的细胞状态值+2（0 -> 1 => 2, 1 -> 1 => 3）
//        最后状态值>1的细胞状态值改为1，<1的细胞状态值改为0
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCellCount = liveCellCount(board, i, j);
                if (board[i][j] == 0) {
                    if (liveCellCount == 3) board[i][j] += 2;
                } else {
                    if (liveCellCount < 2 || liveCellCount > 3) board[i][j] -= 2;
                    else board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }

    private int liveCellCount(int[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i < x + 2; i++) {
            if (i == -1 || i == board.length) continue;
            for (int j = y - 1; j < y + 2; j++) {
                if (j == -1 || j == board[i].length) continue;
                if (i == x && j == y) continue;
                if (board[i][j] == 1 || board[i][j] == -1 || board[i][j] == 3) count++;
            }
        }
        return count;
    }

    public void gameOfLife1(int[][] board) {
//        没有调用liveCellCount方法
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCellCount = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    if (k == -1 || k == board.length) continue;
                    for (int l = j - 1; l < j + 2; l++) {
                        if (l == -1 || l == board[k].length) continue;
                        if (k == i && l == j) continue;
                        if (board[k][l] == 1 || board[k][l] == -1 || board[k][l] == 3) liveCellCount++;
                    }
                }
                if (board[i][j] == 0) {
                    if (liveCellCount == 3) board[i][j] += 2;
                } else {
                    if (liveCellCount < 2 || liveCellCount > 3) board[i][j] -= 2;
                    else board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }

    public static void main(String[] args){
        Question289 question = new Question289();
        int[][] board = new int[][]{
            new int[]{0,1,0},
            new int[]{0,0,1},
            new int[]{1,1,1},
            new int[]{0,0,0}
        };
        question.gameOfLife1(board);
        Util.ergodicMatrix(board);
    }
}
