package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1231, 주식왕 동호 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *  1. 
 *
 */
public class BaekJoon_1231 {
    static int C, D, M;
    static int[][] graph, dp;
    static int[][][] stocks;
    static int[] max;
    
    static void knapsack(int d, int m) {
        if (m > 50000) {
            dp = new int[C][50001];
            for (int i=0; i<C; i++) {
                for (int j=0; j<50001; j++) {
                    if (i == 0) {
                        if (j >= stocks[0][d][0]) dp[0][j] = dp[0][j - stocks[0][d][0]] + stocks[0][d][1];
                        continue;
                    }
                    
                    if (j >= stocks[i][d][0]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stocks[i][d][0]] + stocks[i][d][1]);
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - stocks[i][d][0]] + stocks[i][d][1]);
                    }
                    else dp[i][j] = dp[i - 1][j];
                }
            }
            max[d] = dp[C - 1][50000] + m;

        } else {
            dp = new int[C][m + 1];
            for (int i=0; i<C; i++) {
                for (int j=0; j<m+1; j++) {
                    if (i == 0) {
                        if (j >= stocks[0][d][0]) dp[0][j] = dp[0][j - stocks[0][d][0]] + stocks[0][d][1];
                        continue;
                    }
                    
                    if (j >= stocks[i][d][0]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stocks[i][d][0]] + stocks[i][d][1]);
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - stocks[i][d][0]] + stocks[i][d][1]);
                    }
                    else dp[i][j] = dp[i - 1][j];
                }
            }
            max[d] = dp[C - 1][m] + m;
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[C][D];
        for (int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<D; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        max = new int[D];
        max[0] = M;
        
        stocks = new int[C][D][2];
        for (int i=0; i<C; i++) {
            for (int j=1; j<D; j++) {
                stocks[i][j][0] = graph[i][j - 1];
                stocks[i][j][1] = graph[i][j] - graph[i][j - 1];
            }
        }
        
        for (int d=1; d<D; d++) {
            knapsack(d, max[d - 1]);
        }
        
        System.out.println(max[D - 1]);
    }

}
