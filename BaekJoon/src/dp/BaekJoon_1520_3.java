package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1520, 내리막길 (DFS 풀이)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_1520_3 {
	static int N, M, cnt;
	static int[][] map, dp;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void dfs(int r, int c) {
		if (r == N - 1 && c == M - 1) {
			cnt++;
		}
		
		for (int i=0; i<4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] >= map[r][c]) continue;
			dp[nr][nc]++;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		dp = new int[N][M];
		dfs(0, 0);
		for (int[] d : dp) System.out.println(Arrays.toString(d));
	}

}
