package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1929, 소수 구하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 에라토스테네스의 체 공식 활용
 *
 */
public class BaekJoon_1929 {
	static boolean[] isNotPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		isNotPrime = new boolean[N+1];
		isNotPrime[0] = isNotPrime[1] = true;
		for (int i=2; i*i<=N; i++) {
			if (isNotPrime[i]) continue;
			for (int j=i*i; j<=N; j+=i) {
				isNotPrime[j] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=M; i<=N; i++) {
			if (!isNotPrime[i]) sb.append(i).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
