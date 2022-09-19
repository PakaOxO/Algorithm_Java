package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17087, 숨바꼭질 6
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 모든 수를 돌면서 (각각의 수) - (현재 위치)의 절대값에 대한 최대 공약수를 구하는 문제
 *
 */
public class BaekJoon_17087 {
	static int getGCD(int a, int b) {
		if (b == 0) return a;
		if (b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		return getGCD(b, a % b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int gcd = Math.abs(Integer.parseInt(st.nextToken()) - S);
		for (int i=1; i<N; i++) {
			gcd = getGCD(gcd, Math.abs(Integer.parseInt(st.nextToken()) - S));
		}
		
		System.out.println(gcd);
		br.close();
	}

}
