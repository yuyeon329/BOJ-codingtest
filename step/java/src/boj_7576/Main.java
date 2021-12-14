package boj_7576;
import java.util.*;
public class Main{

    public static int M;
    public static int N;
    public static int[][] tomato;

    public static int[] x = {0, 0, -1, 1};
    public static int[] y = {-1, 1, 0, 0};

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        tomato = new int[N][M];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                int tmp = sc.nextInt();
                tomato[i][j] = tmp;
            }
        }
        System.out.println(bfs(M,N));
    }

    public static int bfs(int M, int N) {
        Queue<location> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 1) {
                    q.add(new location(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            location loc = q.poll();
            int needVisit_x;
            int needVisit_y;
            for (int i = 0; i < 4; i++) {
                needVisit_x = loc.x + x[i];
                needVisit_y = loc.y + y[i];


                if (0 <= needVisit_x && needVisit_x < N && 0 <= needVisit_y && needVisit_y < M) {
                    if (tomato[needVisit_x][needVisit_y] == 0) {
                        q.add(new location(needVisit_x, needVisit_y));
                        tomato[needVisit_x][needVisit_y] = tomato[loc.x][loc.y] + 1;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        //일수 구해서 출력 part
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return -1; // 모두 안익음
                }
                answer = Math.max(answer, tomato[i][j]);
            }
        }

        if (answer == 1) { //원래 모두 익어있었음
            return 0;
        } else { //시간을 들여 익힌 경우
            return answer-1;
        }

    }
}
class location {
    int x;
    int y;

    location(int x, int y){
        this.x = x;
        this.y = y;
    }
}


