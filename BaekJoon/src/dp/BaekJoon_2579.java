package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_2579, 계단 오르기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. dp[1]의 최대값은 무조건 한칸 오르는 경우뿐이므로 map[1]
 * 	2. dp[2]의 최대값은 한계단씩 2번 밟고 올라온 경우가 최대값이므로 map[1] + map[2]
 * 	3. 위 둘을 기저조건으로 dp[3]부터 계산
 * 		3.1 3칸 이상의 계단을 밟고 올라 올 수 있는 경우는 2칸 이전에서 올라오거나 3칸 이전에서 2칸, 1칸으로 밟고 올라온 경우
 * 		3.2 1칸, 2칸으로 밟고 올라온 경우는 3.1의 2칸 이전에서 올라온 경우에 포함
 * 		3.3 dp[n] = Math.max(dp[n-2], dp[n-3] + map[i-1]) + map[i] 점화식 도출
 *
 */
public class BaekJoon_2579 {
	static int[] map;
	static int[] dp;
	
	static int getAnswer(int N) {
		if (N == 1) return map[1];
		if (N == 2) return map[1] + map[2];
		
		dp = new int[N + 1];
		dp[1] = map[1];
		dp[2] = map[1] + map[2];
		for (int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + map[i - 1]) + map[i];
		}
		return dp[N];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new int[N + 1];
		for (int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			map[i] = num;
		}
		br.close();
		
		System.out.println(getAnswer(N));
	}

}