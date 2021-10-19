package boj_18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] myqueue = new int[2000000];
    static int size = 0;
    static int front = 0;
    static int back = -1;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "push":
                    int item = Integer.parseInt(st.nextToken());
                    push(item);
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

    public static void push(int item){
        back++;
        myqueue[back] = item;
        size++;
    }

    public static int pop(){
        if(size == 0){
            return -1;
        }
        else{
            int tmp = myqueue[front];
            size --;
            front++;
            return tmp;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size == 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int front(){
        if(size == 0){
            return -1;
        }
        else{
            return myqueue[front];
        }
    }

    public static int back(){
        if(size == 0){
            return -1;
        }
        else{
            return myqueue[back];
        }
    }

    }

