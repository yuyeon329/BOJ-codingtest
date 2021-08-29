package boj_1152;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        int cnt = 0;
        for(int i = 0; i<words.length;i++){
            if(words[i].equals("")){
                continue;
            }
            else{
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }
}
