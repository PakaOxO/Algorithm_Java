package level_03;

import java.io.*;
import java.util.*;

/**
 * SWEA_5215, 햄버거 다이어트
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. DP로 재 풀이, knapsack 문제와 같은 문제
 * 	2. 해당 풀이에 대한 설명은 knapsack 문제에 서술
 * 
 *
 */
public class SWEA_5215 {
	static int N, L;
	static int[][] g;
	static int[][] dp;
	
	static void dp() {
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=L; j++) {
				if (j < g[i][1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - g[i][1]] + g[i][0]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			g = new int[N + 1][2];
			dp = new int[N + 1][L+1];
			
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				g[i][0] = Integer.parseInt(st.nextToken());
				g[i][1] = Integer.parseInt(st.nextToken());
			}

			dp();
			sb.append(String.format("#%d %d\n", tc, dp[N][L]));
		}
		br.close();
		System.out.print(sb);
	}

}
