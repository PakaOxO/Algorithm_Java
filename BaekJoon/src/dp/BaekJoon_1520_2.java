package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1520, 내리막길 (BFS 풀이)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */

public class BaekJoon_1520_2 {
	static class Pos {
		int r, c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[][] dp;
	
	static int[][] drc = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0));
		
		while (q.size() > 0) {
			Pos curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] >= map[curr.r][curr.c]) continue;
				
				dp[nr][nc]++;
				q.offer(new Pos(nr, nc));
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
		br.close();
		
		dp = new int[N][M];
		bfs();
		System.out.println(dp[N - 1][M - 1]);
	}

}
