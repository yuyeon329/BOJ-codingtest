package boj_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static  int n,m;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int INF = 100000000; //Integer.Max_VALUE로 하면 범위 때문에 음수가 됨
    static int[][] info;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine()); //정점 개수
        m = Integer.parseInt(br.readLine()); //간선 개수

        info = new int[n+1][n+1];

        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                info[i][j] = INF;
                if(i==j)
                    info[i][j] = 0;

            }
        }

        for(int i = 0; i<m; i++){ //간선 정보
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[a][b] = Math.min(info[a][b], c);
        }
        FloydWarshall();
    }

    public static void FloydWarshall(){
        for(int l = 1; l <= n; l++) { //경유지
            for (int i = 1; i <= n; i++) { //출발지
                for (int j = 1; j <= n; j++) { //도착지
                    if(info[i][j] > info[i][l] + info[l][j]){
                        info[i][j] = info[i][l] + info[l][j];
                    }
                }
            }
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(info[i][j] == INF){
                    sb.append("0").append(" ");
                }else{
                    sb.append(info[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
