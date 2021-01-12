package cn.edu.jsu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 拥有最多糖果的孩子
 * @author: blessing
 * @create: 2020-05-23 08:25
 */
public class Question1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//        https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
        List<Boolean> result = new ArrayList<>(candies.length);
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max)
                max = candy;
        }
        for (int candy : candies) {
            if ((candy + extraCandies) >= max)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

    public static void main(String[] args){
        Question1431 question = new Question1431();
        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> result = question.kidsWithCandies(candies, extraCandies);
        for (Boolean r: result) {
            System.out.println(r);
        }
    }
}
