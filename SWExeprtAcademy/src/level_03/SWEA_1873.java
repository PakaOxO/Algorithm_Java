package level_03;

import java.io.*;
import java.util.*;

// 상호의 배틀필드 
public class SWEA_1873 {
	static char[][] board;
	static int posR, posC;
	static int H, W;
	static int N;
	
	static void move(char dir) {
		if (dir == '^') {
			if (posR - 1 < 0 || board[posR - 1][posC] != '.') {
				board[posR][posC] = dir;
				return;
			}
			board[posR - 1][posC] = dir;
			board[posR][posC] = '.';
			posR = posR - 1;
			return;
		}
		if (dir == 'v') {
			if (posR + 1 >= H || board[posR + 1][posC] != '.') {
				board[posR][posC] = dir;
				return;
			}
			board[posR + 1][posC] = dir;
			board[posR][posC] = '.';
			posR = posR + 1;
			return;
		}
		if (dir == '<') {
			if (posC - 1 < 0 || board[posR][posC - 1] != '.') {
				board[posR][posC] = dir;
				return;
			}
			board[posR][posC - 1] = dir;
			board[posR][posC] = '.';
			posC = posC - 1;
			return;
		}
		if (dir == '>') {
			if (posC + 1 >= W || board[posR][posC + 1] != '.') {
				board[posR][posC] = dir;
				return;
			}
			board[posR][posC + 1] = dir;
			board[posR][posC] = '.';
			posC = posC + 1;
			return;
		}
	}
	
	static void shoot() {
		char dir = board[posR][posC];
		if (dir == '<') {
			int c = posC - 1;
			while (c >= 0) {
				if (board[posR][c] == '#') break;
				if (board[posR][c] == '*') {
					board[posR][c] = '.';
					break;
				}
				c--;
			}
			return;
		}
		if (dir == '>') {
			int c = posC + 1;
			while (c < W) {
				if (board[posR][c] == '#') break;
				if (board[posR][c] == '*') {
					board[posR][c] = '.';
					break;
				}
				c++;
			}
			return;
		}
		if (dir == '^') {
			int r = posR - 1;
			while (r >= 0) {
				if (board[r][posC] == '#') break;
				if (board[r][posC] == '*') {
					board[r][posC] = '.';
					break;
				}
				r--;
			}
			return;
		}
		if (dir == 'v') {
			int r = posR + 1;
			while (r < H) {
				if (board[r][posC] == '#') break;
				if (board[r][posC] == '*') {
					board[r][posC] = '.';
					break;
				}
				r++;
			}
			return;
		}
	}
	
	static void doOrder(String order, int orderNo) {
		if (orderNo == N) return;
		char c = order.charAt(orderNo);
		
		if (c == 'U') move('^');
		else if (c == 'D') move('v');
		else if (c == 'L') move('<');
		else if (c == 'R') move('>');
		else shoot();
		
		doOrder(order, orderNo + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			board = new char[H][W];
			for (int i=0; i<H; i++) {
				String line = br.readLine();
				for (int j=0; j<W; j++) {
					board[i][j] = line.charAt(j);
					if (board[i][j] == '<' || board[i][j] == '^' || board[i][j] == '>' || board[i][j] == 'v') {
						posR = i;
						posC = j;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			String order = br.readLine();
			doOrder(order, 0);
			
			sb.append("#").append(tc).append(" ");
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

}
