package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2609, 최대공약수와 최소공배수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 최대공약수(GCD), 최소공배수(LCM) 공식 확인
 *
 */
public class BaekJoon_2609 {
	static int getGCD(int a, int b) {
		if (b == 0) return a;
		if (a >= b) return getGCD(b, a % b);
		else return getGCD(a, b % a);
	}
	
	static int getLCM(int a, int b, int gcd) {
		return a * b / gcd;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int gcd = getGCD(N, M);
		System.out.println(gcd);
		System.out.println(getLCM(N, M, gcd));
		br.close();
	}

}
