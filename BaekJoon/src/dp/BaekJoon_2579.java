package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_2579, 계단 오르기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_2579 {
	static int[] map;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new int[N + 1];
		for (int i=1; i<=N; i++) {
			int num = Integer.parseInt(br.readLine());
			map[i] = num;
		}
		br.close();
		
		dp = new int[3];
		dp[0] = map[0];
	}

}
