package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1325, 효율적인 해킹 
 * 	
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 모든 노드를 순회하며 BFS 탐색 
 * 	2. 
 *
 */
public class BaekJoon_1325 {
	static int N, M, max;
	static List<Integer>[] list;
	static int[] cnt;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N + 1];
		q.offer(start);
		isVisited[start] = true;
		
		int count = 0;
		while (q.size() > 0) {
			int curr = q.poll();
			for (int next : list[curr]) {
				if (isVisited[next]) continue;
				q.add(next);
				isVisited[next] = true;
				count++;
			}
		}
		cnt[start] = count;
		max = Math.max(max, cnt[start]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}
		
		cnt = new int[N + 1];
		for (int i=1; i<=N; i++) {
			bfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			if (cnt[i] == max) sb.append(i).append(" ");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}