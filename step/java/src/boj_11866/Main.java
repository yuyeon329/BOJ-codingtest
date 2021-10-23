package boj_11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> myqueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 1; i<=N; i++){
            myqueue.offer(i);
        }

        sb.append('<');
        while(myqueue.size()>1){
            for(int i = 0; i< K; i++){
                if(i == K-1){
                    sb.append(myqueue.peek()).append(", ");

                    myqueue.poll();
                }
                else{
                    myqueue.offer(myqueue.poll());
                }
            }

        }
        sb.append(myqueue.poll()).append('>');
        System.out.println(sb);

    }
}
