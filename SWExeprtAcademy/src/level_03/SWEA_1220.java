package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Magnetic
public class SWEA_1220 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int[][] board = new int[100][];
			for (int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0; k<100; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			for (int row=0; row<100; row++) {
				int col = 0;
				if (board[col][row] == 1) {
					do {
						col++;
						
					} while (col < 100);
				}
			}
		}
	}

}
