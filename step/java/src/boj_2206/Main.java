package boj_2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Info{
        int x, y, distance, d;

        public Info(int x, int y, int distance, int d){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();//row
        M = sc.nextInt();//col
        map = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i<N; i++){
            String tmp = sc.next();
            for(int j = 0; j<M; j++){
                map[i][j] = tmp.charAt(j)-'0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(0,0));

    }
    static int bfs(int x, int y){
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(x, y, 1, 0));
        visited[x][y] = 0;

        while(!q.isEmpty()){

            Info info = q.poll();

            if(info.x == N-1 && info.y == M-1){
                return info.distance;
            }

            for(int i = 0; i<4; i++){
                int needVisitedX = info.x + dx[i];
                int needVisitedY = info.y + dy[i];

                if(0<=needVisitedX && needVisitedX<N && 0<= needVisitedY && needVisitedY<M){
                    if(visited[needVisitedX][needVisitedY]>info.d){
                        if(map[needVisitedX][needVisitedY] == 0){
                            q.add(new Info(needVisitedX, needVisitedY, info.distance + 1, info.d));
                            visited[needVisitedX][needVisitedY] = info.d;
                        }
                        else{
                            if(info.d == 0){
                                q.add(new Info(needVisitedX, needVisitedY, info.distance+1, info.d+1));
                                visited[needVisitedX][needVisitedY] = info.d+1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}
