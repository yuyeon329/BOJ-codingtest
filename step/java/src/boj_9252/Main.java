package boj_9252;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();

        String str2 = sc.next();

        int[][] arr = new int[str2.length()+1][str1.length()+1];
        int cnt = 0;
        for(int i = 0; i<=str2.length(); i++){
            for(int j = 0; j<=str1.length(); j++){
                if(i==0 || j ==0)
                    continue;
                else{
                    if(str2.charAt(i-1) == str1.charAt(j-1)){
                        arr[i][j] = arr[i-1][j-1]+1;
                        if(cnt<arr[i][j]){
                            cnt = arr[i][j];
                        }
                    }
                    else {
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                    }
                }
            }
        }
        int i = str2.length();
        int j = str1.length();
        Stack<Character> stack = new Stack<>();
        while(i>=1 && j>=1){
            if(arr[i][j] == arr[i-1][j])
                i--;
            else if(arr[i][j] == arr[i][j-1])
                j--;
            else {
                stack.push(str2.charAt(i - 1));
                j--;
            }
        }
        System.out.println(cnt);
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}

