package bitmasking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1182, 부분수열의 합
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 비트마스킹을 활용한 조합 문제
 * 	2. 1부터 1<<N까지의 조합(1개 이상 뽑는 경우)에서 뽑힌 요소 체크(& 연산)
 *
 */
public class BaekJoon_1182 {
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int answer = 0;
		for (int i=1; i<(1<<N); i++) {
			int sum = 0;
			for (int j=0; j<N; j++) {
				if ((i & (1 << j)) > 0) sum += arr[j];
			}
			if (sum == S) answer++;
		}
		System.out.println(answer);
	}

}
