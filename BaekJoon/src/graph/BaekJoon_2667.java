package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2667, 단지번호붙이기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. map을 탐색하면서 처음 집을 발견하면 그 집을 시작으로 BFS 탐색
 * 	2. BFS 탐색을 돌면서 방문한 집은 visited 처리하고 카운팅을 함
 * 	3. 모든 map 탐색이 종료 후, 카운팅된 각 단지의 개수를 출력
 *
 */
public class BaekJoon_2667 {
	static int N;
	static int[][] map;
	static boolean[][] isVisited;
	static List<Integer> list;
	
	static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		isVisited[r][c] = true;
		int cnt = 1;
		
		while (q.size() > 0) {
			int[] curr = q.remove();
			
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
				if (map[nr][nc] == 0) continue;
				q.add(new int[] { nr, nc });
				isVisited[nr][nc] = true;
				cnt++;
			}
		}
		
		list.add(cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = (int)(line.charAt(j) - '0');
			}
		}
		
		list = new ArrayList<>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (isVisited[i][j]) continue;
				if (map[i][j] == 1) bfs(i, j);
			}
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
