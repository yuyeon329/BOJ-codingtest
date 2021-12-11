package boj_1260;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[][] myGraph;
    static boolean visit[];
    static StringBuilder sb;

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        myGraph = new int[N][N];
        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            myGraph[start-1][end-1] = 1;
            myGraph[end-1][start-1] = 1;
        }

        visit = new boolean[N+1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        sb.setLength(0);
        visit = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int v){
        visit[v] = true;
        sb.append(Integer.toString(v)).append(" ");
        for(int i = 0; i<N; i++){
            if(myGraph[v-1][i] == 1 && visit[i+1]==false){
                dfs(i+1);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visit[node] = true;
            sb.append(Integer.toString(node)).append(" ");
            for(int i = 0; i<N; i++){
                if(myGraph[node-1][i] == 1 && visit[i+1]==false && (i+1) != node){
                    queue.add(i+1);
                    visit[i+1] = true;
                }
            }
        }

    }
}
