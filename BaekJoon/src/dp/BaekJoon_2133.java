package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_2133, 타일 채우기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2133 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N % 2 == 1) {
            System.out.println(0);
        } else {
            int end = N / 2;
            dp = new int[end + 1];
            dp[0] = 1;
            for (int i=1; i<=end; i++) {
                dp[i] = dp[i - 1] * 3;
                for (int j=2; j<=i; j++) {
                    dp[i] += dp[i - j] * 2;
                }
            }
            System.out.println(dp[end]);
        }
    }
}
