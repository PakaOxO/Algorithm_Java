package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1149, RGB 거리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. N번째 선택할 수 있는 색은 N-1번째 선택할 수 있는 색에서 최소값 + 현재 RGB값
 * 	2. N번째 R을 선택하려면 N-1번째에는 G or B가 선택되어야 함
 *
 */
public class BaekJoon_1149 {
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[0][2] = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(st.nextToken());
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(st.nextToken());
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(st.nextToken());
		}
		br.close();
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}

}
