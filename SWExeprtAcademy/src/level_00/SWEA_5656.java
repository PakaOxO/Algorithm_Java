package level00;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA_5656, 벽돌깨기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class SWEA_5656 {
	static int N, W, H, min;
	static int[][] board, copied;
	static boolean[][] isVisited;
	static int[] height, shootingPoint;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 0, 1 }, { 0, -1 } };
	
	static void copyBoard() {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				copied[i][j] = board[i][j];
			}
		}
	}
	
	static void blockDown() {
		
	}
	
	static void remove() {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if (!isVisited[i][j]) continue;
				if (copied[i][j] == 0) continue;
				copied[i][j] = 0;
			}
		}
	}
	
	static void bomb(int y, int x) {
		int num = copied[y][x];
		isVisited[y][x] = true;
		for (int i=0; i<4; i++) {
			int ny = y;
			int nx = x;
			for (int j=1; j<num; j++) {
				ny += drc[i][0];
				nx += drc[i][1];
				if (ny < 0 || nx < 0 || ny >= H || nx >= W) break;
				if (copied[ny][nx] == 0 || isVisited[ny][nx]) continue;
				bomb(ny, nx);
			}
		}
	}
	
	static void shoot(int x) {
		for (int y=0; y<H; y++) {
			if (copied[y][x] == 0) continue;
			bomb(y, x);
			break;
		}
		remove();
	}
	
	static void play() {
		for (int i=0; i<N; i++) {
			isVisited = new boolean[H][W];
			shoot(shootingPoint[i]);
		}
	}
	
	static void dfs(int depth) {
		if (depth == N) {
			copyBoard();
			play();
			return;
		}
		
		for (int i=0; i<W; i++) {
			shootingPoint[depth] = i;
			dfs(depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			board = new int[H][W];
			height = new int[W];
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] != 0) height[j]++;
				}
			}
			
			shootingPoint = new int[N];
			dfs(0);
		}
	}

}
