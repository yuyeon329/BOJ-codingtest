package boj_11401;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();

        long numerator = fac(N);
        long denominator = fac(K)*fac(N-K)%1000000007;
        System.out.println(numerator*mul(denominator, 1000000005)%1000000007);

    }

    public static long fac(long N){
        long fac = 1L;
        while(N>1){
            fac = (fac * N) % 1000000007;
            N--;
        }
        return fac;
    }

    public static long mul(long N, long K){
        if(K == 1){
            return N%1000000007;
        }
        long tmp = mul(N, K/2);
        if(K%2==1){
            return (tmp*tmp%1000000007)*N%1000000007;
        }
        return tmp*tmp%1000000007;
    }
}
