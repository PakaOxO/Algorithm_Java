package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1912, 연속합
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. (연속합의 최대값) = (현재까지 누적합) - (이전 누적합의 최소값)
 * 	2. 누적합을 저장할 배열(pSum)과 연속합의 최대값을 저장할 배열(dp)을 만들어 관리 
 *
 */
public class BaekJoon_1912 {
	static int[] pSum, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		pSum = new int[N + 1];
		dp = new int[N + 1];
		int min = 0;
		int answer = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			pSum[i] = pSum[i - 1] + Integer.parseInt(st.nextToken());
			dp[i] = pSum[i] - min;
			answer = Math.max(answer, dp[i]);
			min = Math.min(min, pSum[i]);
		}
		br.close();
		System.out.println(answer);
	}

}
