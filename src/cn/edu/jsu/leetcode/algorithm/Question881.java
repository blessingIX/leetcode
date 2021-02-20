package cn.edu.jsu.leetcode.algorithm;

import java.util.Arrays;

/**
 * @description: 881. 救生艇
 * @author: blessing
 * @create: 2021-02-20 09:50
 */
public class Question881 {
//    https://leetcode-cn.com/problems/boats-to-save-people/
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        int len = people.length;
        Arrays.sort(people);
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int total = people[i] + people[j];
            if (total <= limit) {
                ans++;
                i++;
                j--;
            } else {
                ans++;
                j--;
            }
        }
        if (i == j) ans++;
        return ans;
    }

    public static void main(String[] args) {
        Question881 question = new Question881();
        System.out.println(question.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
