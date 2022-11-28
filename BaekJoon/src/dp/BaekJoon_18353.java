package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_18353, 병사 배치하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_18353 {
    static int[] arr, dp;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 0;
        max = 0;
        for (int i=1; i<N; i++) {
            int maxIdx = 0;
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[i] && dp[j] >= dp[i]) {
                    maxIdx = j;
                    dp[i] = dp[j] + 1;
                }
            }
            dp[i] = dp[maxIdx] + 1;
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(N - max - 1);
    }

}
