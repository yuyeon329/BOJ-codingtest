package boj_1966;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            LinkedList<int[]> printer = new LinkedList<>();

            for(int j = 0; j<N; j++){
                printer.offer(new int[]{j, sc.nextInt()});
            }

            int answer = 0;
            while(!printer.isEmpty()){
                boolean isMax = true;
                int[] tmp = printer.poll();
                for(int j = 0; j < printer.size(); j++){
                    if(tmp[1]<printer.get(j)[1]){
                        printer.offer(tmp);
                        for(int k = 0; k<j; k++){
                            printer.offer(printer.poll());
                        }

                        isMax = false;
                        break;
                    }
                }
                if(isMax == false){
                    continue;
                }

                answer++;
                if(tmp[0]==M){
                    break;
                }
            }
            System.out.println(answer);

        }

    }
}
