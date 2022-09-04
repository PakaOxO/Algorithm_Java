package dp;

import java.io.*;
import java.util.*;

// 스티커
public class BaekJoon_9465 {
	static int N;
	static int[][] board;
	static int[][] memoization;
	static int max;
	
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[2][N + 1];
			for (int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			if (N == 1) {
				max = Math.max(board[0][1], board[1][1]);
			} else {
				memoization = new int[2][N + 1];
				// 첫번째 값 세팅
				memoization[0][1] = board[0][1];
				memoization[1][1] = board[1][1];
				for (int i=2; i<=N; i++) {
					for (int j=0; j<2; j++) {
						// 이전 행 대각선 위치 값 가져오기
						if (j == 0) {
							memoization[j][i] = memoization[1][i - 1];
						} else {
							memoization[j][i] = memoization[0][i - 1];
						}
						// 전전 행에서 이전 행 값을 더한 합보다 큰 값이 있을 경우 가져옴
						memoization[j][i] = Math.max(memoization[j][i], memoization[0][i - 2]);
						memoization[j][i] = Math.max(memoization[j][i], memoization[1][i - 2]);
						// 지금 행 값 더함
						memoization[j][i] += board[j][i];
						max = Math.max(max, memoization[j][i]);
					}
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
