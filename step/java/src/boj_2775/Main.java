package boj_2775;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] floor_0 = new int[n];
            for(int j = 0; j<n; j++){
                floor_0[j] = j+1;
            }
            for(int l = 0; l<k; l++){
                for(int m = 1; m<n;m++){
                    floor_0[m] += floor_0[m-1];
                }
            }
            System.out.println(floor_0[n-1]);
        }
    }

}
