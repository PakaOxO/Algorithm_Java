package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1600, 말이 되고픈 원숭이
 * @author kevin-Arpe
 * 
 * Sketch Idea (HARD)
 * 	1. 일단 W, H가 모두 1이면 이동하지 않으므로 바로 0 출력
 * 	2. 시작 위치(0, 0)에서 BFS 탐색을 시작
 * 		2.1 isVisited 처리, visited 배열은 해당 위치(r, c)와 몇 번 점프해서 왔는지로 구분
 * 		2.2  현재 위치 저장은 현재 위치(r, c)와 현재 위치를 올 때까지 걸린 시간(depth), 그리고 남은 점프회수(jCnt)를 저장
 * 		2.3 다음 위치 이동은 2가지 방법으로 가능한데 점프 회수가 남아있으면 점프, 그리고 일반 이동을 한 경우로 구분
 * 	3. 다음 위치를 큐에 담을 때에는 해당 위치 정보(r, c)와 이동 시간(depth), 남은 점프회수를 넘어 depth가 깊어질 때마다 몇 번 이동해서 왔고, 몇 번 점프 했는지 체크
 * 	4. 도착지점(H-1, W-1)에 도착했을 때 노드의 이동 시간(depth)를 체크하는데 이전에 방문했을 경우가 있을 수 있으므로 둘 중 작은 값으로 초기화
 *
 */
public class BaekJoon_1600 {
	static int K, W, H, min;
	static int[][] map;
	static boolean[][][] isVisited;
	
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };
	static int[] jdr = { 2, 1, 1, 2, -2, -2, -1, -1 };
	static int[] jdc = { 1, 2, -2, -1, -1, 1, -2, 2 };
	
	static void bfs(int r, int c, int jCnt) {
		Queue<int[]> q = new LinkedList<>();
		int cr, cc, cCnt, nr, nc, j;
		int cnt = 0;
		q.offer(new int[] { r, c, cnt, jCnt });
		isVisited[r][c][jCnt] = true;
		
		while (q.size() > 0) {
			cr = q.peek()[0];
			cc = q.peek()[1];
			cCnt = q.peek()[2];
			j = q.peek()[3];
			q.poll();
			if (j > 0) {
				for (int i=0; i<8; i++) {
					nr = cr + jdr[i];
					nc = cc + jdc[i];
					
					if (nr < 0 || nc < 0 || nr >= H || nc >= W || isVisited[nr][nc][j - 1] || map[nr][nc] > 0) continue;
					
					isVisited[nr][nc][j - 1] = true;
					if (nr == H - 1 && nc == W - 1) {
						min = Math.min(min, cCnt + 1);
						continue;
					}
					q.offer(new int[] { nr, nc, cCnt + 1, j - 1 });
				}
			}
			for (int i=0; i<4; i++) {
				nr = cr + dr[i];
				nc = cc + dc[i];
				if (nr < 0 || nc < 0 || nr >= H || nc >= W || isVisited[nr][nc][j] || map[nr][nc] > 0) continue;
				
				isVisited[nr][nc][j] = true;
				if (nr == H - 1 && nc == W - 1) {
					min = Math.min(min, cCnt + 1);
					continue;
				}
				q.offer(new int[] { nr, nc, cCnt + 1, j });
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		isVisited = new boolean[H][W][31];
		for (int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<W; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		min = Integer.MAX_VALUE;
		if (H == 1 && W == 1) {
			System.out.println(0);
		} else {
			bfs(0, 0, K);
			
			if (min == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(min);
		}
	}

}
