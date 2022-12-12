package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2073, 수도배관공사
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2073 {
    static int D, P;
    static long answer;
    static int[][] pipe;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        pipe = new int[P + 1][2];
        for (int i=1; i<=P; i++) {
            st = new StringTokenizer(br.readLine());
            pipe[i][0] = Integer.parseInt(st.nextToken());
            pipe[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dp = new long[D + 1];
        for (int i=1; i<=P; i++) {
            int len = pipe[i][0];
            int cap = pipe[i][1];
            
            if (len > D) continue;
            
            for (int j=D; j>=len+1; j--) {
                if (dp[j - len] > 0) {
                    dp[j] = Math.min(dp[j - len], cap);
                }
            }
            
            if (dp[len] > 0) dp[len] = Math.min(dp[len], cap);
            else dp[len] = cap;
            
            if (dp[D] > 0) {
                dp[D] = Math.max(dp[D], cap);
            }
            answer = Math.max(dp[D], answer);
        }
        
        System.out.println(answer);
    }

}
