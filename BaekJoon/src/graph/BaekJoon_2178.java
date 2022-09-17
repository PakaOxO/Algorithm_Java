package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2178, 미로 탐색 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. BFS 탐색을 진행하며 시작지점에서 주어진 목표지점에 도착하면 도착하기까지 진행한 count출력 후 프로그램 종료 
 *
 */
public class BaekJoon_2178 {
	static int[][] map;
	static int[][] cnt;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, 1 } , { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void bfs(int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		isVisited[0][0] = true;
		
		int depth = 1;
		while (q.size() > 0) {
			int[] curr = q.remove();
			int r = curr[0];
			int c = curr[1];
			
			for (int i=0; i<4; i++) {
				int dr = drc[i][0];
				int dc = drc[i][1];
				
				if (r + dr < 0 || c + dc < 0 || r + dr > n || c + dc > m || isVisited[r + dr][c + dc]) continue;
				if (map[r + dr][c + dc] == 0) continue;
				
				cnt[r + dr][c + dc] = (cnt[r + dr][c + dc] == 0) ? depth : Math.min(cnt[r + dr][c + dc], depth);
				q.add(new int[] { r + dr, c + dc });
				isVisited[r + dr][c + dc] = true;
			}
			depth++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cnt = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = (int)(line.charAt(j) - '0');
			}
		}
		
		bfs(N - 1, M - 1);
		
		for (int i=0; i<N; i++) {
			System.out.println(Arrays.toString(cnt[i]));
		}
		
		System.out.println(cnt[N - 1][M - 1]);
		br.close();
	}

}
