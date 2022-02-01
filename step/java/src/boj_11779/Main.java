package boj_11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class Main {

    public static int INF = Integer.MAX_VALUE;
    public static int n; //도시 수
    public static int m;//버스 수
    static List<Node>[] info;
    static int[] distance;
    static int[] tracking;
    public static int departure, arrival;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        info = new ArrayList[n + 1]; //정보를 담을 리스트
        distance = new int[n + 1]; //시작지점으로 부터 모든 노드별 최단 거리를 저장할 int 배열

        Arrays.fill(distance, INF);
        for(int i = 1; i<=n; i++){
            info[i] = new ArrayList<>();
        }
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            info[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());

        departure = Integer.parseInt(st.nextToken());
        arrival = Integer.parseInt(st.nextToken());

        dijkstra(departure);
        System.out.println(distance[arrival]);
        trackingpath();
        System.out.println(cnt);
        System.out.println(sb);
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        tracking = new int[n+1];
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.destination;

            if(check[cur]==true){
                continue;
            }

            check[cur] = true;
            for(Node node : info[cur]){
                if(distance[node.destination]>distance[cur]+node.weight){
                    distance[node.destination] = distance[cur]+node.weight;
                    pq.add(new Node(node.destination, distance[node.destination]));
                    tracking[node.destination] = cur;
                }
            }
        }
    }
    public static void trackingpath(){
        Stack<Integer> stack = new Stack<>();
        int tmp = arrival;
        while(tmp != 0){
            stack.push(tmp);
            tmp = tracking[tmp];
            cnt++;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
    }
}
