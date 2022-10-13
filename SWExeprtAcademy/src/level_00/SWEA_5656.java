package level_00;

import java.io.*;
import java.util.*;

/**
 * SWEA_5656, 벽돌깨기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 위에 있는 벽돌을 아래로 내리는 로직을 구현하는데서 막혔던 문제..
 * 	2. 터뜨릴 블록의 위치를 체크하는 부분도 dfs에서 bfs로 변경
 * 
 * 	3. 처음 터지는 위치를 기준으로 bfs 탐색을 진행하며 터뜨릴 모든 블록을 체크
 * 	4. 체크된 블록 위치들을 모두 0으로 변경
 * 	5. 그 다음 모든 블록들을 아래로 붙힘
 * 	6. 다시 위 과정 반복
 *
 */
public class SWEA_5656 {
	static int N, W, H, totalCnt, cnt, answer;
	static int[][] board, copied;
	static boolean[][] isVisited;
	static int[] shootingPoint;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	
	static void copyBoard() {
		copied = new int[H][W];
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				copied[i][j] = board[i][j];
			}
		}
	}
	
	static void blockDown() {
		for (int j=0; j<W; j++) {
			boolean flag = false;
			for (int i=H-1; i>0; i--) {
				if (copied[i][j] != 0) continue;
				for (int k=i-1; k>=0; k--) {
					if (copied[k][j] != 0) {
						copied[i][j] = copied[k][j];
						copied[k][j] = 0;
						flag = true;
						break;
					}
				}
				if (!flag) break;
			}
		}
	}
	
	static void remove() {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if (!isVisited[i][j] || copied[i][j] == 0) continue;
				copied[i][j] = 0;
				cnt++;
			}
		}
	}
	
	static boolean bomb(int y, int x) {
		if (copied[y][x] == 1) {
			copied[y][x] = 0;
			cnt++;
			return false;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { y, x, copied[y][x] });
		isVisited = new boolean[H][W];
		isVisited[y][x] = true;
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[2] == 1) continue;
			
			for (int i=0; i<4; i++) {
				int nr = curr[0];
				int nc = curr[1];
				for (int j=1; j<curr[2]; j++) {
					nr += drc[i][0];
					nc += drc[i][1];
					if (nr < 0 || nc < 0 || nr >= H || nc >= W) break;
					if (copied[nr][nc] == 0 || isVisited[nr][nc]) continue;
					isVisited[nr][nc] = true;
					q.offer(new int[] { nr, nc, copied[nr][nc] });
				}
			}
		}
		return true;
	}
	
	static void shoot(int x) {
		boolean flag = false;
		for (int y=0; y<H; y++) {
			if (copied[y][x] == 0) continue;
			flag = bomb(y, x);
			break;
		}
		if (flag) remove();
		blockDown();
	}
	
	static void play() {
		for (int i=0; i<N; i++) {
			shoot(shootingPoint[i]);
		}
	}
	
	static void dfs(int depth) {
		if (depth == N) {
			cnt = 0;
			copyBoard();
			play();
			answer = Math.min(answer, totalCnt - cnt);
			return;
		}
		
		for (int i=0; i<W; i++) {
			shootingPoint[depth] = i;
			dfs(depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			board = new int[H][W];
			totalCnt = 0;
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > 0) totalCnt++;
				}
			}
			
			shootingPoint = new int[N];
			answer = Integer.MAX_VALUE;
			dfs(0);
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		br.close();
		System.out.print(sb);
	}

}
