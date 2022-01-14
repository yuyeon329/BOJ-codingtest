package boj_12852;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] path;
    public static int[] dp;
    public static int mv = 10000000;
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        path = new int[N+1]; //역 추적 용. bottom up. 1에서 출발하므로..
        // ex)2,3의 경우 2%2==0, 3%3==0이라서 한번만 연산해도 1이 나오므로 path[2],path[3] = 1임. 나중에 연산을 통해 2나 3이 나오는 정수는 path[n] = path[2]+1 or path[3]+1
        dp = new int[N+1]; //step 수 저장. 현재 시도하는 연산을 통한 step이 더 짧은 경로일 경우 갱신
        Arrays.fill(dp,mv);
        dp[1] = 0;
        for(int i = 2; i<=N; i++){
            if(i%3 == 0){
                if(dp[i/3]+1<dp[i]){//3으로 나누는 연산 실행 i -> i/3의 루트를 밟을 거니깐 dp[i] = dp[i/3]+1 ex) dp[6] = dp[2]+1
                    dp[i] = dp[i/3]+1; //i -> i/3의 루트
                    path[i] = i/3; //역추적 history 남기기
//                    System.out.println(i);
//                    System.out.println(Arrays.toString(dp));
//                    System.out.println(Arrays.toString(path));
//                    System.out.println();
                }

            }

            if(i%2 == 0){
                if(dp[i/2]+1<dp[i]){
                    dp[i] = dp[i/2]+1;
                    path[i] = i/2;
//                    System.out.println(i);
//                    System.out.println(Arrays.toString(dp));
//                    System.out.println(Arrays.toString(path));
//                    System.out.println();
                }
            }

            if(dp[i-1]+1<dp[i]){
                dp[i] = dp[i-1]+1;
                path[i] = i-1;
//                System.out.println(i);
//                System.out.println(Arrays.toString(dp));
//                System.out.println(Arrays.toString(path));
//                System.out.println();
            }
        }

        sb.append(dp[N]+"\n");

        while(N>0){
           sb.append(N+" ");
           N = path[N];
        }
        System.out.println(sb);
    }
}
