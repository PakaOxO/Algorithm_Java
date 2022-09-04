package dfs;

import java.io.*;
import java.util.*;

// 비숍
public class BaekJoon_1799 {
	static int N;
	static int[][] board;
	static boolean[] checkLCross;
	static boolean[] checkRCross;
	static int maxW;
	static int maxB;
	
	static boolean check(int r, int c) {
		if (checkLCross[r + c] || checkRCross[r - c + N - 1]) return false;
		return true;
	}
	
	static void dfs(int r, int c, int cnt, int type) {
		if (c >= N) {
			if (c % 2 == 0) c = 1;
			else c = 0;
			r++;
		}
		if (r == N) {
			if (type == 0) {
				maxW = Math.max(maxW, cnt);
			} else {
				maxB = Math.max(maxB, cnt);
			}
			return;
		}
		
		if (board[r][c] == 0 || !check(r, c)) dfs(r, c + 2, cnt, type);
		else {
			checkLCross[r + c] = true;
			checkRCross[r - c + N - 1] = true;
			dfs(r, c + 2, cnt + 1, type);
			checkLCross[r + c] = false;
			checkRCross[r - c + N - 1] = false;
			dfs(r, c + 2, cnt, type);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		checkLCross = new boolean[N * 2 - 1];
		checkRCross = new boolean[N * 2 - 1];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxW = Integer.MIN_VALUE;
		maxB = Integer.MIN_VALUE;
		dfs(0, 0, 0, 0);
		dfs(0, 1, 0, 1);
		System.out.println(maxW + maxB);
		br.close();
	}

}
