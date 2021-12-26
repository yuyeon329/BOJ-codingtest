package boj_1504;

import java.io.*;
import java.util.*;

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
// 1== v1, v2 == n 인 경우 고려하기
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int INF = Integer.MAX_VALUE;
    private static int N; //정점의 갯수
    private static int E; //간선의 수
    private static int v1;
    private static int v2;
    static List<Node>[] info;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        info = new ArrayList[N + 1];
        distance = new int[N + 1];

        Arrays.fill(distance, INF);

        for(int i = 1; i<=N; i++){
            info[i] = new ArrayList<>();
        }

        for(int i = 1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            info[start].add(new Node(end, weight));
            info[end].add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        int answer = 0;
        if(v1==1 && v2==N) {
            dijkstra(1);
            answer = (distance[v2] == INF) ? -1 : distance[v2];
        }
        else {
            int r1 = 0; //1->v1 + v1->v2 + v2->N;
            int r2 = 0; //1->v2 + v2->v1 + v1->N;
            boolean check = true;

            //r1
            dijkstra(1);
            if (distance[v1] != INF)
                r1 += distance[v1]; // 1->v1;
            else
                check = false;

            Arrays.fill(distance, INF);
            dijkstra(v1);
            int tmp = distance[v2];
            if (tmp != INF)
                r1 += tmp; // v1->v2;
            else
                check = false;

            Arrays.fill(distance, INF);
            dijkstra(v2);
            if (distance[N] != INF)
                r1 += distance[N]; // v2->N;
            else
                check = false;

            //r2
            Arrays.fill(distance, INF);
            dijkstra(1);
            if (distance[v2] != INF)
                r2 += distance[v2]; // 1->v2;
            else
                check = false;
            r2 += tmp; // v2->v1;

            Arrays.fill(distance, INF);
            dijkstra(v1);
            if (distance[N] != INF)
                r2 += distance[N]; // v1->N;
            else
                check = false;

            answer = check ? Math.min(r1, r2) : -1;
        }
        System.out.println(answer);
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.destination;

            if(check[cur] == true){
                continue;
            }
            check[cur] = true;
            for(Node node : info[cur]){
                if(distance[node.destination] > distance[cur] + node.weight){ // 갈곳이 > 현재 노드를 + 거쳐서 가는게 더 짧은 경우
                    distance[node.destination] = distance[cur] + node.weight;
                    pq.add(new Node(node.destination, distance[node.destination]));
                }
            }
        }

    }
}
