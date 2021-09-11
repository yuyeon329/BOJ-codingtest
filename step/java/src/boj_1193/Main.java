package boj_1193;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int count = 1, range = 1;
        int numerator = 0, denominator = 0;
        while(X>range){
            count += 1;
            range += count;
        }
        range -= count;
        //range 활용
        if(count%2==0){//분자 업 분모 다운
            numerator = X - range;
            denominator = count - (X - range - 1);
        }
        else{//분자 다운 분모 업
            numerator = count - (X - range - 1);
            denominator = X - range;
        }
        System.out.printf("%d/%d",numerator,denominator);
    }
}
