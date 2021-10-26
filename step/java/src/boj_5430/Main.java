package boj_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> dq;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- >0){
            String p = br.readLine(); //수행할 함수
            int n = Integer.parseInt(br.readLine());//배열에 들어있는 수의 개수
            st = new StringTokenizer(br.readLine(),"[],");
            dq = new ArrayDeque<Integer>();

            while(st.hasMoreTokens()){
                dq.add(Integer.parseInt(st.nextToken()));
            }
            AC(p,dq);
        }
        System.out.println(sb);

    }

    public static void AC(String p, ArrayDeque<Integer> dq){

        boolean isRight = true;

        for(int i = 0; i<p.length();i++){
            if(p.charAt(i)=='R'){
                isRight = !isRight;
                continue;
            }
            else{//D
                if(isRight){
                    if(dq.pollFirst()==null){
                        sb.append("error\n");
                        return;
                    }
                }
                else{
                    if(dq.pollLast() == null){
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        sb.append("[");
        if(dq.size()>0){
            int tmp = dq.size()-2;

            if(isRight){

                for(int i = 0; i<=tmp; i++){
                    sb.append(dq.pollFirst()).append(",");
                }
                sb.append(dq.pollFirst());
            }
            else{
                for(int i = 0; i<=tmp; i++){
                    sb.append(dq.pollLast()).append(",");
                }
                sb.append(dq.pollFirst());

            }
        }
        sb.append("]\n");


    }
}
