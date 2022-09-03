package dfs;

import java.io.*;
import java.util.*;

// 색종이 붙이기
public class BaekJoon_17136 {
	static int[][] board;
	static List<int[]> voidList;
	static int[] paperCnt = { 5, 5, 5, 5, 5 };
	static int answer;
	
	static boolean canFill(int r, int c, int w) {
		if (r > 10 - w || c > 10 - w) return false;
		for (int i=r; i<r+w; i++) {
			for (int j=c; j<c+w; j++) {
				if (board[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void fill(int r, int c, int w, int val) {
		for (int i=r; i<r+w; i++) {
			for (int j=c; j<c+w; j++) {
				board[i][j] = val;
			}
		}
	}
	
	static void dfs(int point, int cnt) {
		if (point == voidList.size()) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (cnt >= answer) return;
		
		int r = voidList.get(point)[0];
		int c = voidList.get(point)[1];
		if (board[r][c] == 0) dfs(point + 1, cnt);
		else {
			for (int w=5; w>=1; w--) {
				if (paperCnt[w - 1] > 0 && canFill(r, c, w)) {
					fill(r, c, w, 0);
					paperCnt[w - 1]--;
					dfs(point + 1, cnt + 1);
					fill(r, c, w, 1);
					paperCnt[w - 1]++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[10][10];
		voidList = new ArrayList<>();
		for (int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					voidList.add(new int[] { i, j });
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		
		if (answer > 25) System.out.println(-1);
		else System.out.println(answer);
		br.close();
	}

}
