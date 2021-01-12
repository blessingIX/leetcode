package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description:  统计作战单位数
 * @author: blessing
 * @create: 2020-05-23 09:10
 */
public class Question1395 {
//    https://leetcode-cn.com/problems/count-number-of-teams/
    public int numTeams(int[] rating) {
//        先固定中间数rating[j]，再从中间数rating[j]左右两边查找小于（或者大于）中间数rating[j]。
//        将每次查找到的满足的数统计出来，再将左右两边的满足要求的数量相乘，最后每个中间左右两边统计出的数相加。
        int result= 0;
        int ascLeft = 0;
        int ascRight = 0;
        int descLeft = 0;
        int descRight = 0;
        for (int i = 0; i < rating.length; i++) {
            if (i == 0 || i == rating.length - 1) continue;
            ascLeft = ascRight = descLeft = descRight = 0;
            for (int j = i; j >= 0; j--) {
                if (rating[j] < rating[i])
                    ascLeft++;
                if (rating[j] > rating[i])
                    descLeft++;
            }
            for (int j = i; j < rating.length; j++) {
                if (rating[j] > rating[i])
                    ascRight++;
                if (rating[j] < rating[i])
                    descRight++;
            }
            result += (ascLeft * ascRight);
            result += (descLeft * descRight);
        }
        return result;
    }

    public static void main(String[] args){
        Question1395 question = new Question1395();
        int[] rating = new int[]{2,5,3,4,1};
        System.out.println(question.numTeams(rating));
        int[] rating1 = new int[]{2,1,3};
        System.out.println(question.numTeams(rating1));
        int[] rating2 = new int[]{1,2,3,4};
        System.out.println(question.numTeams(rating2));
        int[] rating3 = new int[]{1,3,5,4,7,9};
        System.out.println(question.numTeams(rating3));
    }
}
