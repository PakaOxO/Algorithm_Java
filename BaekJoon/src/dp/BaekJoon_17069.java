package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17069, 파이프 옮기기 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 현재 위치로 이동하려면 조건이 다음과 같음
 * 		1.1 일단 현재 위치가 벽(1)이면 안됨
 * 		1.2 만약 대각선으로 이동하려면 현재 위치 기준 위와 왼쪽에 벽(1)이 있으면 안되며 대각선으로 들어오려면 이전 위치(i-1, j-1)에 대각선, 가로, 세로로 들어온 친구들 참조
 * 		1.3 만약 가로로 들어오려면 왼쪽에서 들어올 수 있는데 왼쪽 위치에 가로, 대각선으로 들어온 친구들만 참조(세로로 들어왔으면 다음에는 가로 이동 불가)
 * 		1.4 세로로 들어오려면 위쪽에서 들어올 수 있는데 가로와 비슷하게 세로, 대각선으로 들어온 친구들만 참조(가로로 들어왔으면 다음에는 세로 이동 불가)
 * 
 * 	2. 1의 과정을 반복하면서 상향식(Bottom-up)으로 N-1, N-1 위치에 들어가는 대각선, 가로, 세로의 개수를 구한 뒤 합산
 *
 */
public class BaekJoon_17069 {
	static int N;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		dp = new long[N][N][3];
		dp[0][1] = new long[] { 0, 1, 0 };
		for (int i=0; i<N; i++) {
			for (int j=2; j<N; j++) {
				if (map[i][j] == 1) continue;
				
				// 대각선
				if (i > 0 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {
					dp[i][j][0] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
				// 가로
				if (j > 0) {
					dp[i][j][1] += dp[i][j - 1][0] + dp[i][j - 1][1];
				}
				// 세로
				if (i > 0) {
					dp[i][j][2] += dp[i - 1][j][0] + dp[i - 1][j][2];
				}
			}
		}
		
		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}

}
