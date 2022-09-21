package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13023, ABCDE
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 5명이 연속으로 친구가 되는지 체크하면 되므로 DFS 탐색을 통해 depth가 5까지 갈 수 있는지 묻는 문제
 * 	2. 입력을 받으면서 연결정보를 담은 인접 리스트를 생성하고, 해당 인접 리스트에서 인접 노드들을 탐색에 이용
 * 	3. 0번부터 N-1까지 DFS탐색의 시작점으로 사용해 각각 DFS 탐색
 * 		3.1 depth를 들어가며 탐색하는데 depth가 5가 되었으면 이미 조건을 만족했으므로 flag를 true로 두어 남은 탐색을 진행하지 않게
 * 	4. flag가 true면 조건을 만족하므로 1을 false면 만족하지 못했으므로 0을 출력
 *
 */

public class BaekJoon_13023 {
	static int N, M;
	static List<Integer>[] conn;
	static boolean[] isVisited;
	static boolean flag;
	
	static void dfs(int curr, int depth) {
		if (depth == 5) {
			flag = true;
			return;
		}
		for (int next : conn[curr]) {
			if (flag) break;
			if (isVisited[next]) continue;
			isVisited[next] = true;
			dfs(next, depth + 1);
			isVisited[next] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		conn = new ArrayList[N];
		isVisited = new boolean[N];
		for (int i=0; i<N; i++) conn[i] = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			conn[a].add(b);
			conn[b].add(a);
		}
		br.close();
		
		for (int i=0; i<N; i++) {
			isVisited[i] = true;
			dfs(i, 1);
			isVisited[i] = false;
		}
		
		if (flag) System.out.println(1);
		else System.out.println(0);
	}

}
