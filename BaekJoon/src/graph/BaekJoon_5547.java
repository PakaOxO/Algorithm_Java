package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_5547, 일루미네이션
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 맨 위부터 인덱스를 0이라 한다면
 * 		1.1 r(행)이 짝수일 땐 왼쪽 아래 대각선으로 이동x, 왼쪽 위 대각선으로 이동 X
 * 		1.2	홀수일땐 오른쪽 아래 대각선으로 이동X, 오른쪽 위 대각선으로 이동 X
 * 	2. 먼저 입력을 받으면서 빌딩이면서 경계선(배열 바운더리인곳)에서 외부와 얼마나 이어져있는지 계산(아예 외부쪽 조명개수)
 *	3. 조명은 바깥에서 볼 수 있게 설치해야하므로 BFS 탐색 지점은 외부와 이어진 곳(주어진 배열 바운더리이면서 건물이 아닌곳)에서 시작
 *	4. 빌딩과 만날때마다 빌딩에 +1(조명개수)
 *	5. BFS 탐색 종료 후, cnt를 합산(기존 빌딩이었던 곳이라는 표시로 1이 더해져 있었으므로 -1씩 계산해서 보정)
 *
 */
public class BaekJoon_5547 {
	static int W, H;
	static int[][] map;
	static boolean[][] isVisited;
	
	static int[] dr = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[] dc = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int cnt;
	
	static boolean isBoundary(int r, int c) {
		for (int i=0; i<8; i++) {
			if (r % 2 == 0 && i >= 6) continue;
			if (c % 2 == 1 && (i == 4 || i == 5)) continue;
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
				return true;
			}
		}
		return false;
	}
	
	static void bfs(int r, int c) {
		if (isVisited[r][c]) return;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		isVisited[r][c] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<8; i++) {
				if (curr[0] % 2 == 0 && i >= 6) continue;
				if (curr[0] % 2 == 1 && (i == 4 || i == 5)) continue;
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= H || nc >= W || isVisited[nr][nc]) {
					continue;
				}
				if (map[nr][nc] > 0) {
					map[nr][nc] = map[nr][nc] + 1;
				} else {
					q.offer(new int[] { nr, nc });
					isVisited[nr][nc] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		isVisited = new boolean[H][W];
		List<int[]> list = new ArrayList<>();
		
		for (int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0 && isBoundary(i, j)) {
					list.add(new int[] { i, j });
				}
				if (map[i][j] == 1 && isBoundary(i, j)) {
					for (int k=0; k<8; k++) {
						if (i % 2 == 0 && k >= 6) continue;
						if (i % 2 == 1 && (k == 4 || k == 5)) continue;
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
							map[i][j]++;
						}
					}
				}
			}
		}
		br.close();
		
		for (int i=0; i<list.size(); i++) {
			int[] curr = list.get(i);
			bfs(curr[0], curr[1]);
		}
		
		cnt = 0;
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if (map[i][j] <= 1) continue;
				cnt += map[i][j] - 1;
			}
		}
		System.out.println(cnt);
	}

}
