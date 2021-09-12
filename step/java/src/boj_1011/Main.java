package boj_1011;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T;i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();
            long d = y - x;
            long move = 0, cnt = 0, set_of_cnt = 1;

            while (move < d) {
                cnt += 1;
                move += set_of_cnt;
                if (cnt % 2 == 0) {
                    set_of_cnt += 1;
                }
            }
            System.out.println(cnt);
        }
    }
}