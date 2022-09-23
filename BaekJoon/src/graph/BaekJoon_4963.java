package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_4963, 섬의 개수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. DFS와 BFS 두 방식으로 풀 수 있는 문제
 *
 */
public class BaekJoon_4963 {
	static int W, H, cnt;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dr = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dc = { 1, -1, 0, -1, 1, 0, -1, 1 };
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		isVisited[r][c] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == 0 || isVisited[nr][nc]) continue;
				q.offer(new int[] { nr, nc });
				isVisited[nr][nc] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) break;
			map = new int[H][W];
			isVisited = new boolean[H][W];
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (map[i][j] == 1 && !isVisited[i][j]) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		br.close();
		System.out.print(sb);
	}

}
