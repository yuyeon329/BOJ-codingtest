package boj_10773;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> mystack = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for(int i = 0; i<K;i++){
            int num = sc.nextInt();
            if( num > 0){
                push(num);
            }
            else{
                pop();
            }
        }
        int sum = 0;
        for(Integer num:mystack){
            sum += num;
        }
        System.out.println(sum);
    }
    public static void push(int item){
        mystack.add(item);
    }

    public static void pop(){
        mystack.remove(mystack.size()-1);
    }
}
