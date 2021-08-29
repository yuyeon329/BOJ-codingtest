package boj_2908;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        StringBuffer s1 = new StringBuffer(s[0]);
        StringBuffer s2 = new StringBuffer(s[1]);
        String reversedS1 = s1.reverse().toString();
        String reversedS2 = s2.reverse().toString();

        System.out.println(Math.max(Integer.parseInt(reversedS1),Integer.parseInt(reversedS2)));
    }
}
