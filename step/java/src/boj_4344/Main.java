package boj_4344;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        for(int i = 0; i<C;i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0, cnt = 0;
            for(int j = 0; j<n;j++){
                arr[j] = sc.nextInt();
                sum+=arr[j];
            }
            double avg = sum/(double)n;
            for(int k = 0; k<n;k++){
                if (arr[k]>avg)
                        cnt+=1;
            }
            System.out.printf("%.3f%%\n",cnt/(double)n*100);

        }

    }
}
