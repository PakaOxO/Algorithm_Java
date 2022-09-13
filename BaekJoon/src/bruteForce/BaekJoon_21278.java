package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21278, 호석이 두 마리 치킨
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력 데이터를 기반으로 그래프 생성
 * 	2. 그래프의 각 정점에서 2개를 선택한 뒤 나머지 정점에 대해 왕복거리 합이 최소가 되는 조합 탐색
 * 	3. 뽑은 두 치킨집에 대해 bfs를 돌면서 나머지 정점까지의 거리를 구한 뒤 두 치킨집 중 가까운 곳의 거리를 반환
 * 	4. 모든 정점들의 치킨집까지 최소 거리를 합한 값을 min과 비교해 더 작을 경우 min에 저장
 * 	5. min을 출력
 *
 */
public class BaekJoon_21278 {
	static int N, M;
	static boolean[][] isConnected;
	static int[] selected;
	static int ansC1, ansC2, ansDist;

	static int getDist() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N + 1];
		int[] dists1 = new int[N + 1];
		isVisited[selected[0]] = true;
		q.add(selected[0]);
		
		while (!q.isEmpty()) {
			int curr = q.remove();
			
			for (int i=1; i<=N; i++) {
				if (i == selected[0] || isVisited[i]) continue;
				if (isConnected[curr][i]) {
					isVisited[i] = true;
					q.add(i);
					dists1[i] = dists1[curr] + 1;
				}
			}
		}
		
		q = new LinkedList<>();
		isVisited = new boolean[N + 1];
		int[] dists2 = new int[N + 1];
		isVisited[selected[1]] = true;
		q.add(selected[1]);
		
		while (!q.isEmpty()) {
			int curr = q.remove();
			
			for (int i=1; i<=N; i++) {
				if (i == selected[1] || isVisited[i]) continue;
				if (isConnected[curr][i]) {
					isVisited[i] = true;
					q.add(i);
					dists2[i] = dists2[curr] + 1;
				}
			}
		}
		
		int sum = 0;
		for (int i=1; i<=N; i++) {
			if (i == selected[0] || i == selected[1]) continue;
			sum += Math.min(dists1[i], dists2[i]);
		}
		return sum * 2;
	}
	
	static void dfs(int start, int depth) {
		if (depth == 2) {
			int d = getDist();
			if (d < ansDist) {
				ansDist = d;
				ansC1 = selected[0];
				ansC2= selected[1];
			}
			return;
		}
		
		for (int i=start; i<=N; i++) {
			selected[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isConnected = new boolean[N + 1][N + 1];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			isConnected[a][b] = true;
			isConnected[b][a] = true;
		}
		
		selected = new int[2];
		ansDist = Integer.MAX_VALUE;
		dfs(1, 0);
		
		StringBuilder sb = new StringBuilder();
		sb.append(ansC1).append(" ").append(ansC2).append(" ").append(ansDist);
		System.out.println(sb);
		br.close();
	}

}
