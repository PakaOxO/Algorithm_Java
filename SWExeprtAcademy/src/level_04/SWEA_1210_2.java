package level_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1210_2 {
	
	static int[][] drc = { { 0, -1 }, { 0, 1 }, { -1, 0 } };
	
	static int[][] board;
	static int end;
	static List<Integer> strtList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int i=1; i<=T; i++) {
			br.readLine();
			strtList = new ArrayList<>();
			board = new int[100][100];
			for (int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0; k<100; k++) {
					int input = Integer.parseInt(st.nextToken());
					board[j][k] = input;
					if (j == 0 && input == 1) strtList.add(k);
					if (j == 99 && input == 2) end = k;
				}
			}
			
			int pointer = 0;
			for (int j=0; j<strtList.size(); j++) {
				if (strtList.get(j) == end) pointer = j;
			}
			int diff = 0;
			
			int row = 99, col = end;
			int prevR = row, prevC = col, prevDir = 2;
			while (row >= 0) {
				if (row == 0) break;
				for (int j=0; j<drc.length; j++) {
					if (row + drc[j][0] < 0 || row + drc[j][0] >= 100 || col + drc[j][1] < 0 || col + drc[j][1] >= 100 || board[row + drc[j][0]][col + drc[j][1]] == 0) {
						continue;
					}
					if (prevR == row + drc[j][0] && prevC == col + drc[j][1]) continue;
					prevR = row;
					prevC = col;
					if (j < 2 && j != prevDir) diff += drc[j][1];
					row += drc[j][0];
					col += drc[j][1];
					prevDir = j;
					break;
				}
			}
			sb.append("#" + i + " " + strtList.get(pointer + diff) + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
