package boj_1697;

import java.util.*;

public class Main{

    static int N;
    static int K;
    static int[] visited = new int[100001];


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        System.out.println(bfs(N)-1); //첫 방문지를 +1 해줬으므로 bfs(N)-1 을 출력

    }

    //방문할 곳을 queue에 담고, 큐에서 차례대로 꺼내서 -1, +1, *2로 방문 가능한지 확인한다. 이때 방문한 곳을 또 방문하면 무한 반복이므로,
    // 처음 방문할 때 +1초씩 기록해줘서 똑같은 곳을 반복해서 방문하지 않도록 한다. 방문 가능한 곳은 또 큐에 넣고 계속 이 방법을 계속한다.
    public static int bfs(int N){
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N);
        visited[N] = 1; //재방문을 하면 무한 반복이므로 처음 수빈이가 출발한 곳을 방문처리
        // *처음부터 위치가 같았다면 바로

        while(!q.isEmpty()){//이동 시작

            int p = q.poll();

            // *이 조건이 참이 되어서 bfs종료
            if(p == K){ //동생의 위치에 도착하면 총 소요시간을 return
                return visited[p];
            }

            int needVisitedPlus = p + 1; // +1 이동

            if(needVisitedPlus <= 100000){ //이때 <=K 가 아닌 이유는 -1 백스탭 밟아서 K가 될 수도 있으므로. 이하 2*p도 마찬가지
                if(visited[needVisitedPlus] == 0){//방문한 적이 없다면
                    visited[needVisitedPlus] = visited[p] + 1; // 이제까지의 소요시간 +1초 기록
                    q.add(needVisitedPlus); //큐에 넣어줘서 해당 위치에서 또 이동을 할 수 있도록 한다.
                }
            }

            int needVisitedMinus = p - 1;

            if(0 <= needVisitedMinus){ //문제의 주어진 범위가 0<=K이므로
                if(visited[needVisitedMinus] == 0){
                    visited[needVisitedMinus] = visited[p] + 1;
                    q.add(needVisitedMinus);
                }
            }

            int needVisitedMul = p * 2;
            if(needVisitedMul <= 100000){
                if(visited[needVisitedMul] == 0){
                    visited[needVisitedMul] = visited[p] + 1;
                    q.add(needVisitedMul);
                }
            }

        }
        return 0; //그냥 return이 있어야 문법오류가 안남
    }
}
