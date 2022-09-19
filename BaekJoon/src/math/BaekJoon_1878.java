package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1878, 소수 찾기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 에라토스테네스의 체 사용
 *
 */
public class BaekJoon_1878 {
	static boolean[] isNotPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		isNotPrime = new boolean[1001];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		for (int i=2; i*i<1001; i++) {
			if (isNotPrime[i]) continue;
			for (int j=i*i; j<1001; j+=i) {
				isNotPrime[j] = true;
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i=0; i<N; i++) {
			if (!isNotPrime[Integer.parseInt(st.nextToken())]) cnt++;
		}
		System.out.println(cnt);
		br.close();
	}

}
