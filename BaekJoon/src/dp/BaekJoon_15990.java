package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15990, 1,2,3 더하기 5 
 * @author arpe
 *
 */
public class BaekJoon_15990 {
    static int N, max;
    static int[] input;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        input = new int[T];
        
        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            input[tc] = N;
            max = Math.max(max, N);
        }
        br.close();
        
        dp = new int[max + 1][4];
        
        for (int i=1; i<=max; i++) {
            for (int j=1; j<=3; j++) {
                if (i == j) dp[i][j]++;
                for (int k=1; k<=3; k++) {
                    if (k == j) continue;
                    if (i >= j) dp[i][j] = (dp[i][j] + dp[i - j][k]) % 1000000009;
                }
            }
        }
        
        for (int i=0; i<T; i++) {
            int answer = (dp[input[i]][1] + dp[input[i]][2]) % 1000000009;
            answer = (answer + dp[input[i]][3]) % 1000000009;
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

}
