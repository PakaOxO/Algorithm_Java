package twoPointer;

import java.io.*;
import java.util.*;

public class BaekJoon_1806 {
    static int INF = 100000000;
    static int N, S, answer;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        answer = INF + 1;
        
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        
        int left = 0;
        int sum = 0;
        for (int right=0; right<N; right++) {
            arr[right] = Integer.parseInt(st.nextToken());
            sum += arr[right];
            
            if (sum >= S) {
                while (sum >= S) {
                    answer = Math.min(answer, right - left + 1);
                    sum -= arr[left++];
                }
            } else if (sum < S)
                continue;
        }
        
        if (answer > INF) answer = 0;
        System.out.println(answer);
    }

}
