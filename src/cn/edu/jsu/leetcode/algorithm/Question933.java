package cn.edu.jsu.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 933. 最近的请求次数
 * @author: 易子建
 * @create: 2021-01-13 15:54
 */
public class Question933 {
//    https://leetcode-cn.com/problems/number-of-recent-calls/
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int num = t - 3000;
        while (!queue.isEmpty()) {
            if (queue.peek() >= num) break;
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
