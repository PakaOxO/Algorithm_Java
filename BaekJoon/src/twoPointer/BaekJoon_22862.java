package twoPointer;

import java.io.*;
import java.util.*;

public class BaekJoon_22862 {
    static int N, K;
    static int[] arr;
    static int answer = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투 포인터 로직
        int left = 0;
        int right = 0;
        int count = 0;
        
        while (right < N) {
            if (arr[right] % 2 > 0) count++;
            while (left < right && count > K) {
                if (arr[left] % 2 > 0) count--;
                left++;
            }
            
            answer = Math.max(answer, right - left - count + 1);
            right++;
        }
        
        System.out.println(answer);
    }

}
