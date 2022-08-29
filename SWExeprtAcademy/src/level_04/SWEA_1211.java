package level_04;

import java.io.*;
import java.util.*;

// Ladder 2 
public class SWEA_1211 {
	static int[][] board;
	static int[][] drc = { { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int prevDir;
	static int strtC;
	static int minCnt;
	static int answer;
	
	static void move(int r, int c, int cnt) {
		if (r == 99) {
			if (minCnt > cnt) {
				minCnt = cnt;
				answer = strtC;
			}
			return;
		}
		
		for (int i=0; i<3; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			
			if (c + dc < 0 || c + dc >= 100 || board[r + dr][c + dc] == 0) continue;
			if (i == 0 && prevDir == 1) continue;
			if (i == 1 && prevDir == 0) continue;
			prevDir = i;
			move(r + dr, c + dc, cnt + 1);
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc=1; tc<=T; tc++) {
			int tNo = Integer.parseInt(br.readLine());
			board = new int[100][100];
			for (int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minCnt = Integer.MAX_VALUE;
			for (int i=0; i<100; i++) {
				if (board[0][i] != 1) continue;
				prevDir = 2;
				strtC = i;
				move(0, i, 1);
			}
			
			sb.append("#").append(tNo).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
