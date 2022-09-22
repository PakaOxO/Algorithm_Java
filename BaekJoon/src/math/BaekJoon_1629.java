package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1629, 곱셈
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 모듈러 연산의 분배법칙 활용
 * 	2. 곱한 결과의 모듈러 연산은 각 곱셈 요소의 모듈러 연산의 곱과 같음
 *
 */
public class BaekJoon_1629 {
	static long exp(long a, long b, long mod) {
		if (b == 0) return 1;
		if (b == 1) return a % mod;
		
		long c = exp(a, b / 2, mod);
		if (b % 2 == 0) return c * c % mod;
		else return (c * c % mod) * a % mod;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		br.close();

		System.out.println(exp(A, B, C));
	}

}
