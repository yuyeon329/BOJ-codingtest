package boj_1920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N= sc.nextInt();
        for(int i = 0; i<N; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        int M = sc.nextInt();

        for(int i = 0; i<M; i++){
            int item = sc.nextInt();
            sb.append(binarySearch(0, N-1, item)).append('\n');
        }
        System.out.println(sb);
    }

    public static int binarySearch(int start, int end, int item){
        if(end==0){
            if(arr.get(0) == item){
                return 1;
            }
            else{
                return 0;
            }
        }
        int mid = (start+end)/2;

        if(item == arr.get(mid)){
            return 1;
        }
        if(start <= end){
            if(item < arr.get(mid)){
                return binarySearch(0, mid-1, item);
            }
            else{
                return binarySearch(mid+1, end, item);
            }
        }
        else{
            return 0;
        }

    }

}
