package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_7576, 토마토
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 익은 토마토의 위치를 미리 큐에 저장한 뒤 한번에 BFS 탐색
 * 	2. 탐색을 진행하며 각 위치의 토마토가 익는 최소 날짜 계산
 * 		2.1 이미 익은(적은 일수로) 토마토에 접근할 경우 continue
 * 		2.2 모든 탐색을 진행하면서 최대 일자(모든 토마토가 익기까지 필요한 시간) 저장
 *
 */
public class BaekJoon_7576 {
	static int N, M;
	static int[][] box;
	static int ripeCnt;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] isVisited;
	
	static int bfs() {
		int max = 0;
		while (q.size() > 0) {
			int[] curr = q.remove();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || box[nr][nc] == -1 || isVisited[nr][nc]) continue;
				if (box[nr][nc] > 0 && box[nr][nc] < box[curr[0]][curr[1]] + 1) continue;
				
				q.offer(new int[] { nr, nc });
				isVisited[nr][nc] = true;
				box[nr][nc] = box[curr[0]][curr[1]] + 1;
				max = Math.max(max, box[nr][nc]);
				ripeCnt = Math.max(ripeCnt, ripeCnt + 1);
			}
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		isVisited = new boolean[N][M];
		
		int cnt = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0) cnt++;
				else if (box[i][j] == 1) {
					q.offer(new int[] { i, j });
					isVisited[i][j] = true;
				}
			}
		}
		
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		
		int maxDay = bfs();
		if (ripeCnt < cnt) System.out.println(-1);
		else System.out.println(maxDay - 1);
	}

}
