package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2798, 블랙잭
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 완전탐색을 사용해 세 장의 카드를 뽑을 수 있는 모든 조합을 찾아 숫자의 합을 계산
 * 	2. 리턴 조건
 * 		2.1 카드 합이 M보다 커지면
 * 		2.2 카드가 3개 선택되었으면
 * 	3. 카드가 3개 선택되었을 때 최대 합(M보다 크지는 않음)을 max에 저장
 * 	4. 완전탐색 종료 후 max 출력
 *
 */
public class BaekJoon_2798 {
	static int N, M;
	static int[] cards;
	static int max;
	
	static void dfs(int start, int cnt, int sum) {
		if (sum > M) return;
		
		if (cnt == 3) {
			if (sum > max) max = sum;
			return;
		}
		
		for (int i=start; i<N; i++) {
			dfs(i + 1, cnt + 1, sum + cards[i]);
		}
	}

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		dfs(0, 0, 0);
		
		System.out.println(max);
		br.close();
	}

}
