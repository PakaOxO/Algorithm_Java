package math;

import java.io.*;

/**
 * BaekJoon_11653, 소인수 분해
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 소수 체크
 * 	2. 소수이면서 N의 약수인 것을 찾아 저장
 * 	3. 문자열에 저장된 값들을 출력
 *
 */
public class BaekJoon_11653 {
	static boolean[] isNotPrime = new boolean[10000001];
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i=2; i*i<10000001; i++) {
			if (isNotPrime[i]) continue;
			for (int j=i*i; j<10000001; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int div = 2;
		while (N > 1) {
			if (isNotPrime[div]) {
				div++;
				continue;
			}
			
			if (N % div == 0) {
				sb.append(div).append("\n");
				N /= div;
				continue;
			}
			div++;
		}
		System.out.print(sb);
		br.close();
	}

}
