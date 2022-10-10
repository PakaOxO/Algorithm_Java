package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11052, 카드 구매하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 1장부터 최대 비용을 계산해 나가며 dp 배열에 최대 금액을 저장.
 * 	2. 총 N장까지의 최대 금액을 계산하면서 dp 값 갱신
 * 	3. dp[N] 출력 
 *
 */
public class BaekJoon_11052 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		for (int i=2; i<=N; i++) {
			for (int j=1; j<=i/2; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
			}
		}
		System.out.println(dp[N]);
	}

}
