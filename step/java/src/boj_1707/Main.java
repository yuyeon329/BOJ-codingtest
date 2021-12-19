package boj_1707;
//인접행렬로 푸니깐 메모리 초과떠서 ArrayList 배열로 품!
import java.util.*;

public class Main {
    static int visited[];
    static ArrayList<Integer>[] graph;
    static int v; //정점

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            v = sc.nextInt();
            int e = sc.nextInt(); //간선
            graph = new ArrayList[v+1];

            for(int j = 0; j<=v; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for (int k = 0; k < e; k++) {
                int tmp_x = sc.nextInt();
                int tmp_y = sc.nextInt();
                graph[tmp_x].add(tmp_y);
                graph[tmp_y].add(tmp_x);
            }


            visited = new int[v + 1];
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
        //System.out.println(Arrays.toString(graph));
    }

    static String bfs() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) { //전부 순회하는 이유: 비연결 그래프가 input으로 주어질 수도 있기 때문
            if (visited[i] == 0) {
                q.add(i); // 방문할 정점 큐에 삽입
            }

            while (!q.isEmpty()) {
                int node = q.poll(); //큐에서 꺼낸, 탐사 출발할 노드

                for (int j = 0; j < graph[node].size(); j++) {//노드에 연결된 탐사할 노드들 탐색 시작

                    if (visited[graph[node].get(j)] == 0) { //새로 탐사한 새 노드를 방문을 안했다면
                        q.add(graph[node].get(j)); //큐에 넣어주고
                        if(visited[node] == 1){ //만약 노드가 1로 방문처리 되어있다면
                            visited[graph[node].get(j)] = 2; //새로 탐사한  새 노드엔 2를 넣어줘서 다른 팀으로 나눠주고,
                        } else{ //노드가 2로 방문처리 되어있다면
                            visited[graph[node].get(j)] = 1; //새로 탐사한 새 노드엔 1를 넣어줘서 다른 팀으로 나눠줌
                        }
                    } else if(visited[graph[node].get(j)] == 1){ //만약 탐사할 연결된 새 노드가 이미 방문한 적이 있고, 방문처리가 1인데
                        if(visited[node] == 1){ //노드가 1이였다면
                            return "NO"; //이분 그래프가 아님!
                        }
                    } else if(visited[graph[node].get(j)] == 2){ //만약 탐사할 연결된 새 노드가 이미 방문한 적이 있고, 방문처리가 2인데
                        if(visited[node] == 2){ //노드가 2였다면
                            return "NO"; //이분 그래프가 아님!!
                        }
                    }

                    }

                }
            }
        return "YES";
    }
}
