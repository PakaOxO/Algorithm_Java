
import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][][] board;
	static int[][] house;
	
	static void chkAround(int x, int y, int dist) {
		for (int i=x-dist; i<=x+dist; i++) {
			for (int j=y-dist; j<=y+dist; j++) {
				if (i < 0 || i >= 31 || j < 0 || j >= 31) continue;
				int d = Math.abs(i-x)+Math.abs(j-y);
				if (d > dist) continue;
				if (board[i][j][0] != -1) {
					board[i][j][0]++;
					board[i][j][1] += d;
				}
			}
		}
	}
	
	static void checkBoard() {
		for (int i=0; i<31; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			board = new int[31][31][2];
			int N = Integer.parseInt(br.readLine());
			house = new int[N][3];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 15;
				int y = Integer.parseInt(st.nextToken()) + 15;
				board[x][y][0] = -1;
				int dist = Integer.parseInt(st.nextToken());
				house[i] = new int[] { x, y, dist };
				chkAround(x, y, dist);
			}
			checkBoard();
			
			int minDist = Integer.MAX_VALUE;
			int totalCnt = N;
			loop:
			for (int i=0; i<31; i++) {
				for (int j=0; j<31; j++) {
					if (board[i][j][0] == N) {
						minDist = Math.min(minDist, board[i][j][1]);
						totalCnt -= N;
						break loop;
					}
				}
			}
			System.out.println(minDist);
			sb.append("#").append(tc).append(" ").append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}