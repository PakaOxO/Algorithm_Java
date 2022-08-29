package level_04;

import java.io.*;
import java.util.*;

// 사다리 1 (복습)
public class SWEA_1210_3 {
	static int[][] board;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, -1 }, { 0, 1 }, { -1, 0 } };
	static int answer;
	
	static void move(int r, int c) {
		if (r == 0) {
			answer = c;
			return;
		}
		
		for (int i=0; i<3; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			
			if (r + dr < 0 || r + dr >= 100 || c + dc < 0 || c + dc >= 100 || board[r + dr][c + dc] == 0 || isVisited[r + dr][c + dc]) continue;
			r = r + dr;
			c = c + dc;
			isVisited[r][c] = true;
			move(r, c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc=1; tc<=T; tc++) {
			int tNo = Integer.parseInt(br.readLine());
			board = new int[100][100];
			isVisited = new boolean[100][100];
			int end = -1;
			for (int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 2) end = j;
				}
			}
			answer = -1;
			move(99, end);
			
			sb.append("#").append(tNo).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
