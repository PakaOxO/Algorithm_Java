package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2193 {
    static int N;
    static long[][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(sb.readLine());
        dp = new long[N][2];
        
        dp[0][1] = 1;
        
        for (int i=1; i<N; i++) {
            dp[i][0] += dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] += dp[i - 1][0];
        }
        
        System.out.println(dp[N - 1][0] + dp[N - 1][1]);
    }
}
