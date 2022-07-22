package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 스도쿠 검증
public class SWEA_1974 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[][] board = new String[9][];
			for (int j=0; j<9; j++) {
				String[] line = br.readLine().split(" ");
				board[j] = line;
			}
			
			int isVaild = 1;
			int p = 0;
			while (p < 9) {
				int[] col = new int[9];
				int[] row = new int[9];
				int[] block = new int[9];
				
				// 가로, 세로
				for (int q=0; q<9; q++) {
					int colVal = Integer.parseInt(board[p][q]);
					int rowVal = Integer.parseInt(board[q][p]);
					if (col[colVal - 1] == 1 || row[rowVal - 1] == 1) {
						isVaild = 0;
						break;
					} col[colVal - 1]++; row[rowVal - 1]++;
				}
				
				// 블럭
				int colStrt = (p / 3) * 3;
				int rowStrt = 3 * (p % 3);
				for (int r=colStrt; r<colStrt+3; r++) {
					for (int s=rowStrt; s<rowStrt+3; s++) {
						int blockVal = Integer.parseInt(board[r][s]);
						if (block[blockVal - 1] == 1) {
							isVaild = 0;
							break;
						} block[blockVal - 1]++;
					}
					if (isVaild == 0) break;
				}
				if (isVaild == 0) break;
				p++;
			}
			System.out.printf("#%d %d\n", i + 1, isVaild);
		}
		br.close();
	}

}
