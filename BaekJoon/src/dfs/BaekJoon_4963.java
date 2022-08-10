package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 섬의 개수
public class BaekJoon_4963 {
	// 죄측 위 대각선부터 시계방향으로 탐색
	static int[][] drc = { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1} };
	static boolean[][] isChecked;
	static int[][] board;
	
	static int answer;
	
	static void checkAround(int r, int c, int H, int W) {
		for (int i=0; i<drc.length; i++) {
			int dr = drc[i][0], dc = drc[i][1];
			if (r + dr < 0 || r + dr >= H || c + dc < 0 || c + dc >= W) continue;
			
			if (board[r+dr][c+dc] == 1 && !isChecked[r+dr][c+dc]) {
				isChecked[r+dr][c+dc] = true;
				checkAround(r+dr, c+dc, H, W);
			}
		}
	}
	
	static void cntIsland(int H, int W) {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				if (board[i][j] == 1 && !isChecked[i][j]) {
					isChecked[i][j] = true;
					checkAround(i, j, H, W);
					answer++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) break;
			
			isChecked = new boolean[H][W];
			board = new int[H][W];
			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			cntIsland(H, W);
			System.out.println(answer);
		}
	}

}
