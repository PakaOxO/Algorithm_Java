package level00;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA_1953, 탈주범 검거
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 맨홀 위치를 시작점으로 BFS 탐색
 * 	2. 다음 탐색 지점은 현재 위치의 통로 모양 기준으로 달라짐
 *
 */
public class SWEA_1953 {
	static class Pos {
		int r, c, depth;
		Pos(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
	
	static int N, M, sR, sC, L, answer;
	static int[][] map;
	static boolean[][] isVisited;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] hasRoute = { { true, true, true, true },
									{ true, false, true, false },
									{ false, true, false, true },
									{ true, true, false, false },
									{ false, true, true, false },
									{ false, false, true, true, },
									{ true, false, false, true }
								  };
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(sR, sC, 0));
		isVisited[sR][sC] = true;
		
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			if (curr.depth == L) break;
			answer++;
			
			int type = map[curr.r][curr.c] - 1;
			for (int i=0; i<4; i++) {
				if (!hasRoute[type][i]) continue;
				
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || isVisited[nr][nc]) continue;
				if (!hasRoute[map[nr][nc] - 1][(i + 2) % 4]) continue;
				isVisited[nr][nc] = true;
				q.offer(new Pos(nr, nc, curr.depth + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sR = Integer.parseInt(st.nextToken());
			sC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 0;
			isVisited = new boolean[N][M];
			bfs();
			
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		
		br.close();
		System.out.print(sb);
	}

}
