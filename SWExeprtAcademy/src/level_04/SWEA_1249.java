package level_04;

import java.io.*;
import java.util.*;

/**
 * SWEA_1249, 보급로
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Dijkstra로 풀이
 *
 */
public class SWEA_1249 {
	static class Node implements Comparable<Node> {
		int r, c, w;
		
		Node (int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static int[][] dist;
	static boolean[] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static int getVertex(int r, int c) {
		return r * N + c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dist = new int[N][N];
			isVisited = new boolean[N*N];
			for (int i=0; i<N; i++) {
				String line = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = (int)(line.charAt(j) - '0');
				}
			}
			
			for (int[] d : dist) {
				Arrays.fill(d, INF);
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, 0));
			dist[0][0] = 0;
			
			while (pq.size() > 0) {
				Node curr = pq.poll();
				int v = getVertex(curr.r, curr.c);
				if (isVisited[v]) continue;
				isVisited[v] = true;
				
				for (int i=0; i<4; i++) {
					int nr = curr.r + drc[i][0];
					int nc = curr.c + drc[i][1];
					int nv = getVertex(nr, nc);
					if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nv]) continue;
					if (dist[nr][nc] <= dist[curr.r][curr.c] + map[nr][nc]) continue;
					
					dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
			}
			sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		br.close();
		System.out.print(sb);
	}

}
