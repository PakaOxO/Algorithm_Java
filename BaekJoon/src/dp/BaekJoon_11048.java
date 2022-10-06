package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11048, 이동하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 점화식 dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + currValue
 * 	2. i, j가 범위 밖에 벗어나는 것을 주의하며 입력을 받을 때마다 이전 위치의 최대값을 더하며 dp 갱신
 * 		** 영묵님 풀이 참고 : 아예 배열을 [N+1][M+1] 크기로 만들어서 데이터 첫 행/열이 0행, 0열을 참조하도록 하면 될 듯
 *
 */
public class BaekJoon_11048 {
	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				
				if (i > 0 && j > 0) {
					dp[i][j] += Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
				} else if (i > 0) {
					dp[i][j] += dp[i - 1][j];
				} else if (j > 0) {
					dp[i][j] += dp[i][j - 1];
				}
			}
		}
		br.close();
		System.out.println(dp[N - 1][M - 1]);
	}

}
