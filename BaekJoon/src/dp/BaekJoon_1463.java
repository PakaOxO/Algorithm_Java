package dp;

import java.io.*;

/**
 * BaekJoon_1463, 1로 만들기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 현재 위치에 올 수 있는 경우는 3가지
 * 		1.1 바로 아래에서 1 더해서 올라옴
 * 		1.2 짝수라면 1/2 위치에서 +1 해서 올라옴
 * 		1.3 3의 배수라면 1/3의 위치에서 +1해서 올라옴
 * 	2. 다음 세 가지의 경우 중 최소값을 dp에 저장
 *
 */
public class BaekJoon_1463 {
	static int[] dp;
	
	static int getAnswer(int N) {
		if (N == 1) return 0;
		
		dp = new int[N + 1];
		dp[1] = 0;
		
		for (int i=2; i<=N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}
		
		return dp[N];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(getAnswer(N));
	}

}
