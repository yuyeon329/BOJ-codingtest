package boj_2630;

import java.util.Scanner;

public class Main {
    public static int white;
    public static int blue;
    public static int[][] paper;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        paper = new int[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        cut(0,0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void cut(int i_start, int j_start, int new_size){
        boolean isSame = true;
        int tmp = paper[i_start][j_start];
        Loop1:
        for(int i = i_start; i<i_start+new_size; i++){
            for(int j = j_start; j<j_start+new_size; j++){
                if(paper[i][j] != tmp){
                    isSame = !isSame;
                    break Loop1;
                }
            }
        }
        if(isSame){
            if(tmp==1){
                blue++;
            }
            else{
                white++;
            }
            return;
        }
        new_size /= 2;

        cut(i_start, j_start, new_size);
        cut(i_start, j_start+new_size, new_size);
        cut(i_start+new_size, j_start, new_size);
        cut(i_start+new_size, j_start+new_size, new_size);

    }
}
