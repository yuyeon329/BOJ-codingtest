package boj_9019;

import java.util.*;
//무조건 stack써서 tracking할 생각 말기 사고를 유연하게 하시오.
public class Main {
    static int Max = 10000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i<T; i++){

            int A = sc.nextInt();

            int B = sc.nextInt();

            int[] register = new int[Max];

            String[] calc = new String[Max];

            Queue<Integer> q = new LinkedList<>();

            register[A] = 1;

            q.add(A);

            Arrays.fill(calc,"");

            while(!q.isEmpty()){

                int cur = q.poll();

                if(cur == B)
                    break;

                int D = (2*cur)%Max;
                int S = (cur==0) ? 9999 : cur-1;
                int tmpL1 = cur%1000;
                int tmpL2 = cur/1000;
                int L = tmpL1*10+tmpL2;
                int tmpR1 = cur%10;
                int tmpR2 = cur/10;
                int R = tmpR1*1000+tmpR2;

                if(register[D] == 0){
                    register[D] = 1;
                    calc[D] = calc[cur]+"D";
                    q.add(D);
                }

                if(register[S] == 0){
                    register[S] = 1;
                    calc[S] = calc[cur]+"S";
                    q.add(S);
                }

                if(register[L] == 0){
                    register[L] = 1;
                    calc[L] = calc[cur]+"L";
                    q.add(L);
                }

                if(register[R] == 0){
                    register[R] = 1;
                    calc[R] = calc[cur]+"R";
                    q.add(R);
                }
            }
            System.out.println(calc[B]);
        }
    }
}
