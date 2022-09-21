package level_03;

import java.io.*;

/**
 * SWEA_2806, N-Queen
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. N-Queen
 *
 */
public class SWEA_2806 {
	static boolean[][] board;
	static int cnt;
	
	static boolean checkC2(int r, int c, int N) {
		while (r >= 0 && c < N) {
			if (board[r][c]) return false;
			r--;
			c++;
		}
		return true;
	}
	
	static boolean checkC1(int r, int c) {
		while (r >= 0 && c >= 0) {
			if (board[r][c]) return false;
			r--;
			c--;
		}
		return true;
	}
	
	static boolean checkH(int r, int c) {
		for (int i=0; i<r; i++) {
			if (board[i][c]) return false;
		}
		return true;
	}
	
	static void dfs(int r, int N) {
		if (r == N) {
			cnt++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (checkC1(r, i) && checkC2(r, i, N) && checkH(r, i)) {
				board[r][i] = true;
				dfs(r + 1, N);
				board[r][i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			if (N == 1) sb.append("1\n");
			else {
				board = new boolean[N][N];
				cnt = 0;
				dfs(0, N);
				sb.append(cnt).append("\n");
			}
		}
		System.out.println(sb);
	}

}
