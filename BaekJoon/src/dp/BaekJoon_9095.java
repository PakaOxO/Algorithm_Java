package dp;

import java.io.*;

/**
 * BaekJoon_9095, 1, 2, 3 더하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 점화식 : f(n) = f(n - 1) + f(n - 2) + f(n - 3)
 * 	2. 기저 조건 : f(1) = 1, f(2) = 2, f(3) = 4
 * 	3. Bottom-up 으로 풀이
 *
 */
public class BaekJoon_9095 {
	static int[] cnt;
	static int INF = Integer.MAX_VALUE >> 1;
	
	static int getCnt(int num) {
		if (num <= 1) return 1;
		if (num == 2) return 2;
		if (num == 3) return 4;
		
		cnt = new int[num + 1];
		cnt[0] = cnt[1] = 1;
		cnt[2] = 2;
		cnt[3] = 4;
		for (int i=4; i<=num; i++) {
			cnt[i] = cnt[i - 1] + cnt[i - 2] + cnt[i - 3];
		}
		
		return cnt[num];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			cnt = new int[num + 1];
			sb.append(getCnt(num)).append("\n");
		}
		br.close();
		
		System.out.print(sb);
	}

}
