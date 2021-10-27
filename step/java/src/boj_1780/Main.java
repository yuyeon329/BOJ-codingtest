package boj_1780;
import java.util.*;
public class Main{

    public static StringBuilder sb = new StringBuilder();
    public static int minus_one;
    public static int zero;
    public static int one;
    public static int[][] data;

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        data = new int[N][N];

        //input data
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                data[i][j] = sc.nextInt();
            }
        }

        cut(0, 0, N);

        //print answer
        System.out.println(minus_one);
        System.out.println(zero);
        System.out.println(one);

    }

    public static void cut(int r, int c, int new_size){
        boolean isSame = true;
        int tmp = data[r][c];

        Loop1 : //check array
        for(int i = r; i<r+new_size; i++){
            for(int j = c; j<c+new_size; j++){
                if(data[i][j] != tmp){
                    isSame = !isSame;
                    break Loop1;

                }
            }
        }

        if(isSame){//count paper
            if(tmp == -1){
                minus_one++;
            }
            if(tmp == 0){
                zero++;
            }
            if(tmp == 1){
                one++;
            }
            return;
        }

        else{//call recursive

            new_size /= 3;

            cut(r, c, new_size);
            cut(r, c+new_size, new_size);
            cut(r, c+(new_size*2), new_size);

            cut(r+new_size, c, new_size);
            cut(r+new_size, c+new_size, new_size);
            cut(r+new_size, c+(new_size*2), new_size);

            cut(r+(new_size*2), c, new_size);
            cut(r+(new_size*2), c+new_size, new_size);
            cut(r+(new_size*2), c+(new_size*2), new_size);
        }

    }

}