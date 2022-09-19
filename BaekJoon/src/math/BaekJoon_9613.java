package math;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9613, GCD 합
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 탐색을 돌면서 두 수를 뽑을 수 있는 조합 탐색
 * 	2. 두 수를 뽑았으면 GCD를 구해 Set에 저장
 * 	3. 모든 GCD를 구했으면 GCD의 합 출력
 *
 */
public class BaekJoon_9613 {
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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			for (int j=0; j<N-1; j++) {
				for (int k=j+1; k<N; k++) {
					int a = arr[j];
					int b = arr[k];
					sum += getGCD(a, b);
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
