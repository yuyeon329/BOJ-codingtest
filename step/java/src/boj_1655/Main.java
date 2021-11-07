package boj_1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((item1, item2)-> item2 - item1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            int item = Integer.parseInt(br.readLine());
            if(i%2==0){
                maxPQ.add(item);
            }else{
                minPQ.add(item);
            }
            if((!maxPQ.isEmpty()&&!minPQ.isEmpty()) && (maxPQ.peek()>minPQ.peek())){
                int tmp = maxPQ.poll();
                int tmp2 = minPQ.poll();
                maxPQ.add(tmp2);
                minPQ.add(tmp);
            }
            sb.append(maxPQ.peek()).append("\n");
        }
        System.out.println(sb);

    }
}
