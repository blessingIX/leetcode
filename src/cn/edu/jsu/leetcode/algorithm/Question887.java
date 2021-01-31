package cn.edu.jsu.leetcode.algorithm;

/**
 * @description: 887. 鸡蛋掉落
 * @author: blessing
 * @create: 2021-01-20 10:04
 */
public class Question887 {
//    https://leetcode-cn.com/problems/super-egg-drop/

    public int superEggDrop(int K, int N) {
        return 0;
    }

    public int superEggDropTimeout(int K, int N) {
        // K为剩余的鸡蛋数，N需要试验的楼层数
        int[][] dp = new int[K + 1][N + 1];
        for (int eggs = 1; eggs < K + 1; eggs++) {
            // 共1层楼需要试验，不管多少个鸡蛋都只需要扔一次
            dp[eggs][1] = 1;
        }
        for (int floor = 1; floor < N + 1; floor++) {
            // 若剩余1个鸡蛋，有多少层楼就需要扔多少次（因为只有一次机会，只能从1楼逐层往上扔，若从高层开始扔鸡蛋碎了就没有机会了）
            dp[1][floor] = floor;
        }
        for (int floor = 2; floor < N + 1; floor++) {
            for (int eggs = 2; eggs < K + 1; eggs++) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k <= floor; k++) {
                    // dp[eggs][floor - k] 若鸡蛋在k层楼试验没碎，剩余鸡蛋数不变（还是eggs），证明k层往下的楼层不需要试验，剩余需要试验的楼层数为floor - k
                    // dp[eggs - 1][k - 1] 若鸡蛋在k层楼试验碎了，剩余鸡蛋数减一（即eggs-1），证明k层往上的楼层不需要试验，剩余需要试验的楼层数为k - 1
                    // 取两者较大值来保证在k层楼，不管试验后碎还是不碎都能找到临界楼层
                    // 最后需要加一，因为在k层扔了一次，不管鸡蛋碎还是不碎，在k层楼都是扔了的，所以需要计算在内
                    // 最后取1~floor层楼中，找到剩余eggs个鸡蛋时的最优解
                    min = Math.min(min, Math.max(dp[eggs][floor - k], dp[eggs - 1][k - 1]) + 1);
                }
                dp[eggs][floor] = min;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        Question887 question = new Question887();
        int[][] cases = new int[][]{
                {1,2},
                {2,6},
                {3,14}
        };

        for (int[] aCase : cases) {
            System.out.printf("k = %d, N = %d, R = %d\n", aCase[0], aCase[1], question.superEggDropTimeout(aCase[0], aCase[1]));
        }

        System.out.println(question.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(question.isPalindrome("              "));
        System.out.println(question.isPalindrome(""));
        System.out.println(question.isPalindrome("@]=,//0-="));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if ("".equals(s)) return true;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            while (l < chars.length && !((chars[l] >= 'a' && chars[l] <= 'z') || (chars[l] >= 'A' && chars[l] <= 'Z') || (chars[l] >= '0' && chars[l] <= '9'))) l++;
            while (r >= 0 && !((chars[r] >= 'a' && chars[r] <= 'z') || (chars[r] >= 'A' && chars[r] <= 'Z') || (chars[r] >= '0' && chars[r] <= '9'))) r--;
            if (l >= r) break;
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
