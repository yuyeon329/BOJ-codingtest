package boj_8958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       String[] str = new String[N+1];
       for(int i = 0; i<N;i++){
           int count = 1, sum = 0;
           str[i] = sc.next();
           for(int j = 0; j<str[i].length();j++){
               if(str[i].charAt(j) == 'O') {
                   sum += count;
                   count+=1;
               }
               else
                   count = 1;
           }
           System.out.println(sum);

       }
    }
}
