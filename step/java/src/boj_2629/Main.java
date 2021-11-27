package boj_2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//다시풀기
public class Main {
    static int numOfweight;
    static int arr[];
    static boolean dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        numOfweight = Integer.parseInt(br.readLine());
        arr = new int[numOfweight+1];
        dp = new boolean[31][15001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=numOfweight; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        checkWeight(0,0);

        int numOfmarble = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<numOfmarble; i++){
            int marble = Integer.parseInt(st.nextToken());
            if(marble > 15000){
                sb.append("N ");
            }
            else{
                sb.append(dp[numOfweight][marble] ? "Y ": "N ");
            }
        }
        System.out.println(sb);
    }

    public static void checkWeight(int i, int w){
        if(dp[i][w])
            return;
        dp[i][w] = true;
        if(i==numOfweight)
            return;

        checkWeight(i+1,w+arr[i+1]);
        checkWeight(i+1, w);
        checkWeight(i+1,Math.abs(w-arr[i+1]));
    }
}
