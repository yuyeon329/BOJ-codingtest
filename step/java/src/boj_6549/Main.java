package boj_6549;

import java.util.Scanner;

public class Main {
    public static int[] histogram;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            histogram = new int[n];
            for(int i = 0; i<n; i++){
                histogram[i] = sc.nextInt();
            }
            sb.append(getArea(0, n-1)).append('\n');
            histogram = null;
        }
        System.out.println(sb);
    }

    public static long getArea(int start, int end){
        if(start == end){
            return histogram[start];
        }
        int mid = (start+end)/2;

        long leftArea = getArea(start, mid);
        long rightArea = getArea(mid+1, end);

        long max = Math.max(leftArea, rightArea);
        max = Math.max(max, getMidArea(start,end,mid));

        return max;
    }

    public static long getMidArea(int start, int end, int mid){
        int toStart = mid;
        int toEnd = mid;

        long height = histogram[mid];

        long maxArea = height;

        while(start < toStart && toEnd < end){
            if(histogram[toStart - 1]<histogram[toEnd + 1]){
                toEnd++;
                height = Math.min(height, histogram[toEnd]);
            }
            else{
                toStart--;
                height = Math.min(height, histogram[toStart]);
            }

            maxArea = Math.max(maxArea, height *(toEnd - toStart + 1));
        }

        while(toEnd < end){
            toEnd++;
            height = Math.min(height, histogram[toEnd]);
            maxArea = Math.max(maxArea, height*(toEnd-toStart+1));
        }
        while(start < toStart){
            toStart--;
            height = Math.min(height, histogram[toStart]);
            maxArea = Math.max(maxArea, height * (toEnd - toStart + 1));
        }

        return maxArea;
    }
}
