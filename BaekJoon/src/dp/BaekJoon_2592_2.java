package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BaekJoon_2591, 숫자카드 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. dp 풀이도 있음 
 *
 */
public class BaekJoon_2592_2 {
    static String input;
    static int len;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine();
        len = input.length();
        
        dp = new int[len];
        for (int i=1; i<len; i++) {
            int prev = input.charAt(i - 1) - '0';
            
            dp[i] += dp[i - 1];
            if (prev > 0) {
                
            }
        }
        
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[len]);
    }

}
