package boj_10828;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> mystack = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i = 0; i<N; i++){
            String order = sc.next();
            switch(order){

                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int data){
        mystack.add(data);
    }

    public static int pop(){
        if (mystack.size()==0){
            return -1;
        }
        else{
            return mystack.remove(mystack.size()-1);
        }
    }

    public static int size(){
        return mystack.size();
    }

    public static int empty(){
        if (mystack.isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int top(){
        if (mystack.isEmpty()){
            return -1;
        }
        else{
            return mystack.get(mystack.size()-1);
        }
    }
}
