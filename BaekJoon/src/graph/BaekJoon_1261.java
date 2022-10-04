package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1261, 알고스팟
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 목적지까지 최소한으로 벽을 부수고 가는 경우를 묻는 문제이므로 벽을 부수는 것을 가중치 1, 부수지 않는것을 0으로 본다면
 * 		다익스트라를 사용해 문제 풀이 가능
 *
 */
public class BaekJoon_1261 {
	static class Pos implements Comparable<Pos> {
		int r, c, cnt;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cnt - o.cnt;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M, min;
	static int[][] map;
	static boolean isVisited[][];
	static int[][] dist;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void dijkstra() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0, 0, 0));
		dist[0][0] = 0;
		
		while(pq.size() > 0) {
			Pos curr = pq.poll();
			if (isVisited[curr.r][curr.c]) continue;
			isVisited[curr.r][curr.c] = true;
			
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc]) continue;
				
				if (dist[nr][nc] <= curr.cnt + map[nr][nc]) continue;
				dist[nr][nc] = curr.cnt + map[nr][nc];
				
				if (nr == N - 1 && nc == M - 1) return;
				pq.offer(new Pos(nr, nc, dist[nr][nc]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		isVisited = new boolean[N][M];
		for (int[] v : dist) Arrays.fill(v, INF);
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = (int)(input.charAt(j) - '0');
			}
		}
		br.close();
		
		min = Integer.MAX_VALUE;
		dijkstra();
		System.out.println(dist[N-1][M-1]);
	}

}
