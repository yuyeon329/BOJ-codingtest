package boj_1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int v, e;
    private static int INF = 4000000;
    private static int[][] info;
    private static int [] distance;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); //정점
        e = Integer.parseInt(st.nextToken()); //간선

        info = new int[v+1][v+1];
        distance = new int[v+1];

        for(int i = 0; i<=v; i++){
            Arrays.fill(info[i], INF);
        }

        for(int i = 0; i<e; i++){ //간선 정보
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[a][b] = c;
        }
        System.out.println(FloydWarshallForCycle());
    }

    public static int FloydWarshallForCycle(){
        //모든 정점간의 최단 경로 구해줌
        for(int l = 1; l<=v; l++){
            for(int i = 1; i<=v; i++){
                for(int j = 1; j<=v; j++){
                    if(info[i][j]>info[i][l]+info[l][j]){
                        info[i][j] = info[i][l] + info[l][j];
                    }
                }
            }
        }

        //그 중 사이클만 모은 다음
        for(int i = 1; i<=v; i++){
            distance[i] = info[i][i];
        }

        //최소 사이클 구하기 위해 오름차순 Sort
        Arrays.sort(distance);

        //최소 사이클을 구할 수 있다면 최소 사이클 리턴,없다면 -1 리턴
        return (distance[1]!=INF) ? distance[1] : -1;
    }
}
