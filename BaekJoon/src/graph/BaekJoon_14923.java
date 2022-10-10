package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14923, 미로 탈출
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 마법을 쓴 경우와 쓰지 않은 경우에 대한 visited 배열을 만들어 BFS 탐색
 *
 */
public class BaekJoon_14923 {
	static int N, M, sR, sC, eR, eC, answer;
	static int[][] map;
	static boolean[][][] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void bfs() {
		if (sR == eR && sC == eC) {
			answer = 0;
			return;
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sR, sC, 0, 0 });
		
		isVisited = new boolean[N][M][2];
		isVisited[sR][sC][0] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc][curr[2]]) continue;
				if (curr[2] == 1 && map[nr][nc] == 1) continue;
				
				if (nr == eR && nc == eC) {
					answer = curr[3] + 1;
					return;
				}
				
				if (map[nr][nc] == 1) {
					q.offer(new int[] { nr, nc, 1, curr[3] + 1 });
				} else {
					q.offer(new int[] { nr, nc, curr[2], curr[3] + 1 });
				}
				isVisited[nr][nc][curr[2]] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		sR = Integer.parseInt(st.nextToken()) - 1;
		sC = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(br.readLine());
		eR = Integer.parseInt(st.nextToken()) - 1;
		eC = Integer.parseInt(st.nextToken()) - 1;
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		answer = -1;
		bfs();
		System.out.println(answer);
	}

}
