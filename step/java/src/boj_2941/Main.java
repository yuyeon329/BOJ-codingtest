package boj_2941;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i = 0; i< croatia.length;i++){
            s = s.replace(croatia[i],".");
        }
        System.out.println(s.length());

    }
}
