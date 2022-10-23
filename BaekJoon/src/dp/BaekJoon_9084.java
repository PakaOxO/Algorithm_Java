package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9084, 동전 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 이전 금액을 만드는 최대 개수를 저장한 dp 배열을 사용해 현재 금액을 만드는데 필요한 동전의 최대 개수를 구할 수 있지 않을까?
 *  2. 이전 금액을 탐색해야 하므로 N^2 복잡도? 
 *
 */
public class BaekJoon_9084 {
    static int N, M;
    static int[] coin;
    static int[][] dp;
    
    static void dp() {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j % coin[i] == 0) {
                    dp[i][j] += 1;
                }
                if (j >= coin[i]) dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j - coin[i]], dp[i][j - coin[i - 1]]));
                if (j >= coin[i]) dp[i][j] += dp[i - 1][j - coin[i]] / coin[i];
                
                if (j % coin[i] == 0) {
                    dp[i][j] += dp[i - 1][j - coin[i]];
                }
            }
        } 
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            
            M = Integer.parseInt(br.readLine());
            dp = new int[N + 1][M + 1];
            
            dp();
            System.out.println(dp[N][M]);
            for (int[] d : dp) System.out.println(Arrays.toString(d));
            System.out.println();
        }
        br.close();
    }

}
