package dp;

import java.io.*;

/**
 * BaekJoon_17626, Four Squares
 * @author kevin-Arpe
 * 
 * Sketch Idea (수정됨)
 * 	1. 숫자 N은 1 + (N - 1), 4 + (N - 4), 9 + (N - 9) ...로 구분될 수 있음
 * 	2. 1, 4, 9..와 같은 제곱수는 1개의 제곱수의 합으로 이루어져 있음(최소 개수)
 * 	3. 따라서 1과 같은 조합들로 제곱수의 개수의 최소값 dp[1] + dp[N - 1] or dp[4] + dp[N - 4] ... 을 구하면 됨
 * 	4. 메모이제이션을 통해 N 이전의 값들에 대해 몇 개의 제곱수 합으로 이루어져 있는지 찾음
 * 	5. dp[N]을 출력
 *
 */
public class BaekJoon_17626 {
	static int[] dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		dp[1] = 1;
		for (int i=2; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			for (int j=1; j*j<=i; j++) {
				min = Math.min(min, dp[i - (j * j)]);
			}
			dp[i] = min + 1;
		}
		System.out.println(dp[N]);
		br.close();
	}

}
