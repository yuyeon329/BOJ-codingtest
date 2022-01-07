package boj_11657;
//https://steady-coding.tistory.com/92
//https://4legs-study.tistory.com/26 개념
//https://4legs-study.tistory.com/27 풀이

//벨만포드 알고리즘 : 정점이 V개인 그래프에서, 한 정점에서 출발한 다른 정점까지의 최단 경로는
//많아봐야 V-1개의 간선을 지남.
//따라서 모든 정점에 대해 V-1번의 반복을 통해 가능한 모든 경로를 탐색

//벨만 포드 알고리즘은 음의 가중치가 있는 그래프에서 사용하는데,
//이때 음의 사이클이 발견되면 해당 경로가 존재하지 않는다고 판단한다.

//음의 사이클 판단 방법?
//벨만포드 알고리즘은 한 정점에서 출발한 다른 정점까지의 최단 경로는 많아야 "V-1"개의 간선을 지난다는 가정에서
//출발했으므로,
//V - 1개의 간선보다 더 많은 간선을 통해 최단경로를 구할 수 있다면 음의 사이클이 존재하는 것이다.
//따라서 최소한의 탐색을 통해 음의 사이클 존재를 확인하려면 V번 돌리면 된다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int destination, weight;

    public Node(int destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }
}

public class Main {
    private static int N, M;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long INF = 60000000000L;
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

        if(bellmanFord()){//음의 사이클이 발생
            sb.append("-1").append("\n");
        }
        else{
            for(int i = 2; i<=N; i++){
                if(distance[i] == INF){//경로가 없을 경우
                    sb.append("-1");
                }else{
                    sb.append(distance[i]); //경로 출력
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord(){
        boolean cycle = false; //음수 사이클 체크용
        distance[1] = 0;//이걸 해줘야.. if(distance[j] == INF에서 continue가 반복되어서 모든 조건이 -1되는 대참사 막음

        for(int i = 1; i<=N; i++){//음의 사이클 판단 용 / 1번째 노드를 기준으로 시작! 만약 N번째 노드 기준까지(N번만큼이나) 탐색을 돌렸는데 최단 거리가 업데이트가 됐다면
            // V-1개보다 많은 간선을 지나서도 최단거리가 업데이트 된 것이므로 음수 사이클이 존재하는 것이다
            for(int j = 1; j<=N; j++){ //j노드에서 출발
                if(distance[j] == INF) //j에서 갈 경로가 없다면 패스~
                    continue;
                for(Node node:info[j]){ //j에서 출발하여 갈 수 있는 모든 도시를 탐색
                    if(distance[node.destination] > distance[j] + node.weight){ //더 짧은 루트가 발견되면 갱신
                        distance[node.destination] = distance[j] + node.weight;
//                        System.out.printf("i:%d, root: %d -> %d\n", i, j, node.destination);
//                        System.out.println(Arrays.toString(distance));
                        if(i == N) //N-1번이 아닌 N번 탐색해버렸다면 음수 사이클이 발생한 거임
                            cycle = true;
                    }
                }
            }
        }
        return cycle;
    }
}
