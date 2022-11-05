package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_9251, LCS
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. LCS(Longest Common Subsequence) 원리를 공부하고 재풀이 
 *
 */
public class BaekJoon_9251 {
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        br.close();
        
        int N = str1.length();
        int M = str2.length();
        dp = new int[N + 1][M + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (dp[i][j - 1] == i) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        
        System.out.println(dp[N][M]);
    }

}
