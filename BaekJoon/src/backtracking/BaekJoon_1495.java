package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1495, 기타리스트 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1495 {
    static int N, S, M, answer;
    static boolean[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        boolean flag = false;
        for (int i=1; i<=N; i++) {
            int vol = Integer.parseInt(st.nextToken());
            for (int j=0; j<=M; j++) {
                if (!dp[i - 1][j]) continue;
                if (j - vol >= 0) {
                    dp[i][j - vol] = true;
                    if (i == N) {
                        flag = true;
                        answer = Math.max(answer, j - vol);
                    }
                }
                if (j + vol <= M) {
                    dp[i][j + vol] = true;
                    if (i == N) {
                        flag = true;
                        answer = Math.max(answer,  j + vol);
                    }
                }
            }
        }
        
        if (!flag) answer = -1;
        System.out.println(answer);
    }

}
