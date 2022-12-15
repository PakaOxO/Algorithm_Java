package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_1256, 사전
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1256 {
    static int N, M, K;
    static int INF = 1000000000;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        dp = new long[N + 1][M + 1];
        dp[1][0] = dp[0][1] = 1;
        
        for (int i=1; i<=N; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=M; j++) {
                dp[0][j] = 1;
                dp[i][j] = dp[i][j - 1] * (i + j) / j;
                if (dp[i][j] > INF) dp[i][j] = INF;
            }
        }
        
        int aCnt = N;
        int bCnt = M;
        if (dp[N][M] < K) {
            sb.append(-1);
        } else {
            for (int i=(N + M); i>0; i--) {
                if (aCnt == 0) {
                    sb.append('z');
                    continue;
                }
                if (bCnt == 0) {
                    sb.append('a');
                    continue;
                }
                
                if (K <= dp[aCnt - 1][bCnt]) {
                    sb.append('a');
                    aCnt--;
                } else {
                    sb.append('z');
                    K -= dp[aCnt - 1][bCnt];
                    bCnt--;
                }
            }
        }
        System.out.println(sb);
    }

}
