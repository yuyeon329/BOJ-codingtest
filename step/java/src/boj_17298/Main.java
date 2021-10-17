package boj_17298;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int[] seq = new int[N];
        int[] stack = new int[N];
        int top = -1;

        for(int i = 0; i<N; i++){
            seq[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            while(top != -1 && seq[stack[top]] < seq[i]){
                seq[stack[top]] = seq[i];
                top --;
            }
            top ++;
            stack[top] = i;
        }

        for(int i = top; i>= 0; i--){
            seq[stack[i]] = -1;
        }

        for(int num : seq){
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }
}
