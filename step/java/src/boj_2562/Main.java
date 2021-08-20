package boj_2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[9];
        int max = 0;
        int idx = 0;
        for(int i = 0; i<9;i++){
            num[i] = sc.nextInt();
        }
        for(int i = 0; i<9;i++){
            if(num[i]>max){
                max = num[i];
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx+1);
    }
}
