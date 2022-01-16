package boj_14003;
//https://loosie.tistory.com/389?category=982577
//https://snupi.tistory.com/71

// ***input의 크기가 dp O(N2)로 풀이하기에 너무 클 경우, 이진탐색 O(nlogn)을 이용하는 방법***
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //arr[i]의 lis 길이
        int[] dp = new int[N];

        //lislen에 따른 lis 수열 원소 값 저장. lis[lisLen] = 0~i의 원소 배열 중 lis의 길이가 lisLen인 부분 수열의 마지막 값이 될 수 있는 값 중 최솟값
        lis = new int[N+1];

        int lisLen = 0;

        int lisIdx = 0;

        lis[0] = -1000000001;

        ///
        for(int i = 0; i<N; i++){
            //list[0]이 입력 데이터의 최솟값보다 작아야 첫번쨰 if(arr[i]>lis[lisLen]) 비교가 가능함
            //증가하는 lis찾기
            if(arr[i]>lis[lisLen]) {
                dp[i] = ++lisLen;
                lis[lisLen] = arr[i];
            }
            else {//arr[i]가 증가하는 부분수열에 계속 추가할 수 없으면, lis배열의 알맞은 자리를 찾기 위해 이진탐색 진행. 자리에 넣어주고, arr[i]가 가질 수 있는 가장 긴 증가하는 lis의 길이를 갱신
                lisIdx = binarySearch(0, lisLen, arr[i]);
                lis[lisIdx] = arr[i];
                dp[i] = lisIdx;
            }
        }
        ///

        StringBuilder sb = new StringBuilder();

        //가장 긴 증가하는 부분 수열의 길이 출력
        sb.append(lisLen).append("\n");


        Stack<Integer> tracking = new Stack<>();

        //lis[lisLen] = arr[i];에 의해 lisLen을 이용해 lis배열의 값을 tracking stack에 넣어주면 됨
        for(int i = N-1; i>-1; i--){
            if(dp[i]==lisLen){
                tracking.push(arr[i]);
                lisLen--;
            }
        }

        while(!tracking.isEmpty()){
            sb.append(tracking.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static int binarySearch(int l, int r, int v){
        int m = 0;
        while(l<r){
            m = (l+r)/2;
            if(lis[m]<v){
                l = m+1;
            }else{
                r = m;
            }
        }
        return r;
    }
}
