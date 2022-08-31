package dfs;

import java.io.*;
import java.util.*;

// 무기 공학
public class BaekJoon_18430 {
	static int N, M;
	static int[][] block;
	static boolean[][] isUsed;
	static int[][][] drc = { {{1, 0}, {0, 1}}, {{0, -1}, {1, 0}}, {{-1, 0}, {0, 1}}, {{0, -1}, {-1, 0}}};
	static int max;
	
	static void dfs(int r, int c, int sum) {
		if (c == M) {
			c = 0;
			r++;
		}
		if (r == N) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (isUsed[r][c]) break;
			
			int dr = drc[i][0][0];
			int dc = drc[i][0][1];
			if (r + dr < 0 || r + dr >= N || c + dc < 0 || c + dc >= M || isUsed[r + dr][c + dc]) continue;
			int dr2 = drc[i][1][0];
			int dc2 = drc[i][1][1];
			if (r + dr2 < 0 || r + dr2 >= N || c + dc2 < 0 || c + dc2 >= M || isUsed[r + dr2][c + dc2]) continue;
			isUsed[r][c] = true;
			isUsed[r + dr][c + dc] = true;
			isUsed[r + dr2][c + dc2] = true;
			dfs(r, c + 1, sum + (block[r][c] * 2) + block[r + dr][c + dc] + block[r + dr2][c + dc2]);
			isUsed[r][c] = false;
			isUsed[r + dr][c + dc] = false;
			isUsed[r + dr2][c + dc2] = false;
		}
		dfs(r, c + 1, sum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		block = new int[N][M];
		isUsed = new boolean[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(max);
		br.close();
	}

}
