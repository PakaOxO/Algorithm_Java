package bruteForce;

import java.io.*;
import java.util.*;

// 오목
public class BaekJoon_2615 {
	static int[][] board;
	static int ansType, ansR, ansC;
	
	static boolean check(int r, int c) {
		int type = board[r][c];
		// 가로
		if (c - 1 < 0 || (c - 1 >= 0 && board[r][c - 1] != type)) {
			int cnt = 1;
			int nextC = c + 1;
			while (true) {
				if (nextC >= 19) break;
				if (board[r][nextC] != type) break;
				cnt++;
				nextC++;
				if (cnt == 5) {
					if (nextC < 19 && board[r][nextC] == type) break;
					return true;
				}
			}
		}
		
		// 세로
		if (r - 1 < 0 || (r - 1 >= 0 && board[r - 1][c] != type)) {
			int cnt = 1;
			int nextR = r + 1;
			while (true) {
				if (nextR >= 19) break;
				if (board[nextR][c] != type) break;
				cnt++;
				nextR++;
				if (cnt == 5) {
					if (nextR < 19 && board[nextR][c] == type) break;
					return true;
				}
			}
		}
		
		// 대각선(우하)
		if ((r - 1 < 0 || c - 1 < 0) || ((r - 1 >= 0 && c - 1 >= 0) && board[r-1][c-1] != type)) {
			int cnt = 1;
			int nextR = r + 1;
			int nextC = c + 1;
			while (true) {
				if (nextR >= 19 || nextC >= 19) break;
				if (board[nextR][nextC] != type) break;
				cnt++;
				nextR++;
				nextC++;
				if (cnt == 5) {
					if (nextR < 19 && nextC < 19 && board[nextR][nextC] == type) break;
					return true;
				}
			}
		}
		
		// 대각선(우상)
		if ((r + 1 >= 19 || c - 1 < 0) || ((r + 1 < 19 && c - 1 >= 0) && board[r+1][c-1] != type)) {
			int cnt = 1;
			int nextR = r - 1;
			int nextC = c + 1;
			while (true) {
				if (nextR < 0 || nextC >= 19) break;
				if (board[nextR][nextC] != type) break;
				cnt++;
				nextR--;
				nextC++;
				if (cnt == 5) {
					if (nextR >= 0 && nextC < 19 && board[nextR][nextC] == type) break;
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[19][19];
		for (int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;
		for (int i=0; i<19; i++) {
			for (int j=0; j<19; j++) {
				if (board[i][j] != 0 && check(i, j)) {
					flag = true;
					ansType = board[i][j];
					ansR = i + 1;
					ansC = j + 1;
					break;
				}
			}
			if (flag) break;
		}
		StringBuilder sb = new StringBuilder();
		if (ansType > 0) sb.append(ansType).append("\n").append(ansR).append(" ").append(ansC);
		else sb.append(0);
		System.out.println(sb);
		br.close();
	}

}
