package boj_10816;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for(int i = 0; i<N; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        int M = sc.nextInt();
        for(int i = 0; i<M; i++){
            int item = sc.nextInt();
            sb.append(upperBound(item)-lowerBound(item)).append(' ');
        }
        System.out.println(sb);
    }

    public static int upperBound(int item){
        int l = 0;
        int h = arr.size();
        while(l<h){
            int m =(l + (h-l)/2);
            if(item >= arr.get(m)){
                l = m + 1;
            }else{
                h = m;
            }
        }
        return l;

    }
    public static int lowerBound(int item){
        int l = 0;
        int h = arr.size();
        while(l<h){
            int m = (l + (h-l)/2);
            if(item <= arr.get(m)){
                h = m;
            }
            else{
                l = m+1;
            }
        }
        return l;
    }

}
