package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_12841, 정보대 등산
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_12841 {
    static int N;
    static long[] cross, left, right;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        cross = new long[N];
        for (int i=0; i<N; i++) {
            cross[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        left = new long[N];
        for (int i=1; i<N; i++) {
            left[i] = (long)Integer.parseInt(st.nextToken()) + left[i - 1];
        }
        
        st = new StringTokenizer(br.readLine());
        right = new long[N];
        for (int i=1; i<N; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new long[N][2];
        dp[0][0] = cross[0];
        dp[0][1] = 1;
        for (int i=1; i<N; i++) {
            if (left[i] + cross[i] < dp[i - 1][0] + right[i]) {
                dp[i][0] = left[i] + cross[i];
                dp[i][1] = i + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + right[i];
                dp[i][1] = dp[i - 1][1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(dp[N - 1][1]).append(" ").append(dp[N - 1][0]);
        System.out.println(sb);
    }

}
