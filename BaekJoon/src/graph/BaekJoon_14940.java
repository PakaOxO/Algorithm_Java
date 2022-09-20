package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14940, 쉬운 최단거리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 입력을 받으면서
 * 		1.1 도착지점 위치(2) 저장
 * 		1.2 이동하지 못하는 곳(0) 외의 모든 방문 시간을 -1로 초기화(실제로 방문하지 못하는 곳 때문)
 * 
 * 	2. 도착지점(2)에서 시작하는 BFS 탐색을 시행하면서 모든 방문지역에 (이전 지역의 방문시간) + 1
 *
 */
public class BaekJoon_14940 {
	static int N, M;
	static int[][] map;
	static int[][] cnt;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (map[nr][nc] != 1 || cnt[nr][nc] > 0) continue;
				
				q.offer(new int[] { nr, nc });
				cnt[nr][nc] = cnt[curr[0]][curr[1]] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int r = 0;
		int c = 0;
		map = new int[N][M];
		cnt = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					r = i;
					c = j;
				} else if (map[i][j] != 0) {
					cnt[i][j] = -1;
				}
			}
		}
		br.close();
		
		bfs(r, c);
		
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (j < M - 1) sb.append(cnt[i][j]).append(" ");
				else sb.append(cnt[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
