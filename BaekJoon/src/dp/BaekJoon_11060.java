package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_11060, 
 * @author arpeg
 *
 */
public class BaekJoon_11060 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N];
        Arrays.fill(dp, N + 1);
        dp[0] = 0;
        
        for (int i=0; i<N; i++) {
            int range = Integer.parseInt(st.nextToken());
            for (int j=i+1; j<=i+range; j++) {
                if (j >= N) break;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        
        if (dp[N - 1] > N)
            System.out.println(-1);
        else
            System.out.println(dp[N - 1]);
    }

}
