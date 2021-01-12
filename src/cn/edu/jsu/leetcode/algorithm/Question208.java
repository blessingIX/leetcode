package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 实现 Trie (前缀树)
 * @author: blessing
 * @create: 2020-05-27 20:31
 */
public class Question208 {
//    https://leetcode-cn.com/problems/implement-trie-prefix-tree/
    public static void main(String[] args) {
        example();
        case6();
    }

    public static void example() {
        System.out.println("===== example =====");
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // 返回 true
        System.out.println(trie.search("app"));    // 返回 false
        System.out.println(trie.startsWith("app"));     // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 true
    }

    public static void case6() {
//        https://leetcode-cn.com/submissions/detail/74204263/
//        错误原因：将 public boolean startsWith(String prefix) 方法的最后一行 return true; 写成了 return !p.isEndingChar;
//        其实是我想多了，例如 trie.insert("apple"); trie.startsWith("apple");
//        我认为apple的startsWith应该是[a, ap, app, appl]而不包含apple导致错误
        System.out.println("===== case6 =====");
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode p = root;
        for (char aChar : chars) {
            if (p.children[aChar - 'a'] == null) {
                p.children[aChar - 'a'] = new TrieNode(aChar);
            }
            p = p.children[aChar - 'a'];
        }
        p.isEndingChar = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode p = root;
        for (char aChar : chars) {
            if (p.children[aChar - 'a'] == null) {
                return false;
            }
            p = p.children[aChar - 'a'];
        }
        return p.isEndingChar;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode p = root;
        for (char aChar : chars) {
            if (p.children[aChar - 'a'] == null) {
                return false;
            }
            p = p.children[aChar - 'a'];
        }
        return true;
    }

    static class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */