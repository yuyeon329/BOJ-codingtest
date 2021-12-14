package boj_7569;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static int M;
    public static int N;
    public static int H;
    public static int[][][] tomato;
    public static int[] x = {0,0,-1,1,0,0};
    public static int[] y = {1,-1,0,0,0,0};
    public static int[] z = {0,0,0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); //열
        N = sc.nextInt(); //행
        H = sc.nextInt(); //면

        tomato = new int [H][N][M];

        for(int i = 0; i<H; i++){ //면
            for(int j = 0; j<N;j++){ //행
                for(int k = 0; k<M; k++){ //열
                    tomato[i][j][k] = sc.nextInt();
                }
            }
        }
        System.out.println(bfs(H, N, M));

    }

    public static int bfs(int H, int N, int M){
        Queue<location> q= new LinkedList<>();
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    if(tomato[i][j][k] == 1){
                        q.add(new location(i, j, k));
                    }
                }
            }
        }
        while(!q.isEmpty()){
            location node = q.poll();
            int needVisit_x;
            int needVisit_y;
            int needVisit_z;

            for(int i = 0; i<6; i++){
                needVisit_x = node.x+x[i];
                needVisit_y = node.y+y[i];
                needVisit_z = node.z+z[i];

                if(0<=needVisit_x && needVisit_x<N && 0<=needVisit_y && needVisit_y<M && 0<=needVisit_z && needVisit_z<H){
                    if(tomato[needVisit_z][needVisit_x][needVisit_y] == 0){
                        tomato[needVisit_z][needVisit_x][needVisit_y] = tomato[node.z][node.x][node.y] + 1;
                        q.add(new location(needVisit_z, needVisit_x, needVisit_y));
                    }
                }
            }


        }

        int answer = Integer.MIN_VALUE;
        for(int i = 0; i<H; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    if(tomato[i][j][k] == 0){
                        return -1;
                    }
                    answer = Math.max(tomato[i][j][k], answer);
                }
            }
        }
        if(answer == 1){
            return 0;
        }
        else{
            return answer-1;
        }
    }
}

class location{
    int x;
    int y;
    int z;

    location(int z, int x, int y){
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
