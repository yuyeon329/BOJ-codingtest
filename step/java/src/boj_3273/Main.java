package boj_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n,x;
    private static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);
        }
        x = Integer.parseInt(br.readLine());
        if(n == 1){
            if(n==x)
                System.out.println(1);
            else
                System.out.println(0);
        }else{
            Collections.sort(arr);
            System.out.println(twoPointer());
        }
    }

    public static int twoPointer(){
        int answer = 0;
        int start = 0;
        int end = arr.size()-1;
        while(start<end){
            int tmp = arr.get(start)+arr.get(end);
            if(tmp==x){ //합이 x면 answer++, 다음 쌍을 찾기 위해 start,end모두 이동
                answer+=1;
                start+=1;
                end-=1;
            }
            else{
                if(tmp<x){ //x보다 작으면 tmp를 증가시켜야 하므로 start+=1
                    start+=1;
                }else{ //x보다 크면 tmp를 감소시켜야 하므로 end-=1
                    end-=1;
                }
            }
        }
        return answer;
    }
}
