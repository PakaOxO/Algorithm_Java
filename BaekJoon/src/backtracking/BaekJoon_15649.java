package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15649, N과 M (1)
 * @author kevin-Arpe
 * 
 * Sketch idea
 * 	1. 중복 선택을 방지하기 위해 isVisited로 이전 선택 값은 메모이제이션 합니다.
 * 	2. 순열이므로 매 재귀마다 for (1 ~ N)문을 돌면서 이전에 선택되지 않은 값(메모이제이션 체크)이면 추가합니다.
 * 
 */
public class BaekJoon_15649 {
	static StringBuilder sb;
	static boolean[] isSelected;
	
	static void getComb(int N, int M, int cnt, String comb) {
		if (cnt == M) {
			sb.append(comb).append("\n");
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			if (cnt == 0) getComb(N, M, cnt + 1, comb + i);
			else getComb(N, M, cnt + 1, comb + " " + i);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		isSelected = new boolean[N + 1];
		getComb(N, M, 0, "");
		System.out.print(sb);
		br.close();
	}

}
