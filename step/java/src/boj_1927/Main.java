package boj_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue pq = new PriorityQueue();

        for(int i = 0; i<N; i++){
            int item = Integer.parseInt(br.readLine());
            if(item == 0){
                if(cnt==0){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pq.pop()).append("\n");
                }
            }
            else{
                pq.push(item);
            }
        }
        System.out.println(sb);

    }

    public static class PriorityQueue{
        int[] pq = new int[N];

        PriorityQueue(){}

        public void push(int item){
            cnt++;
            pq[cnt] = item;
            int child = cnt;
            int parent = child/2;
            while(child>1&&pq[parent]>pq[child]){
                if(child == 1 || pq[parent]<pq[child]){
                    break;
                }
                int tmp = pq[parent];
                pq[parent] = pq[child];
                pq[child] = tmp;
                child /=2;
                parent = child/2;
            }

        }

        public int pop(){
            int item = pq[1];
            pq[1] = pq[cnt];
            cnt--;
            int parent = 1;
            int child;
            while(true){
                child = parent*2;
                if(child<cnt && pq[child]>pq[child+1]){
                    child++;
                }
                if(child>cnt || pq[child]>pq[parent]){
                    break;
                }

                int tmp = pq[parent];
                pq[parent] = pq[child];
                pq[child] =tmp;

                parent = child;
            }
            return item;
        }
    }
}
