package boj_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int destination, weight;

    public Node(int destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}

public class Main {
    private static int N, M;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long INF = Integer.MAX_VALUE;
    static List<Node>[] info;
    static long[] distance;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new ArrayList[N+1];
        distance = new long[N+1];
        Arrays.fill(distance, INF);

        for(int i = 1; i<=N; i++){
            info[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            info[a].add(new Node(b,c));
        }

        if(bellmanFord()){
            sb.append("-1").append("\n");
        }
        else{
            for(int i = 2; i<=N; i++){
                if(distance[i] == INF){
                    sb.append("-1");
                }else{
                    sb.append(distance[i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord(){
        distance[1] = 0;
        boolean update = false;

        for(int i = 1; i<N; i++){
            update = false;
            for(int j = 1; j<=N; j++){
                for(Node node : info[j]){
                    if(distance[j] == INF){
                        break;
                    }
                    if(distance[node.destination]>distance[j]+node.weight){
                        distance[node.destination] = distance[j]+node.weight;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }

        if(update){
            for(int i = 1; i<=N; i++){
                for(Node node : info[i]){
                    if(distance[i] == INF){
                        break;
                    }
                    if(distance[node.destination]>distance[i]+node.weight){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
