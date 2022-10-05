package dp;

import java.io.*;

/**
 * BaekJoon_11727, 2xn 타일링 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Bottom-up 방식으로 풀이
 * 	2. 점화식 : f(n) = f(n - 1) + f(n - 2) * 2
 * 	3. 기저조건 : f(1) = 1, f(2) = 3
 *
 */
public class BaekJoon_11727 {
	static final int div = 10007;
	static int[] cnt;
	
	static int getCnt(int N) {
		if (N == 1) return 1;
		if (N == 2) return 3;
		
		cnt = new int[N + 1];
		cnt[1] = 1;
		cnt[2] = 3;
		for (int i=3; i<=N; i++) {
			cnt[i] = (cnt[i - 1] + (cnt[i - 2] * 2)) % div;
		}
		
		return cnt[N];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(getCnt(N));
	}

}
