package backtracking;

import java.io.*;
import java.util.*;

// 스도쿠
public class BaekJoon_2580 {
	static int[][] board;
	static List<int[]> list;
	static StringBuilder answer;
	
	static void dfs(int cnt) {
		if (cnt == list.size()) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					if (j < 8) answer.append(board[i][j]).append(" ");
					else answer.append(board[i][j]);
				}
				answer.append("\n");
			}
			System.out.print(answer);
			System.exit(0);
		}
		
		int r = list.get(cnt)[0];
		int c = list.get(cnt)[1];
		for (int i=1; i<10; i++) {
			if (!canfill(r, c, i)) continue;
			board[r][c] = i;
			dfs(cnt + 1);
			board[r][c] = 0;
		}
	}
	
	static boolean canfill(int r, int c, int val) {
		for (int i=0; i<9; i++) {
			if (board[i][c] == val) return false;
			if (board[r][i] == val) return false;
		}
		int a = r / 3 * 3;
		int b = c / 3 * 3;
		for (int i=a; i<a+3; i++) {
			for (int j=b; j<b+3; j++) {
				if (board[i][j] == val) return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];
		list = new ArrayList<>();
		for (int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
		br.close();
				
		answer = new StringBuilder();
		dfs(0);
	}

}
