package level00;

import java.io.*;
import java.util.*;

/**
 * SWEA_5650, 핀볼 게임
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class SWEA_5650 {
	static int N, sR, sC, r, c, dir, cnt, answer;
	static int[][] board;
	static int[][][] hole;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static List<int[]> start;
	
	static void play() {
		int nr, nc;
		while (true) {
			if (cnt > 0 && r == sR && c == sC) {
				break;
			}
			
			if (r == 0 || c == 0 || r == N + 1 || c == N + 1) {
				dir = (dir + 2) % 4;
				cnt++;
			}
			System.out.println(r + " " + c + " " + dir + " " + board[r][c]);
			nr = r + drc[dir][0];
			nc = c + drc[dir][1];
			if (board[nr][nc] == 5) {
				dir = (dir + 2) % 4;
			} else if (board[nr][nc] == 0) {
				r = nr;
				c = nc;
			} else if (board[nr][nc] == 1) {
				r = nr;
				c = nc;
				cnt++;
				if (dir <= 1) dir = (dir + 2) % 4;
				else if (dir == 2) dir = 1;
				else dir = 0;
				
			} else if (board[nr][nc] == 2) {
				r = nr;
				c = nc;
				cnt++;
				if (dir == 1 || dir == 2) dir = (dir + 2) % 4;
				else if (dir == 0) dir = 1;
				else dir = 2;
				
			} else if (board[nr][nc] == 3) {
				r = nr;
				c = nc;
				cnt++;
				if (dir == 2 || dir == 3) dir = (dir + 2) % 4;
				else if (dir == 0) dir = 3;
				else dir = 2;
				
			} else if (board[nr][nc] == 4) {
				r = nr;
				c = nc;
				cnt++;
				if (dir == 0 || dir == 3) dir = (dir + 2) % 4;
				else if (dir == 1) dir = 0;
				else dir = 3;
				
			} else if (board[nr][nc] >= 6 && board[nr][nc] <= 10) {
				if (nr == hole[board[nr][nc] - 6][0][0] && nc == hole[board[nr][nc] - 6][0][1]) {
					r = hole[board[nr][nc] - 6][1][0];
					c = hole[board[nr][nc] - 6][1][1];
				} else {
					r = hole[board[nr][nc] - 6][0][0];
					c = hole[board[nr][nc] - 6][0][1];
				}
			} else {
				break;
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N + 2][N + 2];
			start = new ArrayList<>();
			hole = new int[5][2][2];
			for (int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if (board[i][j] == 0) start.add(new int[] { i, j });
					else if (board[i][j] >= 6 && board[i][j] <= 10) {
						if (hole[board[i][j] - 6][0][0] == 0) {
							hole[board[i][j] - 6][0][0] = i;
							hole[board[i][j] - 6][0][1] = j;
						} else {
							hole[board[i][j] - 6][1][0] = i;
							hole[board[i][j] - 6][1][1] = j;
						}
					}
				}
			}
			
			answer = 0;
			for (int s[] : start) {
				for (int i=0; i<4; i++) {
					sR = s[0];
					sC = s[1];
					
					r = sR;
					c = sC;
					dir = i;
					cnt = 0;
					play();
					answer = Math.max(answer, cnt);
				}
			}
			System.out.println(answer);
		}
	}

}
