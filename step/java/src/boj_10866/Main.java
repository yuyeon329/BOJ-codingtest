package boj_10866;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> deque = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while(N-- > 0){
            String order = sc.next();
            switch(order){
                case "push_front":
                    int num = sc.nextInt();
                    push_front(num);
                    break;

                case "push_back":
                    int num2 = sc.nextInt();
                    push_back(num2);
                    break;

                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push_front(int num){
        deque.add(0,num);
    }

    public static void push_back(int num){
        deque.add(num);
    }

    public static int pop_front(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.remove(0);
    }

    public static int pop_back(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.remove(deque.size()-1);
    }

    public static int size(){
        return deque.size();
    }

    public static int empty(){
        if(deque.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static int front(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.get(0);
    }

    public static int back(){
        if(deque.isEmpty()){
            return -1;
        }
        return deque.get(deque.size()-1);
    }

}
