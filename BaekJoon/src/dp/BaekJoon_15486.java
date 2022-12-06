package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_15486, 퇴사 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_15486 {
    static int N;
    static int[][] meetings;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        meetings = new int[N][2];
        dp = new int[N + 1];
        int max = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            max = Math.max(dp[i], max);
            
            if (i + day  > N) continue;
            if (max + price > dp[i + day]) {
                dp[i + day] = max + price;
            }
        }
        max = Math.max(max, dp[N]);
        
        System.out.println(max);
    }

}
