package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1934, 최소공배수
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 최소공배수는 두 수의 곱 / 최대공약수
 */
public class BaekJoon_1934 {
	static int getGCD(int a, int b) {
		if (b == 0) return a;
		if (a >= b) return getGCD(b, a % b);
		else return getGCD(a, b % a);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			System.out.println(A * B / getGCD(A, B));
		}
		br.close();
	}

}
