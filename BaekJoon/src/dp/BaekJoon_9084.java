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
    static int[] dp;
    
    static void dp() {
        dp[0] = 1;
        for (int i=1; i<=N; i++) {
            for (int j=coin[i]; j<=M; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            
            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];
            
            dp();
            sb.append(String.format("%d\n", dp[M]));
        }
        br.close();
        System.out.print(sb);
    }

}
