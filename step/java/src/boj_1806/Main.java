package boj_1806;
//바보다 "연속된 부분합"인데 자꾸 두 포인터가 가리키는 지점의 합으로 생각해서 틀림
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//https://blog.crazzero.com/m/28
public class Main {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N; //수열 길이
    private static int S; //요구되는 합
    private static int answer = 100000;
    private static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr.add(tmp);
        }

        //연속된 수들의 부분합을 구하는 것이므로 sort하면 안됨
        subtotal();

        if(answer != 100000){
            System.out.println(answer);
        }else{
            System.out.println(0);
        }

    }
    public static void subtotal(){
        int start = 0;
        int end = 0;
        int sum = 0;
        while(true){
            if(sum>=S) {//이상 조건이 먼저 와야 전체 부분합이 정답일 때도 가능
                sum -= arr.get(start++);
                answer = Math.min(answer, end - start + 1);
            }else if(end==N){
                break;
            }
            else {
                sum += arr.get(end++);
            }
        }
    }
}
