package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2468, 안전 영역
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 비가 오는 양은 0부터 시작...(문제 설명에 빠져있어서 한번 틀림)
 * 	2. 비 내리는 양을 0부터 최대 높이 - 1까지 반복하면서 안전영역 체크
 * 	3. 안전영역 함수에서 전체 맵을 순회하면서 비에 잠기는 높이 이상이면서 이전에 방문하지 않은 장소 찾은 뒤 BFS 탐색
 * 	4. 최대 안전 영역 개수 출력
 *
 */
public class BaekJoon_2468 {
	static int N, maxHeight, cnt, max;
	static int[][] map;
	static boolean[][] isVisited;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void bfs(int r, int c, int height) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		isVisited[r][c] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (!(0 <= nr && nr < N && 0 <= nc && nc < N) || map[nr][nc] <= height || isVisited[nr][nc]) continue;
				
				q.offer(new int[] { nr, nc });
				isVisited[nr][nc] = true;
			}
		}
	}
	
	static void getSafeArea(int height) {
		isVisited = new boolean[N][N];
		cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] <= height || isVisited[i][j]) continue;
				cnt++;
				bfs(i, j, height);
			}
		}
		max = Math.max(max, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		maxHeight = 0;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		br.close();
		
		max = 0;
		for (int h=0; h<maxHeight; h++) {
			getSafeArea(h);
		}
		System.out.println(max);
	}

}
