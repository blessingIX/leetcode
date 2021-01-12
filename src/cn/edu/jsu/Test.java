package cn.edu.jsu;


import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetCode
 * @description:
 * @author: blessing
 * @create: 2020-04-04 21:15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("=====leet code test=====");
        Test test = new Test();
        test.test2(10, 10);
    }

    public void test1() {
        System.out.println(0 & 1);
        System.out.println(1 & 1);
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 1);
    }

    public void test2(int n) throws InterruptedException {
        Random random = new Random();
        int[] ls = new int[n];
        for (int i = 0; i < ls.length; i++) {
            ls[i] = random.nextInt(100);
            Thread.sleep(500);
        }
        Arrays.sort(ls);
        for (int l : ls) {
            System.out.print(l + " ");
        }
    }

    public void test2(int n, int bound) {
        Random random = new Random();
        int[] ls = new int[n];
        for (int i = 0; i < ls.length; i++) {
            ls[i] = random.nextInt(bound);
        }
        Arrays.sort(ls);
        for (int l : ls) {
            System.out.print(l + " ");
        }
    }
}
