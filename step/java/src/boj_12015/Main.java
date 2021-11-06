package boj_12015;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i = 0; i<N; i++){
            int tmp = sc.nextInt();
            if(arr.get(arr.size()-1)<tmp){
                arr.add(tmp);
            }
            else{
                int start = 1;
                int end = arr.size();
                int answer = 0;
                while(start<=end){
                    int mid = (start+end)/2;
                    if(arr.get(mid)<tmp){
                        start = mid + 1;
                    }
                    else{
                        answer = mid;
                        end = mid -1;
                    }
                }
                arr.set(answer,tmp);
            }
        }
        System.out.println(arr.size()-1);
    }
}
