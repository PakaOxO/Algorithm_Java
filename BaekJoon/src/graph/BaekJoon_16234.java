package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16234, 인구 이동
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 매 일자마다(0일부터 시작) BFS 탐색을 시작할 위치를 먼저 선택(0,0) ~ (N-1, N-1)
 * 		1.1 이전 BFS 탐색에서 연합이 되었을 경우에는 isVisited 체크를 하여 BFS 탐색 X
 * 
 * 	2. BFS 탐색을 돌면서 인접 위치의 인구조건 체크(현재 위치와 인구 차이가 L이상 R이하)
 * 		2.1 인구조건이 맞는다면 인접 위치로 이동, 이를 반복하여 연합이 될 수 있는 모든 위치 탐색
 * 		2.2 만약 인구조건이 맞는 인접국가가 없다면 boolean 리턴 값을 false로 넘김(연합이 되지 못함)
 * 
 * 	3. 매 일자마다 위와 같이 BFS 탐색을 하는데 연합이 되지 못했다면 while 반복문 break, 연합이 되었다면 다음 while문으로 continue
 * 
 * 	4. 연합이 되어 인구이동이 일어난 만큼 while문이 돌기 때문에 day를 체크하여 while문이 break되었을 때의 day를 출력
 *
 */
public class BaekJoon_16234 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	
	static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		isVisited[r][c] = true;
		
		List<int[]> l = new ArrayList<>();
		int sum = 0;
		boolean flag = false;
		while (q.size() > 0) {
			int[] curr = q.poll();
			sum += map[curr[0]][curr[1]];
			l.add(curr);
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
				
				int abs = Math.abs(map[nr][nc] - map[curr[0]][curr[1]]);
				if (!(abs >= L && abs <= R)) continue;
				flag = true;
				q.offer(new int[] { nr, nc });
				isVisited[nr][nc] = true;
			}
		}
		if (flag) {
			int avg = sum / l.size();
			for (int[] n : l) {
				map[n[0]][n[1]] = avg;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while (true) {
			isVisited = new boolean[N][N];
			boolean isSwap = false;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (isVisited[i][j]) continue;
					boolean flag = bfs(i, j);
					isSwap = isSwap || flag;
				}
			}
			if (!isSwap) break;
			day++;
		}
		
		System.out.println(day);
		br.close();
	}

}
