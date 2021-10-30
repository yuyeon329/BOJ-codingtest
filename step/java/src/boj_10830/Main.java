package boj_10830;
import java.util.Scanner;

public class Main {
    public static int N;
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[][] arr = new int[N][N];
        long B = sc.nextLong();

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                arr[i][j]  = sc.nextInt()%1000;
            }
        }

        int[][] answer = pow(arr, B);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    public static int[][] pow(int[][] arr, long B){
        if(B == 1){
            return arr;
        }
        int[][] tmp = pow(arr, B/2);
        tmp = mul(tmp, tmp);
        if(B%2 == 1L){
            return mul(tmp,arr);
        }
        return tmp;
    }

    public static int[][] mul(int[][] arr1, int[][] arr2){
        int[][] tmp = new int[N][N];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<N; k++){
                    tmp[i][j] += arr1[i][k]*arr2[k][j];
                    tmp[i][j] %= 1000;
                }
            }
        }
        return tmp;
    }
}
