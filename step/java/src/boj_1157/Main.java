package boj_1157;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        String S = sc.next().toUpperCase();
        int max = -1, idx = 0;
        char answer = '?';

        for(int i = 0; i<S.length();i++){
            int tmp = S.charAt(i)-65;
            arr[tmp]++;
            if(max<arr[tmp]){
                max = arr[tmp];
                answer = S.charAt(i);
            }
            else if(max==arr[tmp]){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
