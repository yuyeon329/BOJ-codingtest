package boj_14002;
//https://loosie.tistory.com/388
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        int[] dp = new int[N];

        int lis = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<i; j++){
                //lis의 갱신가능한 지. 더 긴 lis를 찾을 수 있는지.. 해당 순서의 원소 앞부분을 탐색하면서 현재 기준인 원소보다 작고 lis의 길이가 더 길어질 수 있는걸 찾기.
                //=을 포함 하는 건, 뭐 같은거면 시작된 뿌리는 달라도 길이는 같으므로 퉁 쳐주기 때문
                if(arr[j]<arr[i] && dp[i]<=dp[j]){ //dp[i]>dp[j]라는 건 갱신 안해도 더 긴 lis이므로 갱신 안해도 됨.
                    dp[i] = dp[j]; //일단 안쪽 for문을 돌면서 더 길게 가져갈 수 있는 부분 수열이 나올 수도 있으니 침만 발라놓음
                }
            }
            dp[i] += 1; //침만 발라뒀던 부분 수열 길이 최종 갱신
            lis = Math.max(dp[i],lis);// !!!!!!!!!dp[N-1]은 LIS가 아님!!!!! 그냥 dp[N-1]까지 탐색했을 때 나온 LIS임. 배열 전체에서 MAX를 찾아야함.
        }


        StringBuilder sb = new StringBuilder();
        sb.append(lis).append("\n");

        //역추적
        //last in first out 구조의 스택을 이용
        Stack<Integer> track = new Stack<>();

        //뒤에서부터 거꾸로 넣어줌
        for(int i = N-1; i>-1; i--){
            //lis길이를 순번처럼 생각해서 역순으로 추적
            if(dp[i] == lis){
                track.push(arr[i]);
                lis--;
            }
        }

        //stack.pop() 해주면 arr input 순서대로 출력 가능!
        while(!track.isEmpty()){
            sb.append(track.pop()).append(" ");
        }

        System.out.println(sb);

    }
}
