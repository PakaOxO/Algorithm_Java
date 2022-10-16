package backtracking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_10971, 외판원 순회 2
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 전체적인 흐름은 순열문제이다.
 * 	2. 먼저 dfs 탐색을 하기전 가장 처음 방문할 도시를 선택한다.
 *  3. 방문할 도시를 나열한 순열을 구하되 다음과 같은 조건에서는 return하여 분기를 종료해야한다.
 * 		2.1 현재 도시에서 방문할 수 없는 경우 (map[curr][next] = 0)
 * 		2.2 현재까지 비용이 이전에 계산된 최소 비용을 넘어선 경우
 * 		2.3 N개의 도시를 모두 방문한 경우
 * 	4. N개의 도시를 모두 방문하여 cnt = N이 되었을 때, 코스트에 가장 처음 도시로 돌아가는 비용을 더해준 다음에 최소값을 구해야한다.
 * 		4.1 처음 도시를 저장하는 방법은 클래스 변수로 멤버변수로 dfs 탐색 전에 저장하는 방식을 사용하거나 아예 매개변수로 넘기는 방법을 사용해도 된다.
 *
 */
public class BaekJoon_10971 {
	static int N;
	static int[][] map;
	static boolean[] isVisited;
	static int start;
	static int min;
	
	static void dfs(int curr, int cnt, int sum) {
		if (cnt == N) {
			if (map[curr][start] == 0) return;
			sum += map[curr][start];
			if (sum < min) min = sum;
			return;
		}
		if (sum >= min) return;
		
		for (int i=0; i<N; i++) {
			if (curr == i || isVisited[i] || map[curr][i] == 0) continue;
			isVisited[i] = true;
			dfs(i, cnt + 1, sum + map[curr][i]);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			isVisited = new boolean[N];
			isVisited[i] = true;
			start = i;
			dfs(i, 1, 0);
		}
		
		System.out.println(min);
		br.close();
	}

}
