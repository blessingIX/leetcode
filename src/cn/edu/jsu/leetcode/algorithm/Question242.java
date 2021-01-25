package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 242. 有效的字母异位词
 * @author: blessing
 * @create: 2021-01-25 19:35
 */
public class Question242 {
//    https://leetcode-cn.com/problems/valid-anagram/

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        int len = s.length();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < len; i++) {
            sArr[sChars[i] - 'a']++;
            tArr[tChars[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question242 question = new Question242();
        String[][] cases = new String[][]{
                {"anagram", "nagaram"},
                {"rat", "car"},
                {"aa", "bb"}
        };
        for (String[] aCase : cases) {
            System.out.println(question.isAnagram(aCase[0], aCase[1]));
        }
    }
}
