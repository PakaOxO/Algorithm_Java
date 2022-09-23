package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2573, 빙산
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_2573 {
	static int N, M, cCnt, answer;
	static int[][] map;
	static boolean[][][] isVisited;
	static Queue<Iceberg> queue;
	static boolean[][] tempVisited;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static class Iceberg {
		int r, c, height, depth;
		
		Iceberg(int r, int c, int height, int depth) {
			this.r = r;
			this.c = c;
			this.height = height;
			this.depth = depth;
		}
	}
	
	static boolean check() {
		int r = queue.peek().r;
		int c = queue.peek().c;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		tempVisited = new boolean[N][M];
		tempVisited[r][c] = true;
		cCnt = 1;
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (map[nr][nc] == 0 || tempVisited[nr][nc]) continue;
				q.offer(new int[] { nr, nc });
				tempVisited[nr][nc] = true;
				cCnt++;
				if (cCnt == queue.size()) return true;
			}
		}
 		return false;
	}
	
	static void bfs() {
		int depth = 0;
		boolean flag = false;
		while (queue.size() > 0) {
			if (flag && depth < queue.peek().depth) {
				if (!check()) {
					answer = queue.peek().depth;
					return;
				}
			}
			
			Iceberg curr = queue.poll();
			depth = curr.depth;
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				if (map[nr][nc] > 0 || isVisited[nr][nc][depth]) continue;
				if (curr.height > 0) {
					curr.height--;
					map[curr.r][curr.c]--;
				}
			}
			if (curr.height > 0) {
				queue.offer(new Iceberg(curr.r, curr.c, curr.height, depth + 1));
				isVisited[curr.r][curr.c][depth + 1] = true;
			} else flag = true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M][3001];
		
		queue = new LinkedList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					queue.offer(new Iceberg(i, j, map[i][j], 0));
					isVisited[i][j][0] = true;
				}
			}
		}
		br.close();
		
		answer = 0;
		bfs();
		System.out.println(answer);
	}

}
