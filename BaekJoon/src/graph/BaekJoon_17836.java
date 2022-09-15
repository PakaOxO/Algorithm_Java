package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17836, 공주님을 구해라
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 최단거리로 그람을 찾거나 공주님의 위치로 이동해야 하므로 BFS 탐색
 * 	2. 탐색 중에 그람의 위치에 도착했다면 탐색은 종료하고 바로 공주님의 위치로 최단거리 이동
 * 	3. 반레들
 * 		3.1 그람을 찾고 이동헀는데 이미 그냥 이동해서 도착했었던 경우
 * 		3.2 그냥 이동해 도착했는데 이미 그람을 찾아 도착한 경우가 있는 경우
 *
 */
public class BaekJoon_17836 {
	static int N, M, T;
	static int[][] map;
	static boolean[][] isVisited;
	static int answer;
	
	static int[][] drc = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		isVisited[r][c] = true;
		int[][] t = new int[N][M];
		
		while (q.size() > 0) {
			int[] arr = q.remove();
			r = arr[0];
			c = arr[1];
			
			if (map[r][c] == 2) {
				if (t[N - 1][M - 1] > 0) t[N - 1][M - 1] = Math.min(t[N - 1][M - 1], t[r][c] + (Math.abs(N - 1 - r) + Math.abs(M - 1 - c)));
				else t[N - 1][M - 1] = t[r][c] + (Math.abs(N - 1 - r) + Math.abs(M - 1 - c));
			}
			
			for (int i=0; i<4; i++) {
				int dr = drc[i][0];
				int dc = drc[i][1];
				if (r + dr < 0 || c + drc[i][1] < 0 || r + drc[i][0] >= N || c + drc[i][1] >= M) continue;
				if (map[r + dr][c + dc] == 1 || isVisited[r + dr][c + dc]) continue;
				isVisited[r + dr][c + dc] = true;
				q.add(new int[] { r + dr, c + dc });
				
				if ((r + dr == N - 1 && c + dc == M - 1) && t[N - 1][M - 1] > 0) t[N - 1][M - 1] = Math.min(t[N - 1][M - 1], t[r][c] + 1);
				else t[r + dr][c + dc] = t[r][c] + 1;
			}
		}
		answer = t[N - 1][M - 1];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
		if (answer == 0 || answer > T) System.out.println("Fail");
		else System.out.println(answer);
		br.close();
	}

}
