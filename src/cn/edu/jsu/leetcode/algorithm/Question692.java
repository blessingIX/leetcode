package cn.edu.jsu.leetcode.algorithm;

import java.util.*;

/**
 * @description: 692. 前K个高频单词
 * @author: blessing
 * @create: 2021-02-19 20:03
 */
public class Question692 {
//    https://leetcode-cn.com/problems/top-k-frequent-words/
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        PriorityQueue<WordTimes> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String s : map.keySet()) {
            maxHeap.add(new WordTimes(s, map.get(s)));
        }
        List<String> list = new ArrayList<>();
        while (k-- > 0) {
            WordTimes el = maxHeap.poll();
            if (el != null) list.add(el.word);
        }
        return list;
    }

    public static void main(String[] args) {
        Question692 question = new Question692();
        System.out.println(question.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(question.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));

    }
}

class WordTimes implements Comparable<WordTimes> {
    public String word;
    public int times;

    public WordTimes(String word, int times) {
        this.word = word;
        this.times = times;
    }

    @Override
    public int compareTo(WordTimes o) {
        if (this.times == o.times) {
            return -this.word.compareTo(o.word);
        }
        return this.times - o.times;
    }
}