package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11660 구간 합 구하기 5
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. (x1, y1) ~ (x2, y2)로 생기는 사각형 면적내 숫자의 합을 묻는 문제
 * 		1.1 입력 받은 값로 누적합을 산출, 누적합은 가로, 세로, 대각선 방향으로 누적
 * 		1.2 식으로 표현하면 [r][c]까지의 누적합은
 * 			가로(열) 누적 [r][c - 1], 세로(행) 누적 [r - 1][c]을 더한 합에 서로 중복되는 대각방향(행열) 누적합을 뺀 값 [r - 1][c - 1]
 * 		1.3 dp[r][c] = dp[r - 1][c] + dp[r][c - 1] + dp[r - 1][c - 1]
 * 	2. 입력을 받을 때 바로 행별 누적합을 계산해 누적합 배열을 생성한다.
 * 		2.1 이때 이전 누적 합 계산을 용이하게 하기 위해 N + 1 크기의 배열을 생성하여 r = 0, c = 0인 위치의 값(0)을 사욯애 r = 1, c = 1의 누적합을 계산하도록 보정.
 * 	3. 입력받은 좌표를 기준으로 생성된 사각형 내부 숫자의 합은 마찬가지로 대각선 방향 누적합을 이용해 (전체 누적합) - (가로 누적합) - (세로 누적합) + (대각 누적합)
 * 		3.1 마지막에 대각 누적합을 더해주는 이유는 가로, 세로 누적합을 빼주는 과정에서 두 번 제거되기 때문
 * 		3.2 식으로 표현하면 (사각형 누적합) = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]
 * 
 */
public class BaekJoon_11660 {
	static int[][] accArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		accArr = new int[N + 1][N + 1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				accArr[i][j] = accArr[i - 1][j] + accArr[i][j - 1] - accArr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(accArr[x2][y2] - accArr[x2][y1 - 1] - accArr[x1 - 1][y2] + accArr[x1 - 1][y1 - 1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
