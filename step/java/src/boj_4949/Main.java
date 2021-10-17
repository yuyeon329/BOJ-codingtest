package boj_4949;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            ArrayList<Character> mystack = new ArrayList<>();
            String tmp = sc.nextLine();

            if(tmp.equals(".")){
                break;
            }

            for (int j = 0; j < tmp.length(); j++) {
                char str1 = tmp.charAt(j);
                if (str1 == '(' || str1 == '[') {
                    mystack.add(str1);
                } else {
                    if (str1 == ')') {
                        if (!mystack.isEmpty() && mystack.get(mystack.size() - 1) == '(') {
                            mystack.remove(mystack.size() - 1);
                        } else {
                            mystack.add(str1);
                        }
                    }
                    if (str1 == ']'){
                        if (!mystack.isEmpty() && mystack.get(mystack.size() - 1) == '[') {
                            mystack.remove(mystack.size() - 1);
                        } else {
                            mystack.add(str1);
                        }
                    }
                }
            }
            if (mystack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
