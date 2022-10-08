package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_12865, 평범한 배낭 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. knapsack 문제랑 동일한 문제 
 * 	2. dp로 풀이 
 *
 */
public class BaekJoon_12865 {
	static int N, K;
	static int[][] items,dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		items = new int[N + 1][2];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		dp = new int[N + 1][K + 1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				if (j < items[i][0]) dp[i][j] = dp[i - 1][j];
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
			}
		}
		System.out.println(dp[N][K]);
	}

}
