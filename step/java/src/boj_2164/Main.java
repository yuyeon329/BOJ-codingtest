package boj_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myqueue = new LinkedList<>();
        int N = sc.nextInt();
        for(int i = 0; i < N ; i++){
            myqueue.offer(i+1);
        }
        while(myqueue.size()>1){
            myqueue.poll();
            myqueue.offer(myqueue.poll());
        }
        System.out.println(myqueue.peek());
    }
}
