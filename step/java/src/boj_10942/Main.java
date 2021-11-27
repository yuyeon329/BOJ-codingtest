package boj_10942;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        dp = new int[N+1][N+1];
        for(int j=1; j<=N; j++){
            dp[0][j] = sc.nextInt();
        }
        palindrome(N);

        int M = sc.nextInt();
        for(int i = 0; i<M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(dp[s][e]).append("\n");
        }
        System.out.println(sb);
    }

    public static void palindrome(int N){
        for(int i=1; i<=N; i++) {
            dp[i][i] = 1;
        }

        for(int i = 1; i<=N-1;i++){
            if(dp[0][i] == dp[0][i+1])
                dp[i][i+1] = 1;
        }

        for(int i=N-1; i>=1; i--){
            for(int j=i+2; j<=N; j++){
                if(dp[0][i] == dp[0][j])
                    dp[i][j] = dp[i+1][j-1];
            }
        }

    }

}
