package cn.edu.jsu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            System.out.println(soda(i));
        }
        sc.close();
    }

    public static int soda(int empty) {
        int result = 0;
        do {
            result += empty / 3;
            empty = empty / 3 + empty % 3;
        } while(empty > 2);
        return empty == 2 ? result + 1 : result;
    }
}
