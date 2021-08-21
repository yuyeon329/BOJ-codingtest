package boj_1546;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] arr = new double[N];
        double sum = 0;

        for(int i = 0; i<N;i++){
            arr[i] = sc.nextDouble();
        }
        Arrays.sort(arr);
        double max = arr[arr.length-1];
        for(int i = 0; i<N;i++){
            arr[i] = arr[i]/(double)max*100;
            sum+=arr[i];
        }
        System.out.println(sum/N);
    }
}
