package boj_11444;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long B = sc.nextLong();
        if(B<=1){
            System.out.println(B);
        }
        else{
            long[][] arr = {{1,1},{1,0}};
            long[][] answer = pow(arr, (B-1));
            System.out.println(answer[0][0]);
        }

    }

    public static long[][] pow(long[][] arr1, long B){
        if(B == 1L){
            return arr1;
        }

        long[][] tmp = pow(arr1, B/2);
        tmp = mul(tmp, tmp);

        if(B % 2 == 1L){
            return mul(tmp, arr1);
        }
        return tmp;
    }

    public static long[][] mul(long[][] tmp1, long[][] tmp2){
        long[][] tmp = new long[2][2];
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                for(int k = 0; k<2; k++){
                    tmp[i][j] += tmp1[i][k]*tmp2[k][j];
                    tmp[i][j] %= 1000000007;
                }
            }
        }
        return tmp;
    }

    }


