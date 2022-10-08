package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21317, 징검다리 건너기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. dp로 에너지를 비교하는 데, 가장 큰 점프를 사용한 경우와 사용하지 않은 경우 각각을 별도의 dp 메모리에 공간에 저장 (각각 큰 dp와 작은 dp라고 부르겠음) 
 * 
 * 	2. 각 위치에서 비교할 에너지는 다음과 같음 
 * 		2.1 (현재 위치) - 1에서 작은 점프로 넘어 오는 경우, 
 * 		이전 위치에 가장 큰 점프를 사용해 넘어온 에너지가 있다면 작은 점프를 더한 에너지를 큰 dp에 저장 
 * 		2.2 (현재 위치) - 2에서 큰 점프로 넘어 오는 경우,
 * 		마찬가지로 이전 위치에 가장 큰 점프를 사용해 넘어온 에너지가 있다면 큰 점프를 더한 에너지를 큰 dp에 저장 
 * 		2.3 (현재 위치) - 3에서 가장 큰 점프로 넘어 오는 경우,
 * 		이전에 가장 큰 점프를 사용했을 수는 없으므로 작은 dp에서 K를 더한 값을 큰 dp에 저장 
 * 
 * 	3. 각각의 작은 dp와 큰 dp에 위의 값들을 비교해 작은 값을 저장 
 * 
 * 	4. N번 dp의 큰 dp값과 작은 dp값 중 작은 값을 출력 
 *
 */
public class BaekJoon_21317 {
	static final int INF = Integer.MAX_VALUE >> 2;
	static int[][] energy;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		energy = new int[N][2];
		for (int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			energy[i][0] = Integer.parseInt(st.nextToken());
			energy[i][1] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());
		br.close();
		
		dp = new int[N + 1][2];
		for (int i=1; i<=N; i++) dp[i][1] = INF;
		if (N >= 2) dp[2][0] = energy[1][0];
		
		for (int i=3; i<=N; i++) {
			int A = dp[i - 1][0] + energy[i - 1][0];
			int B = dp[i - 2][0] + energy[i - 2][1];
			dp[i][0] = Math.min(A, B);
			
			if (i > 3) {
				int C = dp[i - 3][0] + K;
				int D = dp[i - 2][1] + energy[i - 2][1];
				int E = dp[i - 1][1] + energy[i - 1][0];
				dp[i][1] = Math.min(C, Math.min(D, E));
			}
		}
		
		System.out.println(Math.min(dp[N][0], dp[N][1]));
	}

}
