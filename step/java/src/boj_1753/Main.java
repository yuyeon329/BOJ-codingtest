package boj_1753;

import java.io.*;
import java.util.*;

//다익스트라 알고리즘
//다익스트라 알고리즘은 가중치가 양수일 때만 적용 가능!
//인접 행렬보단 인접 리스트가 더 효율적

//자기 자신과 매개변수를 비교하는 Comparable 사용
//이를 위해 compareTo를 구현해야함
//양수를 return 하면 두 수의 위치를 바꿔주므로 <자기자신의 가중치 - 매개변수의 가중치> return
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

    public static int INF = Integer.MAX_VALUE; //distance 배열 비교 초기화용
    public static int V; //정점의 수
    public static int E; //간선의 수
    public static int K; //시작 정점
    static List<Node>[] info; //정보를 담을 리스트
    static int[] distance; //시작지점으로 부터 모든 노드별 최단 거리를 저장할 int 배열
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        info = new ArrayList[V + 1]; //정보를 담을 리스트
        distance = new int[V + 1]; //시작지점으로 부터 모든 노드별 최단 거리를 저장할 int 배열

        Arrays.fill(distance, INF); //최단 거리 정보를 담을 리스트를 INF로 초기화

        for(int i = 1; i<=V; i++){
            info[i] = new ArrayList<>(); // 정보를 저장하기 위한 리스트
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // start--(weight)--end 정보 초기화
            info[start].add(new Node(end, weight));
        }

        dijkstra(K);

        for(int i = 1; i<=V; i++){
            if(distance[i] == INF){
                sb.append("INF\n");
            }else{
                sb.append(distance[i] + "\n");
            }
        }

        System.out.println(sb);
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        pq.add(new Node(start, 0)); //시작 노드 삽입
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll(); //우선순위 가장 높은 노드 꺼냄
            int cur = curNode.destination;

            if(check[cur] == true){
                continue;
            }
            check[cur] = true;
            for(Node node : info[cur]){
                if(distance[node.destination]>distance[cur] + node.weight){ //현재 노드를 거쳐가는 경로가 더 짧다면,
                    distance[node.destination] = distance[cur] + node.weight; // 새로 갱신
                    pq.add(new Node(node.destination, distance[node.destination])); // 갱신된 정보에 해당하는 Node(도착지, 새로운 경로의 가중치의 합)을 큐에 삽입

                }
            }
        }
    }
}
