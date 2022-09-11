package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2961, 도영이가 만든 맛있는 음식
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 1 ~ N개의 뽑을 수 있는 모든 조합을 탐색
 * 	2. 각 조합 별 요리의 신맛, 쓴맛을 계산
 * 		2.1 dfs를 돌면서 신맛, 쓴맛의 차가 이전 최소값보다 크다면 return
 * 		2.2 모든 조합에서 신맛, 쓴맛의 차이가 가장 적은 값을 min에 저장
 * 	3. 탐색 종료 후, min 출력
 *
 */
public class BaekJoon_2961 {
	static int N;
	static int[][] g;
	static int min;
	
	static void dfs(int start, int cnt, int bit, int sw) {
		if (cnt > 0) min = Math.min(min, Math.abs(bit - sw));
		
		for (int i=start; i<N; i++) {
			dfs(i + 1, cnt + 1, bit * g[i][0], sw + g[i][1]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		g = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			g[i][0] = Integer.parseInt(st.nextToken());
			g[i][1] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		dfs(0, 0, 1, 0);
		
		System.out.println(min);
		br.close();
	}

}
