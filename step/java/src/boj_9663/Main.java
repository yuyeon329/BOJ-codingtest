package boj_9663;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> candidate = new ArrayList<Integer>();
        int N = sc.nextInt();
        dfs(N, 0, candidate);
        System.out.println(cnt);

    }

    public static boolean isavailable(List<Integer> candidate, int current_Col){
        int current_Row = candidate.size();
        for(int i = 0; i<current_Row; i++){
            if ((current_Col == candidate.get(i)) || Math.abs(current_Row - i) == Math.abs(current_Col - candidate.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void dfs(int N, int current_Row, List<Integer> candidate){
        if(current_Row == N){
            cnt += 1;
            return;
        }
        for(int i = 0; i<N;i++){
            if (isavailable(candidate, i)){
                candidate.add(i);
                dfs(N, current_Row+1, candidate);
                candidate.remove(candidate.get(candidate.size()-1));
                
            }
        }

    }
}


