package math;

import java.io.*;

/**
 * BaekJoon_6588, 골드바흐의 추측
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 최대 100만까지 숫자를 검증하므로 100만까지 소수를 먼저 찾는다.
 * 	2. 가장 작은 소수부터 탐색하면서 n - minPrime의 값이 소수인지 판별한다.
 * 	3. 값의 차이값이 소수라면 리턴
 *
 */
public class BaekJoon_6588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i=2; i*i<=1000000; i++) {
			if (isNotPrime[i]) continue;
			for (int j=i*i; j<=1000000; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			for (int i=2; i<=n; i++) {
				if (!isNotPrime[i] && !isNotPrime[n - i]) {
					sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
		br.close();
	}

}
