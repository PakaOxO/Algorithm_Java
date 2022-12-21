package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14722, 우유 도시
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 이전 우유의 종류를 기억해야 하는 dp 문제
 *  2. dp를 3차원 배열로 만들어 위치 + 이전 우유의 종류(3가지)에 대한 dp를 계산
 *
 */
public class BaekJoon_14722 {
    static int N, answer;
    static int[][] map;
    static int[][][] dp;
    
    static int dp(int r, int c, int target) {
        if (r == N || c == N) return 0;
        
        int[] d = dp[r][c];
        
        if (d[target] == 0) {
            if (map[r][c] != target) {
                d[target] = Math.max(dp(r + 1, c, target), dp(r, c + 1, target));
            } else {
                d[target] = Math.max(dp(r + 1, c, (target + 1) % 3) + 1, dp(r, c + 1, (target + 1) % 3) + 1);
            }
            dp[r][c][target] = d[target];
        }
        return dp[r][c][target];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[N][N][3];
        System.out.println(dp(0, 0, 0));
    }

}
