package boj_2675;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T;i++){
            int R = sc.nextInt();
            String S = sc.next();
            String str = "";

            for(int j = 0; j<S.length();j++){
                char tmp = S.charAt(j);
                str += Character.toString(tmp).repeat(R);
            }
            System.out.println(str);
        }
    }
}
