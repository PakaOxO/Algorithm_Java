package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_7562, 나이트의 이동
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 현재 위치에서 이동할 수 있는 다음 위치를 큐에 넣으면서 탐색(BFS)
 * 	2. 탐색과정에서 목표위치에 도착하면 depth를 출력
 *
 */
public class BaekJoon_7562 {
	static int N, answer;
	static boolean[][] isVisited;
	static int[][] drc = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };
	
	static void bfs(int sR, int sC, int eR, int eC) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sR, sC, 0 });
		isVisited[sR][sC] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			
			for (int i=0; i<8; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
				
				if (nr == eR && nc == eC) {
					answer = curr[2] + 1;
					return;
				}
				isVisited[nr][nc] = true;
				q.offer(new int[] { nr, nc, curr[2] + 1 });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			isVisited = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sR = Integer.parseInt(st.nextToken());
			int sC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int eR = Integer.parseInt(st.nextToken());
			int eC = Integer.parseInt(st.nextToken());
			
			answer = 0;
			bfs(sR, sC, eR, eC);
			
			sb.append(answer).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

}
