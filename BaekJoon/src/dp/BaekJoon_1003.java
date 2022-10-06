package dp;

import java.io.*;

/**
 * BaekJoon_1003, 피보나치 함수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 피보나치 수를 구하는 함수를 Top-down 방식으로 만들어 해당 함수의 파라미터가 1인 경우와 0인 경우 함수 호출이 몇번 되는지 체크하면 되는 문제 -> 실패
 * 	2. Top-down 방식으로 피보나치 수를 얻어내는 메서드 구현
 * 
 * 	1. Bottom-up 방식으로 다시 풀이
 * 	2. 피보나치 3은 피보나치 2 + 피보나치 1과 같은 성질을 이용해 피보나치 N의 0과 1의 개수는 피보나치 N-1과 N-2의 0과 1의 개수의 합
 * 	** Top-down으로 풀 때도 위 2번의 성질을 이용하면 재귀로 풀 수 있음
 *
 */
public class BaekJoon_1003 {
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		dp = new int[41][2];
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			for (int j=2; j<=N; j++) {
				dp[j][0] = dp[j - 2][0] + dp[j - 1][0];
				dp[j][1] = dp[j - 2][1] + dp[j - 1][1];
			}
			sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
		}
		br.close();
		System.out.print(sb);
	}

}
