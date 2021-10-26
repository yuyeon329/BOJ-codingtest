package boj_1992;

import java.util.Scanner;

public class Main {
    public static int[][] data;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc .nextInt();
        data = new int[N][N];

        for(int i = 0; i<N; i++){
            String tmp = sc.next();
            for(int j = 0; j<N; j++){
                data[i][j] = tmp.charAt(j)-'0';
            }
        }
        quad(0, 0, N);
        System.out.println(sb);
    }

    public static void quad(int r, int c, int new_size){
        boolean isSame = true;
        int color = data[r][c];
        Loop1:
        for(int i = r; i<r+new_size; i++){
            for(int j = c; j<c+new_size; j++){
                if(data[i][j]!=color){
                    isSame = !isSame;
                    break Loop1;
                }
            }
        }
        if(isSame){
            sb.append(color);
            return;
        }
        new_size /= 2;

        sb.append("(");
        quad(r, c, new_size);
        quad(r,c+new_size, new_size);
        quad(r+new_size, c, new_size);
        quad(r+new_size, c+new_size, new_size);
        sb.append(")");

    }
}
