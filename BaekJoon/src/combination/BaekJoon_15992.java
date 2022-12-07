package combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_15992, 1,2,3 더하기 7 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_15992 {
    static int divider = 1000000009;
    static int N, M;
    static int[][] dp;
    
    static int doDp(int n, int m) {
        if (n <= 0 || m == 0) return 0;
        if (dp[n][m] < 0) {
            dp[n][m] = (((doDp(n - 3, m - 1) + doDp(n - 2, m - 1)) % divider) + doDp(n - 1, m - 1)) % divider;
        }
        return dp[n][m];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        dp = new int[1001][1001];
        for (int i=0; i<1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[1][1] = dp[2][1] = dp[3][1] = 1;
        for (int i=3; i<1001; i++) {
            for (int j=1; j<1001; j++) {
                doDp(i, j);
            }
        }
        
        for (int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            if (N == M) {
                sb.append(1).append("\n");
                continue;
            }
            
            int answer = dp[N][M];
            sb.append(answer).append("\n");
        }
        
        System.out.println(sb.toString().trim());
    }

}
