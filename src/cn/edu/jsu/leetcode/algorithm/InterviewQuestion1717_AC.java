package cn.edu.jsu.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 多次搜索
 * @author: blessing
 * @create: 2020-05-28 09:03
 */
public class InterviewQuestion1717_AC {
//    https://leetcode-cn.com/problems/multi-search-lcci/

    public int[][] multiSearch(String big, String[] smalls) {
//        TODO: 使用AC自动机完成多次搜索
        return null;
    }

    public static void main(String[] args) {

    }
}

class AC {
    private ACNode root;

    public AC() {
        this.root = new ACNode('/');
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        ACNode p = root;
        for (char aChar : chars) {
            if (p.children[aChar - 'a'] == null) {
                p.children[aChar - 'a'] = new ACNode(aChar);
            }
            p = p.children[aChar - 'a'];
        }
        p.isEndingChar = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        ACNode p = root;
        for (char aChar : chars) {
            if (p.children[aChar - 'a'] == null) {
                return false;
            }
            p = p.children[aChar - 'a'];
        }
        return p.isEndingChar;
    }

    public void buildFailurePointer() {
//      TODO: AC自动机构建fail指针

    }

    static class ACNode {
        char data;
        ACNode[] children = new ACNode[26];
        boolean isEndingChar = false;
        ACNode fail;

        public ACNode(char data) {
            this.data = data;
        }
    }
}