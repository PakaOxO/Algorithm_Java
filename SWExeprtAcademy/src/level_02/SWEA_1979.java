package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 어디에 단어가 들어갈 수 있을까
public class SWEA_1979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] nk = br.readLine().split(" ");
			int N = Integer.parseInt(nk[0]);
			int K = Integer.parseInt(nk[1]);
			
			String[][] board = new String[N][];
			for (int j=0; j<N; j++) {
				String[] line = br.readLine().split(" ");
				board[j] = line;
			}
			
			int cnt = 0;
			for (int col=0; col<N; col++) {
				int horzLen = 0;
				int vertLen = 0;
				for (int row=0; row<N; row++) {
					horzLen = (Integer.parseInt(board[col][row]) == 1) ? horzLen + 1 : 0;
					if ( (horzLen == K && row == N - 1) || (horzLen == K && row < N - 1 && Integer.parseInt(board[col][row + 1]) != 1) ) cnt++;
					
					vertLen = (Integer.parseInt(board[row][col]) == 1) ? vertLen + 1 : 0;
					if ( (vertLen == K && row == N - 1) || (vertLen == K && row < N - 1 && Integer.parseInt(board[row + 1][col]) != 1) ) cnt++;
					
					System.out.println(horzLen + " " + vertLen + " " + cnt);
				}
			}
			System.out.printf("#%d %d\n", i + 1, cnt);
		}
	}

}
