package boj_5622;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dial  = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        String str = sc.next();
        int time = 0;

        for(int i = 0; i<str.length();i++){
            for(int j = 0; j<dial.length;j++){
                if(dial[j].contains(Character.toString(str.charAt(i)))){
                    time += j+3;
                }
            }
        }
        System.out.println(time);
    }
}
