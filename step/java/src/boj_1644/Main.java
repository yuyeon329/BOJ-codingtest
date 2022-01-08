package boj_1644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean prime[] = new boolean[4000001];
    static ArrayList<Integer> pn = new ArrayList<>();
    private static int N;
    private static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        makePrimeList();
        makePrime();
        System.out.println(answer);
    }

    public static void makePrimeList(){
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i*i<=4000000; i++){
            if(!prime[i]){
                for(int j = i*i; j<=4000000; j+=i){
                    prime[j] = true;
                }
            }
        }

        for(int i = 1; i<= 4000000; i++){
            if(!prime[i])
                pn.add(i);
        }
    }

    public static void makePrime(){
        int start = 0;
        int end = 0;
        int sum = 0;
        answer = 0;
        while(true){
            if(sum>N){
                sum -= pn.get(start++);
            }
            else if(end == pn.size()){
                break;
            }
            else{
                sum += pn.get(end++);
            }
            if(sum==N)
                answer++;
        }
    }

}
