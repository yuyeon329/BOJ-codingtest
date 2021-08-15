package boj_1110;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int tmp = N;
        int cnt = 0;
        while(true){
            cnt += 1;
            int ten = tmp/10;
            int one = tmp%10;
            int s = ten+one;
            tmp = one*10+s%10;

            if(tmp==N){
                break;
            }
        }
        System.out.println(cnt);
    }
}
