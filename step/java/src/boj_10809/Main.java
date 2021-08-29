package boj_10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        String S = sc.next();
        for(int i = 0; i<S.length();i++){
            arr[S.charAt(i)-'a'] = S.indexOf(S.charAt(i));
        }
        for(int j =0; j<arr.length;j++){
            System.out.print(arr[j]+" ");
        }
        
    }
}
