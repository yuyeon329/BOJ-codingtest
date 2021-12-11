package boj_2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] myMap;
    public static int cnt_home;
    public static int cnt_village;
    public static boolean visited[][];
    public static int[] x = {0, 0, -1, 1};
    public static int[] y = {-1, 1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> answer = new ArrayList<>();
        N = sc.nextInt();
        myMap = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i<N; i++){
            String tmp = sc.next();
            for(int j = 0; j<N; j++){
                myMap[i][j] = tmp.charAt(j)-'0';
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(myMap[i][j] == 1 && visited[i][j] == false){
                    cnt_home = 0;
                    cnt_village++;
                    graphsearch(i,j);
                    answer.add(cnt_home);
                }
            }
        }

        Collections.sort(answer);
        if(cnt_village == 0){
            System.out.println(0);
            System.out.println(0);
        }
        else {
            System.out.println(cnt_village);
            for (int i = 0; i < answer.size(); i++) {
                if(answer.get(i) > 0){
                    System.out.println(answer.get(i));
                }
            }
        }

    }

    public static void graphsearch(int i, int j){
        cnt_home++;
        visited[i][j] = true;
        for(int k = 0; k<4; k++){
            int tmp_x = i+x[k];
            int tmp_y = j+y[k];
            if(tmp_x>=0 && tmp_x<N && tmp_y >=0 && tmp_y<N && myMap[tmp_x][tmp_y] == 1 && visited[tmp_x][tmp_y] == false){
                graphsearch(tmp_x, tmp_y);
            }
        }

    }
}
