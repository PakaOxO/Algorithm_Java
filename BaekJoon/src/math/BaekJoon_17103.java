package math;

import java.io.*;

/**
 * BaekJoon_17103, 골드바흐 파티션
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. N보다 같거나 작은 소수를 먼저 찾음
 * 	2. N보다 같거나 작은 소수부터 시작해서 두 소수의 합이 N이 되는 지 체크
 * 		2.1 N - (N보다 같거나 작은 소수) -> 소수인지 체크
 * 		2.2 N - (N보다 같거나 작은 소수) 가 > (N보다 같거나 작은 소수)이 되면 stop
 *
 */
public class BaekJoon_17103 {
	static boolean[] isNotPrime = new boolean[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i=2; i*i<1000001; i++) {
			if (isNotPrime[i]) continue;
			for (int j=i*i; j<1000001; j+=i) isNotPrime[j] = true;
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i=N; i>=2; i--) {
				if (N - i > i) break;
				if (!isNotPrime[i] && !isNotPrime[N - i]) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
