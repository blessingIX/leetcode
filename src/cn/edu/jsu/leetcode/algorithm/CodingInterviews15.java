package cn.edu.jsu.leetcode.algorithm;

/**
 * @description:
 * @author: 易子建
 * @create: 2021-01-12 13:39
 */
public class CodingInterviews15 {
//    https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/

    // Integer.toBinaryString
    public int hammingWeight(int n) {
        int count = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    // Integer.bitCount
    public int hammingWeightBitCount(int n) {
        return Integer.bitCount(n);
    }

//    提交记录０ms执行范例
    // 巧用 n & (n-1) ，例如　11 & 10 = 10 （10相较于11，1减少了1位)  10 & 01 = 00 (01相较于10，0与1换位，＆操作之后的结果1个数减少)
    public int hammingWeightNAndNSub1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CodingInterviews15 codingInterviews = new CodingInterviews15();
        int[] cases = new int[]{
                0b00000000000000000000000000001011,
                0b00000000000000000000000010000000,
                0b11111111111111111111111111111101
        };
        for (int aCase : cases) {
            System.out.println(aCase + " => " + codingInterviews.hammingWeightNAndNSub1(aCase));
        }
    }
}
