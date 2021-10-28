package boj_1629;

import java.util.Scanner;

public class Main {
    public static long C;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(mul(A, B));
    }

    public static long mul(long A, long B){
        if(B == 1){
            return A % C;
        }
        long tmp = mul(A, B/2);
        if(B % 2 == 1){
            return (tmp*tmp%C) * A % C;
        }
        return tmp*tmp % C;
    }

}
