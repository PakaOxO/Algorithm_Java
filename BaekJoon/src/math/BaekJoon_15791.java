package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15791, 세진이의 미팅
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 페르마의 소정리
 *
 */
public class BaekJoon_15791 {
	static int modular = 1000000007;
	static long[] f;
	
	static long exp(long a, long b) {
		if (b == 0) return 1;
		if (b == 1) return a;
		
		long c = exp(a, b / 2);
		if (b % 2 == 0) return c * c % modular;
		else return (c * c % modular) * a % modular;
	}
	
	static long factorial(int n) {
		if (f[n] != 0) return f[n];
		f[n] = factorial(n - 1) * n % modular;
		return f[n];
	}
	
	static long comb(int n, int r) {
		if (n == r || r == 0) return 1;
		if (r == 1) return n;
		return factorial(n) * exp(factorial(r) * factorial(n - r) % modular, modular - 2) % modular;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		br.close();
		
		f = new long[1000001];
		f[0] = 1;
		f[1] = 1;
		System.out.println(comb(N, M));
	}

}
