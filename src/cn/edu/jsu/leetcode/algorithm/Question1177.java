package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 构建回文串检测
 * @author: blessing
 * @create: 2020-06-02 19:56
 */
public class Question1177 {
//    https://leetcode-cn.com/problems/can-make-palindrome-from-substring/
//    case29：超出时间限制 https://leetcode-cn.com/submissions/detail/75769654/
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
//        思路：因为可以重新排列，所以只要统计每个s的子串中出现次数为奇数的字母的数量，然后再除以2之后是否比给定的可替换字符数小或相等
        List<Boolean> res = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            char[] chars = s.substring(query[0], query[1] + 1).toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : chars) {
                map.merge(c, 1, Integer::sum);
            }
            int odd = 0;
            for (Character character : map.keySet()) {
                if (map.get(character) % 2 == 1) odd++;
            }
            res.add(odd / 2 <= query[2]);
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
//        由于自己写的超出leetcode时间限制，直接找了评论区思路一样的代码提交了,但是也超时。。。。。。
        List<Boolean> res = new ArrayList<>(queries.length);
        for(int[] query : queries){
            int[] chars = new int[26];
            for(int i = query[0]; i <= query[1]; i++){
                chars[s.charAt(i) - 'a']++;
            }
            int odd = 0;
            for(int i = 0; i < 26; i++){
                if((chars[i] & 1) != 0) odd++;
            }
            res.add(odd / 2 <= query[2]);
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
//        再canMakePaliQueries1的基础上进行优化，对字符串s进行预处理
//        利用前缀各个字符出现次数的和，先建立一个规模为 s.length() * 26 二维数组，每一行存储s.charAt(0)到s.charAt(i)之间各个字母出现的次数

//        终于通过了 https://leetcode-cn.com/submissions/detail/75785708/
        List<Boolean> res = new ArrayList<>(queries.length);
        int[][] chars = new int[s.length()][26];
        for(int i = 0; i < s.length(); i++){
            for (int j = 0; j < 26; j++) {
                chars[i][j] = i == 0 ? 0 : chars[i - 1][j];
                if (s.charAt(i) == (char) (97 + j)) chars[i][j] += 1;
            }
        }
        for(int[] query : queries){
            int odd = 0;
            int[] chs = new int[26];
            for (int i = 0; i < 26; i++) {
                chs[i] = query[0] == 0 ? chars[query[1]][i] : chars[query[1]][i] - chars[query[0] - 1][i];
            }
            for (int i = 0; i < 26; i++) {
                if ((chs[i] & 1) != 0) odd++;
            }
            res.add(odd / 2 <= query[2]);
        }
        return res;
    }

    public static void main(String[] args) {
        Question1177 question = new Question1177();
//        s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
        String s = "abcda";
        int[][] queries = new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        List<Boolean> res = question.canMakePaliQueries2(s, queries);
        for (Boolean re : res) {
            System.out.println(re);
        }
    }
}
