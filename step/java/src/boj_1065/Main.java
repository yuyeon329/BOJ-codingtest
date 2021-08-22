package boj_1065;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        if(N<100)
            System.out.println(N);
        else {
            for (int i = 100; i < N + 1; i++) {
                if (is_arithmetic_sequence(i))
                    cnt += 1;
            }
            System.out.println(99 + cnt);
        }
    }
    public static boolean is_arithmetic_sequence(int n){
        int[] digits = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        if(digits[0]-digits[1] == digits[1]-digits[2])
            return true;
        else
            return false;
    }
}
