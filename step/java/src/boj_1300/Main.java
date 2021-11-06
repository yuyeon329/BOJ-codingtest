package boj_1300;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int start = 1;
        int end = K;
        int answer = 0;
        while(start<=end){
            int mid = (start+end)/2;

            int cnt = 0;
            for(int i = 1; i<=N; i++){
                cnt += Math.min(mid/i, N);
            }
            if(cnt<K){
                start = mid + 1;
            }
            else{
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
