package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1234, 크리스마스 트리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1234 {
    static int N, R, G, B;
    static long[][][] dp;
    static int[] F;
    
    static long dp(int n, int r, int g, int b) {
        if (n == 0) {
            dp[n][r][g] = 1;
            return dp[n][r][g];
        }
        
        if (dp[n][r][g] > 0) {
            return dp[n][r][g];
        }
        
        if (n % 3 == 0) {
            int cnt = n / 3;
            if (r >= cnt && g >= cnt && b >= cnt) {
                dp[n][r][g] += F[n] / ((long)Math.pow(F[cnt], 3)) * dp(n - 1, r - cnt, g - cnt, b - cnt);
            }
        }
        
        if (n % 2 == 0) {
            int cnt = n / 2;
            if (r >= cnt && g >= cnt) {
                dp[n][r][g] += F[n] / ((long)Math.pow(F[cnt], 2)) * dp(n - 1, r - cnt, g - cnt, b);
            }
            if (r >= cnt && b >= cnt) {
                dp[n][r][g] += F[n] / ((long)Math.pow(F[cnt], 2)) * dp(n - 1, r - cnt, g, b - cnt);
            }
            if (g >= cnt && b >= cnt) {
                dp[n][r][g] += F[n] / ((long)Math.pow(F[cnt], 2)) * dp(n - 1, r, g - cnt, b - cnt);
            }
        }
        
        if (r >= n) {
            dp[n][r][g] += dp(n - 1, r - n, g, b);
        }
        if (g >= n) {
            dp[n][r][g] += dp(n - 1, r, g - n, b);
        }
        if (b >= n) {
            dp[n][r][g] += dp(n - 1, r, g, b - n);
        }
        
        return dp[n][r][g];
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        if (R > 55) R = 55;
        if (G > 55) G = 55;
        if (B > 55) B = 55;
        
        F = new int[N + 1];
        F[0] = 1;
        for (int i=1; i<=N; i++) F[i] = F[i - 1] * i;
        
        dp = new long[N + 1][R + 1][G + 1];
        dp(N, R, G, B);
        
        System.out.println(dp[N][R][G]);
    }

}
