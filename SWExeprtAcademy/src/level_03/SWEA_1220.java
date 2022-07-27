package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Magnetic
public class SWEA_1220 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			for (int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0; k<N; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int row=0; row<N; row++) {
				int col = 0;
				int[] arr = new int[2];
				do {
					if (board[col][row] == 1) arr[0] = 1;
					else if (board[col][row] == 2) {
						if (arr[0] == 1) {
							cnt++;
							arr[0] = 0;
							arr[1] = 0;
						} else {
							arr[1] = 1;
						}
					}
					col++;
				} while (col < N);
			}
			sb.append("#" + i + " " + cnt + "\n");
		}
		System.out.println(sb);
		br.close();
	}

}
