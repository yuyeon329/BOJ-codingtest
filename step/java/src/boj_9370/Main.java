package boj_9370;

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
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int INF = Integer.MAX_VALUE;
    private static int T; //test case
    private static int n,m,t;
    private static int s,g,h;
    private static int a,b,d;
    static List<Node>[] info;
    static int[] distance;
    static int[] candidates;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++) { //Test Case
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //교차로
            m = Integer.parseInt(st.nextToken()); //도로
            t = Integer.parseInt(st.nextToken()); //목적지 후보 개수


            info = new ArrayList[n+1];
            distance = new int[n+1];
            candidates = new int[t];
            answer = new ArrayList<>();

            for(int l = 1; l<=n; l++){
                info[l] = new ArrayList<>();
            }


            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); //예술가들의 출발지
            g = Integer.parseInt(st.nextToken()); //지나친 도로의 한 교차로
            h = Integer.parseInt(st.nextToken()); //지나친 도로의 한 교차로

            for (int j = 0; j < m; j++) { //도로 정보
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                if((a==g && b==h) || (a==h && b==g)){
                    info[a].add(new Node(b,d*2-1)); //g-h 도로는 홀수처리
                    info[b].add(new Node(a,d*2-1)); //g-h 도로는 홀수처리
                }else {
                    info[a].add(new Node(b, d * 2));
                    info[b].add(new Node(a, d * 2));
                }
            }
            //짝+짝+짝...+홀 = 홀
            //짝+짝+...+짝 = 짝 이므로
            //distance의 값이 홀수면 g-h를 지났다는 뜻이므로, 후보 목적지 중에 값이 홀수인 것만 오름차순 정렬해서 출력해주면 된다!


            for(int k = 0; k<t; k++){ //후보지
                int x = Integer.parseInt(br.readLine());
                candidates[k] = x;
            }
            //
            Arrays.fill(distance, INF);
            dijkstra(s);

            for(int z = 0; z<candidates.length; z++){
                int answer_tmp = candidates[z];
                if(distance[answer_tmp] != INF && distance[answer_tmp] %2 != 0){
                    answer.add(answer_tmp);
                }
            }

            Collections.sort(answer);

            for(int q = 0; q<answer.size(); q++){
                System.out.printf("%d ",answer.get(q) );
            }
            System.out.println();
        }

    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        pq.add(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.destination;

            if(check[cur] == true){
                continue;
            }
            check[cur] = true;
            for(Node node: info[cur]){
                if(distance[node.destination]>distance[cur]+node.weight){
                    distance[node.destination] = distance[cur]+node.weight;
                    pq.add(new Node(node.destination, distance[node.destination]));
                }
            }
        }
    }
}
