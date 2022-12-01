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
        
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 1;
        for (int i=1; i<N; i++) {
            int idx = 0;
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[i] && dp[j] > dp[idx]) {
                    idx = j;
                }
            }
            dp[i] = dp[idx] + 1;
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }

}
