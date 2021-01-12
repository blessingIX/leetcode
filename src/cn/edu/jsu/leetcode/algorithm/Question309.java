package cn.edu.jsu.leetcode.algorithm;

/**
 * @program: LeetCode
 * @description: 最佳买卖股票时机含冷冻期
 * @author: blessing
 * @create: 2020-09-17 10:38
 */
public class Question309 {
//    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//    每天可以进行【买入】、【卖出】、【冻结】、【什么也不做】中的一种操作，且【卖出】后必须【冻结】一天。
//    【冻结】与【什么也不做】类似，【冻结】存在于【卖出】于【买入】之间，而【什么也不做】存在于第一次【买入】之前或【买入】与【卖出】之间。
//    buy -> 买入、sell -> 卖出、freeze -> 冻结、noop -> 什么也不做
//    例：[noop, noop, ..., ]buy, [noop, noop, ...,]sell, freeze, [freeze, ...,]buy,...
//    状态转化如下：
//      noop            noop             freeze
//          \               \                  \
//           》--> buy        》--> sell         》--> freeze
//          /               /                  /
//    freeze             buy               sell

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] freeze = new int[n];
        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], freeze[i - 1] - prices[i]);   // 对应上面第一个状态转化图。
//            buy[i] = buy[i - 1] => noop -> buy    buy[i] = freeze[i - 1] - prices[i] => freeze -> buy
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);    // 对应上面第二个状态转化图。
//            sell[i] = sell[i - 1] => noop -> sell     sell[i] = buy[i - 1] + prices[i] => buy -> sell
            freeze[i] = sell[i - 1];    // 对应上面第三个状态转化图。
//            freeze状态必定在sell之后，且freeze相当于noop，所以无论冻结期延长多长，它的值都是上一个sell值
        }
        return Math.max(sell[n - 1], freeze[n - 1]);    // 不需要将 buy 加入比较，因为 buy 是花钱还不如 noop
    }

    public static void main(String[] args) {
        Question309 question = new Question309();

        int[][] cases = new int[][]{
                {1,2,3,0,2}
        };
        for (int[] aCase : cases) {
            System.out.println(question.maxProfit(aCase));
        }
    }
}
