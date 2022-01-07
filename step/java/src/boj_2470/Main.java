package boj_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//절댓값이 키 포인트다!
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static ArrayList<Integer> arr;
    private static long difference = 2000000000L;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int solution = Integer.parseInt(st.nextToken());
            arr.add(solution);
        }
        Collections.sort(arr);
        makeZero();

    }
    public static void makeZero(){
        int start = 0;//왼쪽에서 시작하는 포인터
        int end = arr.size()-1;//우측에서 시작하는 포인터
        int s1 = 0;
        int s2 = 0;

        while(start<end){//start가 end보다 작을 동안,
            int tmp = arr.get(start)+arr.get(end); //우선 두 포인터가 가리키는 두 용액을 섞어 만든 특성값을 구한다.

            if(Math.abs(tmp)<difference){//특성값의 절댓값을 구해주는데, (이때 difference = 2000000000L;은 최초의 비교를 위해 선언됨.)
                // 만약 이번에 구한 특성값의 절댓값이 직전에 계산한 특성값의 절댓값보다 작다면, !!!!!!!0에 가까워졌다는 뜻이므로!!!!!
                s1 = arr.get(start); //용액을 새로 갱신한다
                s2 = arr.get(end); //용액을 새로 갱신한다.
                difference = Math.abs(tmp); //특성값의 절댓값도 갱신해준다.
            }

            //tmp가 0에 가까워지기 위한 노력..
            if(tmp>0) //만약 특성값이 0보다 크다면 값을 줄이기 위해 end를 갱신
                end-=1;
            else //특성값이 0보다 작다면 값을 늘리기 위해 start를 갱신
                start+=1;
        }
        System.out.printf("%d %d", s1, s2);
    }
}
