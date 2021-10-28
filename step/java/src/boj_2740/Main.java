package boj_2740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int threshold = 16;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[128][128];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<M; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[128][128];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<K; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = Math.max(Math.max(N, K), M);
        int size = 1;
        while(true){
            if(size>=tmp){
                break;
            }
            size*=2;
        }

        int[][] C = mulArr(arr1, arr2, size);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<K;j++){
                sb.append(C[i][j]+ " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int[][] loopMul(int[][] A, int[][] B, int size){
        int tmp[][] = new int[size][size];
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                for(int k = 0; k<size; k++){
                    tmp[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return tmp;
    }

    public static int[][] mulArr(int[][] A, int[][] B, int size){
        int[][] C = new int[size][size];

        if(size <= threshold){
            return C = loopMul(A, B, size);
        }

        int newSize = size/2;

        int[][] a11 = subArray(A, 0, 0, newSize);
        int[][] a12 = subArray(A, 0, newSize, newSize);
        int[][] a21 = subArray(A, newSize, 0, newSize);
        int[][] a22 = subArray(A, newSize, newSize, newSize);

        int[][] b11 = subArray(B, 0, 0, newSize);
        int[][] b12 = subArray(B, 0, newSize, newSize);
        int[][] b21 = subArray(B, newSize, 0, newSize);
        int[][] b22 = subArray(B, newSize, newSize, newSize);



        int[][] m1 = mulArr(add(a11,a22,newSize),add(b11,b22,newSize),newSize);
        int[][] m2 = mulArr(add(a21,a22,newSize),b11,newSize);
        int[][] m3 = mulArr(a11,sub(b12,b22,newSize),newSize);
        int[][] m4 = mulArr(a22,sub(b21,b11,newSize),newSize);
        int[][] m5 = mulArr(add(a11,a12,newSize),b22,newSize);
        int[][] m6 = mulArr(sub(a21,a11,newSize),add(b11,b12,newSize),newSize);
        int[][] m7 = mulArr(sub(a12,a22,newSize),add(b21,b22,newSize),newSize);

        int[][] c11 = add(sub(add(m1,m4,newSize),m5,newSize),m7,newSize);
        int[][] c12 = add(m3,m5,newSize);
        int[][] c21 = add(m2,m4,newSize);
        int[][] c22 = add(add(sub(m1,m2,newSize),m3,newSize),m6,newSize);

        merge(c11, C, 0, 0, newSize);
        merge(c12, C, 0, newSize, newSize);
        merge(c21, C, newSize, 0, newSize);
        merge(c22, C, newSize, newSize, newSize);

        return C;

    }

    public static int[][] subArray(int[][] org, int r, int c, int size){
        int[][] new_array = new int[size][size];
        for(int new_i = 0, org_i = r; new_i < size; new_i++, org_i++){
            for(int new_j = 0, org_j = c; new_j < size; new_j++, org_j++){
                new_array[new_i][new_j] = org[org_i][org_j];
            }
        }
        return new_array;
    }

    public static int[][] add(int[][] A, int[][] B, int size){
        int[][] C = new int[size][size];

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] sub(int[][] A, int[][] B, int size){
        int[][] C = new int[size][size];

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static void merge(int[][] A, int[][] B, int r, int c, int size){
        for(int a_i = 0, b_i = r; a_i<size; a_i++, b_i++){
            for(int a_j = 0, b_j =c; a_j<size; a_j++, b_j++){
                B[b_i][b_j] = A[a_i][a_j];
            }
        }
    }
}
