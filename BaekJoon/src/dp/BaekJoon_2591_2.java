package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BaekJoon_2591, 숫자카드 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. dp 풀이 
 *
 */
public class BaekJoon_2591_2 {
    static String input;
    static int len;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine();
        len = input.length();
        
        dp = new int[len];
        dp[0] = 1;
        for (int i=1; i<len; i++) {
            int prev = input.charAt(i - 1) - '0';
            int curr = input.charAt(i) - '0';
            
            if (i < len - 1) {
                int next = input.charAt(i + 1) - '0';
                dp[i] = dp[i - 1];
                if (prev == 0 || curr == 0 || next == 0) continue;
                if (prev < 3 || (prev == 3 && curr <= 4)) {
                    if (i > 1) dp[i] += dp[i - 2];
                    else dp[i]++;
                }
                
            } else {
                dp[i] = dp[i - 1];
                if (prev == 0 || curr == 0) continue;
                if (prev < 3 || (prev == 3 && curr <= 4)) {
                    if (i > 1) dp[i] += dp[i - 2];
                    else dp[i]++;
                }
            }
        }
        
        System.out.println(dp[len - 1]);
    }

}
