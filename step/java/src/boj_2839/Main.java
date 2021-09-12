package boj_2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bag = 0;
        while (N>=0){
            if(N%5==0){
                bag += N/5;
                System.out.println(bag);
                break;
            }
            else{
                N -= 3;
                bag++;
            }
        }
        if(N<0)
            System.out.println(-1);

    }
}
