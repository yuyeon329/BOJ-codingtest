package boj_2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int mul = A*B*C;
        int[] num = {0,0,0,0,0,0,0,0,0,0};
        String mul_to_str = Integer.toString(mul);
        for(int i = 0; i<mul_to_str.length();i++){
            num[mul_to_str.charAt(i)-'0']++;
        }

        for(int i = 0; i<num.length;i++){
            System.out.println(num[i]);
        }

    }
}
