package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_7569, 토마토
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 토마토에 대한 정보를 입력받으면서
 * 		1.1 익었으면 BFS 탐색을 위한 큐에 미리 담아두고
 * 		1.2 익지 않았으면 익지 않은 토마토의 개수(cnt)에 저장
 * 
 *	2. BFS 탐색은 높이 방향(h)과 수평 방향(drc)으로 나누어 탐색
 *		2.1 탐색 범위를 벗어나거나 토마토가 없거나(box = -1) 또는 이미 익었는데 현재 익는 시간보다 빠를 경우에는 continue
 *
 *	3. 모든 탐색이 종료되고 모든 토마토를 익히는 데 필요한 시간을 출력
 *
 */
public class BaekJoon_7569 {
	static int M, N, H;
	static int[][][] box;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dh = { -1, 1 };
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int ripeCnt;
	static int max;
	
	static void bfs() {
		while (q.size() > 0) {
			int[] curr = q.remove();
			for (int i=0; i<2; i++) {
				int nh = curr[0] + dh[i];
				if (nh < 0 || nh >= H || box[nh][curr[1]][curr[2]] != 0) continue;
				if (box[nh][curr[1]][curr[2]] > 0 && box[nh][curr[1]][curr[2]] <= box[curr[0]][curr[1]][curr[2]] + 1) continue;
				q.add(new int[] { nh, curr[1], curr[2] });
				ripeCnt = Math.max(ripeCnt, ripeCnt + 1);
				box[nh][curr[1]][curr[2]] = box[curr[0]][curr[1]][curr[2]] + 1;
				max = Math.max(max, box[nh][curr[1]][curr[2]]);
			}
			for (int i=0; i<4; i++) {
				int nr = curr[1] + dr[i];
				int nc = curr[2] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || box[curr[0]][nr][nc] != 0) continue;
				if (box[curr[0]][nr][nc] > 0 && box[curr[0]][nr][nc] <= box[curr[0]][curr[1]][curr[2]] + 1) continue;
				q.add(new int[] { curr[0], nr, nc });
				ripeCnt = Math.max(ripeCnt, ripeCnt + 1);
				box[curr[0]][nr][nc] = box[curr[0]][curr[1]][curr[2]] + 1;
				max = Math.max(max, box[curr[0]][nr][nc]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		int cnt = 0;
		for (int h=0; h<H; h++) {
			for (int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m=0; m<M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if (box[h][n][m] == 1) q.add(new int[] { h, n, m });
					else if (box[h][n][m] == 0) cnt++;
				}
			}
		}
		br.close();
		
		if (cnt == 0) System.out.println(0);
		else {
			bfs();
			if (ripeCnt < cnt) System.out.println(-1);
			else System.out.println(max - 1);
		}
	}

}
