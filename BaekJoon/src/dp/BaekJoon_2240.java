package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BaekJoon_2240, 자두나무 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_2240 {
    static int T, W;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        dp = new int[T + 1][W + 1];
        int prev = 1;
        for (int i=1; i<=T; i++) {
            int tree = Integer.parseInt(br.readLine());
            for (int j=0; j<=W; j++) {
                if (j > i) break;
                // 현재 위치와 자두가 떨어지는 나무의 위치가 같은지 체크 
                if (tree % 2 == (j + 1) % 2) { // 위치가 같을 때 
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1 , dp[i - 1][j - 1] + 1);
                    }
                } else { // 위치가 다를 때 
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - 1]);
                    }
                }
            }
        }
        int answer = 0;
        for (int i=0; i<=W; i++) {
            answer = Math.max(answer, dp[T][i]);
        }
        System.out.println(answer);
    }

}
