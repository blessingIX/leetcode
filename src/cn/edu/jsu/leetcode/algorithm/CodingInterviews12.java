package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 剑指 Offer 12. 矩阵中的路径
 * @author: 易子建
 * @create: 2021-01-11 11:02
 */
public class CodingInterviews12 {
//    https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

    // 思路基本一致，为什么我的超时？
//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0) return false;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (recall(board, word, new boolean[board.length][board[0].length], i, j, 0)) return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean recall(char[][] board, String word, boolean[][] mark, int i, int j, int k) {
//        if (k == word.length()) {
//            return true;
//        }
//        if (i < 0 || j < 0 || i == board.length || j == board[0].length || mark[i][j] || board[i][j] != word.charAt(k)) {
//            return false;
//        }
//
//        mark[i][j] = true;
//        boolean res = false;
//        res |= recall(board, word, mark, i - 1, j, k + 1);
//        res |= recall(board, word, mark, i, j + 1, k + 1);
//        res |= recall(board, word, mark, i + 1, j, k + 1);
//        res |= recall(board, word, mark, i, j - 1, k + 1);
//        mark[i][j] = false;
//        return res;
//    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    if (recall(board, i, j, mark, chars, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean recall(char[][] board, int i, int j, boolean[][] mark, char[] chars, int index) {
        if (index == chars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || mark[i][j] || board[i][j] != chars[index]) {
            return false;
        }
        mark[i][j] = true;
        boolean res = recall(board, i + 1, j, mark, chars, index + 1)
                || recall(board, i - 1, j, mark, chars, index + 1)
                || recall(board, i, j + 1, mark, chars, index + 1)
                || recall(board, i, j - 1, mark, chars, index + 1);
        mark[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        CodingInterviews12 codingInterviews = new CodingInterviews12();
        char[][][] cases = new char[][][]{
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                },
                {
                        {'a', 'b'},
                        {'c', 'd'}
                },
                {
                        {'a'}
                },
                {
                        {'a', 'b'}
                },
                {
                        {'a', 'b'}
                },
                {
                        {'a', 'b'},
                        {'c', 'd'}
                }
        };

        String[] words = {
                "ABCCED", "abcd", "a", "ab", "ba", "acdb"
        };

        for (int i = 0; i < cases.length; i++) {
            System.out.println(codingInterviews.exist(cases[i], words[i]));
        } 
    }
}
