package level_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 } };

	static int[][] board;
	static int prevRow;
	static int prevCol;
	
	static int answer;
	
	static void checkPath(int start, int row, int col) {
		if (row == 99) {
			if (board[row][col] == 2) {
				answer = start;
				return;
			}
		}
		
		if (row == 99) return;
		
		for (int i=0; i<drc.length; i++) {
			if (row + drc[i][0] < 0 || row + drc[i][0] >= 100 || col + drc[i][1] < 0 || col + drc[i][1] >= 100) continue;
			if ( !(prevRow == row + drc[i][0] && prevCol == col + drc[i][1]) && board[row + drc[i][0]][col + drc[i][1]] > 0) {
				prevRow = row;
				prevCol = col;
				checkPath(start, row + drc[i][0], col + drc[i][1]);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int i=1; i<=T; i++) {
			br.readLine();
			board = new int[100][100];
			for (int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0; k<100; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = -1;
			for (int j=0; j<100; j++) {
				if (board[0][j] == 1) {
					prevRow = 0;
					prevCol = j;
					checkPath(j, 1, j);
				}
				if (answer > -1) break;
			}
			sb.append("#" + i + " " + answer + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
