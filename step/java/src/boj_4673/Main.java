package boj_4673;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        Arrays.fill(check,true);

        for(int i = 0; i<10000;i++){
            int tmp = is_Selfnumber(i+1);
            if(tmp<10001)
                check[tmp] = false;
        }
        for(int i = 1;i<10001;i++){
            if(check[i])
                System.out.println(i);
        }

    }
    public static int is_Selfnumber(int n){
        int N = n;
        while(n>0){
            N += n%10;
            n /=10;
        }
        return N;
    }
}
