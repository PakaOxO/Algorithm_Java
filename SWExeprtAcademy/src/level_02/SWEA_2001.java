package level_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파리 퇴치
public class SWEA_2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<testCnt; i++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			String[][] board = new String[N][];
			for (int j=0; j<N; j++) {
				String[] line = br.readLine().split(" ");
				board[j] = line;
			}
			
			int max = Integer.MIN_VALUE;
			for (int col=0; col<N-M+1; col++) {
				for (int row=0; row<N-M+1; row++) {
					int sum = 0;
					for (int dy=0; dy<M; dy++) {
						for (int dx=0; dx<M; dx++) {
							sum += Integer.parseInt(board[col+dy][row+dx]);
						}
					}
					if (sum > max) max = sum;
				}
			}
			System.out.printf("#%d %d\n", i + 1, max);
		}
		
		br.close();
	}

}
