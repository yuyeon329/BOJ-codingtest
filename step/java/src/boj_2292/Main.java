package boj_2292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 1;
        int cnt = 1;
        while(N>i) {
            i += (cnt*6);
            cnt += 1;
        }
            System.out.println(cnt);
    }
}
