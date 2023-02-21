package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_3067, Coins
 * @Author kevin-Arpe
 *
 * Sketch Idea
 *  1. 냅색 문제
 *
 */
public class BaekJoon_3067 {
    static int T, N, M;
    static int[] dp, coins;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            // 동전 개수 입력
            N = Integer.parseInt(br.readLine());
            coins = new int[N + 1];

            // 동전 종류 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            
            // 목표 금액 입력
            M = Integer.parseInt(br.readLine());
            dp = new int[M + 1];

            // 냅색 로직
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=M; j++) {
                    if (j < coins[i]) {
                        continue;
                    } else if (j == coins[i]) {
                        dp[j] = dp[j] + 1;
                    } else {
                        dp[j] += dp[j - coins[i]];
                    }
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}