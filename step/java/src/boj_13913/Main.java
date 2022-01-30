package boj_13913;

import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];
    static StringBuilder sb;
    static int time;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        K = sc.nextInt();

        time = bfs(N)-1;

        System.out.println(time);

        tracking();
    }

    public static int bfs(int N){
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N);
        visited[N]= 1;
        while(!q.isEmpty()){

            int cur = q.poll();

            if(cur == K)
                return visited[cur];

            int needVisitedPlus = cur + 1;

            if(needVisitedPlus <= 100000){
                if(visited[needVisitedPlus] == 0){
                    visited[needVisitedPlus] = visited[cur]+1;
                    q.add(needVisitedPlus);
                }
            }
            int needVisitedMinus = cur -1 ;

            if(0<=needVisitedMinus){
                if(visited[needVisitedMinus] == 0){
                    visited[needVisitedMinus] = visited[cur]+1;
                    q.add(needVisitedMinus);
                }
            }

            int needVisitedMul = cur * 2;
            if(needVisitedMul <= 100000){
                if(visited[needVisitedMul] == 0){
                    visited[needVisitedMul] = visited[cur]+1;
                    q.add(needVisitedMul);
                }
            }

        }
        return 0;
    }

    public static void tracking(){
        sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        while(time>0){
            //역트래킹한 위치가 0~100000 사이인지 범위 신경쓰기
            if(-1<(K-1) && (K-1)<= 100000 && visited[K-1]==time) {
                stack.push(K - 1);
                K = K - 1;
            }
            else if(-1<(K+1) && (K+1)<= 100000 && visited[K+1] == time) {
                stack.push(K + 1);
                K = K + 1;
            }
            else if((K%2 == 0) && -1<(K/2) && (K/2)<= 100000 && visited[K/2] == time) {
                stack.push(K / 2);
                K = K / 2;
            }
            time--;

        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

}
