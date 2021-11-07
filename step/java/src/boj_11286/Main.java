package boj_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((item1, item2) -> {
            int abs1 = Math.abs(item1);
            int abs2 = Math.abs(item2);
            return (abs1 != abs2) ? abs1-abs2 : (item1 > item2) ? 1 : -1;
        });

        for(int i = 0; i<N; i++){
            int item = Integer.parseInt(br.readLine());
            if(item==0){
                if(pq.size() == 0){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                pq.add(item);
            }
        }
        System.out.println(sb);
    }
}
