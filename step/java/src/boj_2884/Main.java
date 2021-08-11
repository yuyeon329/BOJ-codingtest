package boj_2884;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int h = sc.nextInt();
         int m = sc.nextInt();

         if (m<45)
             if(h==0)
                 System.out.printf("%d %d", 23, m+15);
             else
                 System.out.printf("%d %d", h-1, m+15);
         else
             System.out.printf("%d %d", h, m-45);

    }
}
