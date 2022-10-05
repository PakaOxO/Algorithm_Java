package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BaekJoon_11726, 2xn 타일링
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 도출한 점화식 : f(n) = f(n - 1) + f(n - 2)
 * 	2. Bottom-up 방식으로 부분 문제에 대한 답을 먼제 계산한 뒤 메모이제이션 된 값으로 최종 값 도출
 *
 */
public class BaekJoon_11726 {
	static int[] cnt;
	static final int div = 10007;
	
	static int getCnt(int N) {
		if (N <= 2) return N;
		
		cnt = new int[N + 1];
		cnt[1] = 1;
		cnt[2] = 2;
		for (int i=3; i<=N; i++) {
			cnt[i] = (cnt[i - 1] + cnt[i - 2]) % div;
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
