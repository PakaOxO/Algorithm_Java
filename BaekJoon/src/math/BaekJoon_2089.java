package math;

import java.io.*;

/**
 * BaekJoon_2089, -2진수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. ?
 *
 */
public class BaekJoon_2089 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		if (N == 0) {
			System.out.println(0);
			return;
		}
		
		while (N != 0) {
			sb.append((int)Math.abs(N % (-2)));
			N = Math.ceil(N / -2);
		}
		System.out.println(sb.reverse());
		br.close();
	}
}