package backtracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BaekJoon_15650, N과 M (2)
 * @author kevin-Arpe
 * 
 * Sketch idea
 * 	1. 이번 문제는 조합이기 때문에 (1, 4) 와 (4, 1)을 구분하지 않습니다. 재귀로 호출하는 함수에 이전 선택 값(start)을 파라미터로 넘겨 중복 조합을 선택하지 않도록 했습니다. 
 * 	2. dfs 메서드가 넘겨받는 파라미터(start)로 이전 값 이후의 값들부터 조회하므로 isVisited 배열을 사용한 메모이제이션은 필요하지 않습니다.
 * 
 */
public class BaekJoon_15650 {
	static int N, M;
	static StringBuilder sb;
	
	static void dfs(int cnt, int start, String comb) {
		if (cnt == M) {
			sb.append(comb).append("\n");
			return;
		}
		for (int i=start; i<=N; i++) {
			if (cnt == 0) dfs(cnt + 1, i + 1, comb + i);
			else dfs(cnt + 1, i + 1, comb + " " + i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		dfs(0, 1, "");
		System.out.print(sb);
		br.close();
	}

}
