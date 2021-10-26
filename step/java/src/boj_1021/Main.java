package boj_1021;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> q = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int move_cnt = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i<N; i++){
            q.add(i);
        }

        for(int i = 0; i<M; i++){
            int idx = sc.nextInt()-1;
            while(!q.isEmpty()){
                if(q.get(0) == idx){
                    q.remove(0);
                    break;
                }
                else if(q.indexOf(idx) <= (q.size()-1)/2){
                    moveLeft();
                }
                else{
                    moveRight();
                }
                move_cnt++;

            }

        }
        System.out.println(move_cnt);

    }
    public static void moveLeft(){
        q.add(q.remove(0));
    }

    public static void moveRight(){
        q.add(0, q.remove(q.size()-1));
    }
}
