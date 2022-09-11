package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9079, 동전 게임 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_9079 {
	static boolean[][] board;
	static int min;
	
	static void reverseH(int r) {
		board[r][0] = !board[r][0];
		board[r][1] = !board[r][1];
		board[r][2] = !board[r][2];
	}
	
	static void reverseV(int c) {
		board[0][c] = !board[0][c];
		board[1][c] = !board[1][c];
		board[2][c] = !board[2][c];
	}
	
	static void reverseC() {
		board[0][0] = !board[0][0];
		board[1][1] = !board[1][1];
		board[2][2] = !board[2][2];
	}
	
	static boolean check() {
		int tCnt = 0;
		int hCnt = 0;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (board[i][j] == true) tCnt++;
				else hCnt++;
			}
		}
		if (tCnt == 9 || hCnt == 9) return true;
		return false;
	}
	
	static void bfs(int r, int c, int cnt) {
		if (c == 3) {
			c = 0;
			r++;
		}
		if (r == 3) {
			return;
		}
		
		if (cnt >= min) return;
		
		if (check()) {
			min = cnt;
			return;
		}
		
		reverseH(r);
		bfs(r + 1, c + 1, cnt + 1);
		reverseH(r);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			board = new boolean[3][3];
			for (int i=0; i<3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<3; j++) {
					if (st.nextToken().charAt(0) == 'T') board[i][j] = true;
				}
			}
			
			min = Integer.MAX_VALUE;
			bfs(0, 0, 0);
			
			if (min == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(min);
		}
		br.close();
	}

}
