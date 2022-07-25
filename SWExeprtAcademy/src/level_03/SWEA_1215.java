package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 회문 1
public class SWEA_1215 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			String[][] board = new String[8][];
			for (int j=0; j<8; j++) {
				board[j] = br.readLine().split("");
			}
			
			for (int j=0; j<8; j++) {
				for (int k=0; k<=8-N; k++) {
					StringBuilder sb1 = new StringBuilder();
					StringBuilder sb2 = new StringBuilder();
					for (int l=k; l<k+N; l++) {
						sb1.append(board[j][l]);
						sb2.append(board[l][j]);
					}
					if (sb1.toString().equals(sb1.reverse().toString())) cnt++;
					if (sb2.toString().equals(sb2.reverse().toString())) cnt++;
				}
			}
			System.out.printf("#%d %d\n", i + 1, cnt);
		}
		br.close();
	}

}
