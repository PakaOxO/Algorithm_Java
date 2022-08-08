package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Sum
public class SWEA_1209 {
	private static int[][] board;
	private static int N = 100;
	
	static int findMaxSum() {
		int max = 0;
		int crossSum = 0;
		for (int i=0; i<N; i++) {
			int colSum = 0;
			int rowSum = 0;
			for (int j=0; j<N; j++) {
				colSum += board[i][j];
				rowSum += board[j][i];
				if (i == j) crossSum += board[i][j];
			}
			max = Math.max(max, colSum);
			max = Math.max(max, rowSum);
		}
		max = Math.max(max, crossSum);
		
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=10; i++) {
			int testNo = Integer.parseInt(br.readLine());
			board = new int[N][N];
			for (int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0; k<N; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#" + testNo + " " + findMaxSum() + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
