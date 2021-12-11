package boj_2606;

import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int vertex; //정점
    static int edge; //간선
    static int myGraph[][]; //인접행렬
    static int cnt_cumputer = -1;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt();
        edge = sc.nextInt();
        myGraph = new int[vertex][vertex];

        for(int i = 0; i<edge; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            myGraph[node1-1][node2-1] = 1;
            myGraph[node2-1][node1-1] = 1;
        }

        visited = new boolean[vertex+1];
        bfs(1);
//        dfs(1);
        System.out.println(cnt_cumputer);
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            cnt_cumputer++;
            for(int i = 0; i<vertex; i++){
                if(myGraph[node-1][i] == 1 && visited[i+1] == false && (i+1)!=node){
                    visited[i+1] = true;
                    queue.add(i+1);
                }
            }
        }
    }
//
//    public static void dfs(int v){
//        visited[v] = true;
//        cnt_cumputer++;
//        for(int i = 0; i<vertex; i++){
//            if(myGraph[v-1][i] == 1 && visited[i+1] == false){
//                dfs(i+1);
//            }
//        }
//    }
}
