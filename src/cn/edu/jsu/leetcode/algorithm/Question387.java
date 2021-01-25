package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 387. 字符串中的第一个唯一字符
 * @author: blessing
 * @create: 2021-01-25 19:53
 */
public class Question387 {
//    https://leetcode-cn.com/problems/first-unique-character-in-a-string/

    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) return -1;
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map[chars[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Question387 question = new Question387();
        String[] cases = new String[]{
                "leetcode",
                "loveleetcode"
        };
        for (String aCase : cases) {
            System.out.println(question.firstUniqChar(aCase));
        }
    }
}
