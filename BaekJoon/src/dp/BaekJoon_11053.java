package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11053, 가장 긴 증가하는 부분 수열
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_11053 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[N + 1];
        dp = new int[N + 1];
        int answer = 0;
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j=1; j<i; j++) {
                if (arr[j] < arr[i] && dp[j] > dp[max]) {
                    max = j;
                }
            }
            dp[i] = dp[max] + 1;
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }

}
