package boj_9012;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            ArrayList<Character> mystack = new ArrayList<>();
            String tmp = sc.next();
            for(int j = 0; j<tmp.length();j++){
                char str1 = tmp.charAt(j);
                if(str1 == '('){
                    mystack.add(str1);
                }
                else{
                    if (!mystack.isEmpty() && mystack.get(mystack.size()-1)=='('){
                        mystack.remove(mystack.size()-1);
                    }
                    else {
                        mystack.add(str1);
                    }
                }
            }
            if (mystack.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
