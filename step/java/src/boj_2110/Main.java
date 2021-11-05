package boj_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        int N = sc.nextInt();
        int C = sc.nextInt();

        for(int i = 0; i<N; i++){
            array.add(sc.nextInt());
        }

        Collections.sort(array);

        int answer = 0;
        int minDis = 1;
        int maxDis = array.get(array.size()-1)-array.get(0);
        int dis = 0;

        while(minDis <= maxDis){
            int mid = (minDis + maxDis)/2;
            int start = array.get(0);
            int cnt = 1;

            for(int i=0; i<N; i++){
                dis = array.get(i)-start;
                if(dis >= mid){
                    cnt++;
                    start = array.get(i);
                }
            }

            if(cnt < C){
                maxDis = mid - 1;
            }
            else{
                answer = mid;
                minDis = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
