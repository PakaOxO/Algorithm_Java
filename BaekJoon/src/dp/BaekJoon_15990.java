package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15990, 1,2,3 더하기 5 
 * @author arpe
 *
 */
public class BaekJoon_15990 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1][4];
            
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=3; j++) {
                    if (i == j) dp[i][j]++;
                    for (int k=1; k<=3; k++) {
                        if (k == j) continue;
                        if (i >= j) dp[i][j] = (dp[i][j] + dp[i - j][k]) % 1000000009;
                    }
                }
            }
            
            int answer = (dp[N][1] + dp[N][2]) % 1000000009;
            answer = (answer + dp[N][3]) % 1000000009;
            sb.append(answer).append("\n");
        }
        br.close();
        System.out.println(sb.toString().trim());
    }

}
