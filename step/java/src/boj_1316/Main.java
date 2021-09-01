package boj_1316;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = N;
        for(int i = 0; i<N;i++){
            String s = sc.next();
            boolean[] check = new boolean[26];

            for(int j = 1; j<s.length();j++){
                if(s.charAt(j) != s.charAt(j-1)){
                    if(check[s.charAt(j)-97]==true){
                        count --;
                        break;
                    }
                    check[s.charAt(j-1)-97] = true;
                }
            }

        }
        System.out.println(count);
    }
}
