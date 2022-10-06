package level_03;

import java.io.*;
import java.util.*;

/**
 * SWEA_3282, Knapsack
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. DP에서 유명한 문제.. 처음에 접근 방법을 몰라 한참을 헤맸음
 * 	2. 모든 아이템을 뽑을 수 있는데 제한 조건은 뽑은 아이템의 무게 총합이 제한 무게를 넘으면 안됨
 * 	3. 1번 아이템을 뽑을 때 0부터 제한무게 K까지에 대해 얻을 수 있는 최대한의 가치는 1번 아이템의 무게 이상에서 1번 아이템의 가치만큼을 가짐
 * 	4. 2번 아이템을 뽑을 때 (이전에 1번 아이템은 뽑은 상태), 0부터 제한무게 K까지에 대해 얻을 수 있는 최대한의 가치는 2번 아이템 미만의 제한 무게에서는 이전 dp에 저장된 값이 최대값이고,
 * 		2번 아이템 무게 이상의 제한무게에 대해서는 1번 아이템의 가치와 2번 아이템의 가치를 비교해 큰 값을 가짐. 단, 1,2번 무게를 모두 뽑을 수 있는 시점에서는 두 아이템의 가치의 합
 * 	5. 이에 대해 점화식으로 표현하자면 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w] + v)
 * 		5.1 dp[i - 1][j]는 현재 제한 무게에 대해 이전까지 뽑은 최대한의 가치를 의미하고,
 * 		5.2 dp[i - 1][j - w]는 이전의 가치에 대해 현재 뽑을 아이템의 무게(w)만큼  뺐을 때의 가치에 현재 추가할 아이템의 가치(v)를 더한 뒤 비교
 *
 */
public class SWEA_3282 {
	static int N, K;
	static int[][] item;
	static int[][] dp;
	
	static void dp() {
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				if (j < item[i][0]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i][0]] + item[i][1]);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			item = new int[N + 1][2];
			dp = new int[N + 1][K + 1];
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				item[i][0] = Integer.parseInt(st.nextToken());
				item[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dp();
			sb.append(String.format("#%d %d\n", tc, dp[N][K]));
		}
		br.close();
		System.out.print(sb);
	}

}
