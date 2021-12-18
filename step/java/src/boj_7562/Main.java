package boj_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] map;

    static class Info{
        int x, y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T;
        int L;
        int cx, cy; // current location
        int gx, gy; // goal location

        T = sc.nextInt();
        for(int i = 0; i<T; i++){
            L = sc.nextInt();
            cx = sc.nextInt();
            cy = sc.nextInt();
            gx = sc.nextInt();
            gy = sc.nextInt();

            map = new int[L][L];
            sb.append(bfs(L, cx, cy, gx, gy)).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int L, int cx, int cy, int gx, int gy){
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(cx, cy));

        while(!q.isEmpty()){
            Info info = q.poll();
            if(info.x == gx && info.y == gy){
                return map[gx][gy];
            }
            for(int i = 0; i<8; i++){
                int needVisitedX = info.x + dx[i];
                int needVisitedY = info.y + dy[i];

                if(0<=needVisitedX && needVisitedX<L && 0<=needVisitedY && needVisitedY<L){
                    if(map[needVisitedX][needVisitedY] == 0){ //방문한 적이 없다면
                        q.add(new Info(needVisitedX, needVisitedY)); //추가 탐색 위해 큐에 추가
                        map[needVisitedX][needVisitedY] = map[info.x][info.y] + 1; //방문 처리
                    }
                }
            }
        }
        return -1;
    }
}
