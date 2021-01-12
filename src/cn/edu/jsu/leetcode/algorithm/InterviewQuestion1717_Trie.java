package cn.edu.jsu.leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 多次搜索
 * @author: blessing
 * @create: 2020-05-27 21:29
 */
public class InterviewQuestion1717_Trie {
//    https://leetcode-cn.com/problems/multi-search-lcci/

//    LeetCode运行结果：case4超出时间限制
//    https://leetcode-cn.com/submissions/detail/74292829/
    public int[][] multiSearch(String big, String[] smalls) {
//        思路：通过smalls建立Trie树，在遍历主串big时查找smalls
        Trie trie = new Trie();
        Map<String, List<Integer>> map = new HashMap<>();
        for (String small : smalls) {
            trie.insert(small);
            map.put(small, new LinkedList<>());
        }
//        case4超出时间限制的原因估计是主串遍历时间复杂度太高
        for (int i = 0; i < big.length(); i++) {
            for (int j = big.length(); j > i; j--) {
                String str = big.substring(i, j);
                if (trie.search(str)) {
                    System.out.println(str + " : " + i);
                    map.get(str).add(i);
                }
            }
        }
        int [][] result = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> list = map.get(smalls[i]);
            int size = list.size();
            result[i] = new int[size];
            for (int j = 0; j < size; j++) {
                result[i][j] = list.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InterviewQuestion1717_Trie question = new InterviewQuestion1717_Trie();
        String big = "mississippi";
        String[] smalls = new String[]{"is","ppi","hi","sis","i","ssippi"};
        int[][] result = question.multiSearch(big, smalls);
        for (int[] list:result) {
            System.out.println(Arrays.toString(list));
        }
    }
}