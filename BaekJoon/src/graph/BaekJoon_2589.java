package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2589, 보물섬
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 지도 정보를 입력받아 저장
 * 	2. 지도를 탐색하면서 육지이면 BFS 탐색, 해당 탐색의 깊이의 최대값을 저장
 * 	3. 최종적으로 갱신된 최대값을 출력
 *
 */
public class BaekJoon_2589 {
	static int N, M, max;
	static char[][] map;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void bfs(int sR, int sC) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sR, sC, 0 });
		
		isVisited = new boolean[N][M];
		isVisited[sR][sC] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			max = Math.max(max, curr[2]);
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 'L' || isVisited[nr][nc]) continue;
				
				isVisited[nr][nc] = true;
				q.offer(new int[] { nr, nc, curr[2] + 1 });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		br.close();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] != 'L') continue;
				bfs(i, j);
			}
		}
		System.out.println(max);
	}

}
