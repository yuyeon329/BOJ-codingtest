package boj_1874;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> mystack = new ArrayList<>();

        int n = sc.nextInt();

        int start = 0;
        while(n > 0) {
            int item = sc.nextInt();
            if (item > start) {
                for (int i = start + 1; i <= item; i++) {
                    mystack.add(i);
                    sb.append('+').append('\n');
                }
                start = item;
            }
            else if(mystack.get(mystack.size()-1) != item){
                System.out.println("NO");
                return;
            }
            mystack.remove(mystack.size()-1);
            sb.append("-").append('\n');
            n --;
        }
        System.out.println(sb);
    }
}
