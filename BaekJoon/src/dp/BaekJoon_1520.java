package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1520, 내리막길
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_1520 {
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void getPath() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2] - o1[2];
			}
			
		});
		pq.offer(new int[] { 0, 0, map[0][0] });
		dp[0][0] = 1;
		isVisited = new boolean[N][M];
		isVisited[0][0] = true;
		
		while (pq.size() > 0) {
			int[] curr = pq.poll();
			
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] >= map[curr[0]][curr[1]]) continue;
				dp[nr][nc] += dp[curr[0]][curr[1]];
				pq.offer(new int[] { nr, nc, map[nr][nc] });
			}
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
		
		dp = new int[N][M];
		getPath();
		for (int[] d : dp) System.out.println(Arrays.toString(d));
		System.out.println(dp[N - 1][M - 1]);
	}

}
