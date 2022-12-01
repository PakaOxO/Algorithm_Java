package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_11722, 가장 긴 감소하는 부분 수열 
 * @author kevin-Arpe
 * 
 * Sketch Idea 
 *  1. 
 *
 */
public class BaekJoon_11722 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 1;
        arr[0] = 1001;
        dp[0] = 0;
        for (int i=1; i<=N; i++) {
            int idx = 0;
            boolean flag = false;
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[i] && dp[j] > dp[idx]) {
                    idx = j;
                    flag = true;
                }
            }
            if (flag) {
                dp[i] = dp[idx] + 1;
            } else {
                dp[i] = 1;
            }
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }

}
