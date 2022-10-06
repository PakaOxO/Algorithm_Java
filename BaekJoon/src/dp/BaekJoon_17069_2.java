package dp;

import java.io.*;
import java.util.*;

public class BaekJoon_17069_2 {
	static int N;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][][] dp;
	
	static int[] dp(int r, int c) {
		if (map[r][c] == 1) return new int[] { 0, 0, 0 };
		if (isVisited[r][c]) return dp[r][c];
		
		// 대각선
		if (r - 1 >= 0 && c - 1 >= 1 && map[r - 1][c] != 1 && map[r][c - 1] != 1) {
			int[] prev = dp(r - 1, c - 1);
			dp[r][c][0] = prev[0] + prev[1] + prev[2];
			isVisited[r - 1][c - 1] = true;
		}
		// 가로
		if (c - 1 >= 1) {
			int[] prev = dp(r, c - 1);
			dp[r][c][1] = prev[0] + prev[1];
			isVisited[r][c - 1] = true;
		}
		// 세로
		if (r - 1 >= 0) {
			int[] prev = dp(r - 1, c);
			dp[r][c][2] = prev[0] + prev[2];
			isVisited[r - 1][c] = true;
		}
		
		return dp[r][c];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isVisited = new boolean[N][N];
		dp = new int[N][N][3];
		dp[0][1][1] = 1;
		dp(N - 1, N - 1);
		
		long answer = 0;
		for (int i=0; i<3; i++) {
			answer += dp[N - 1][N - 1][i];
		}
		System.out.println(answer);
	}

}
