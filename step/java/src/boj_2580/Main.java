package boj_2580;

import java.util.Scanner;

public class Main {
    public static int[][] sudoku = new int[9][9];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i<9;i++){
            for(int j = 0; j<9;j++){
                sudoku[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);

    }
    public static boolean isavailable(int current_Row, int current_Col, int item){
        for(int j = 0; j<9;j++){
            if(sudoku[current_Row][j]==item){
                return false;
            }
        }

        for(int i = 0; i<9;i++){
            if(sudoku[i][current_Col]==item){
                return false;
            }
        }

        int small_row = (current_Row/3)*3;
        int small_col = (current_Col/3)*3;

        for(int i = small_row; i<small_row+3;i++){
            for(int j = small_col;j<small_col+3;j++){
                if(sudoku[i][j]==item){
                    return false;
                }
            }
        }
        return true;
    }

    public static void dfs(int current_Row, int current_Col){
        if(current_Row==9){
            for(int i = 0; i<9;i++){
                for(int j = 0; j<9;j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);

        }
        if(current_Col==9){
            dfs(current_Row+1, 0);
            return;
        }

        if(sudoku[current_Row][current_Col]==0){
            for(int i = 1; i<10;i++){
                if(isavailable(current_Row,current_Col,i)){
                    sudoku[current_Row][current_Col]=i;
                    dfs(current_Row, current_Col+1);
                }
            }
            sudoku[current_Row][current_Col]=0;
            return;
        }
        dfs(current_Row, current_Col+1);
    }

}
