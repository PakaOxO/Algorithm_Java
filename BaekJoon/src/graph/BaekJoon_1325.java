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
	static int N, M;
	static List<Integer>[] connectNode;
	static Set<Integer>[] connectNodeAll;
	static List<Integer>[] cnt;
	static int max;
	
	static void bfs(int start, int N) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.add(start);
		visited[start] = true;
		
		while (q.size() > 0) {
			int curr = q.remove();
			for (int i=0; i<connectNode[curr].size(); i++) {
				int next = connectNode[curr].get(i);
				if (visited[next]) continue;
				
				if (curr > next) {
					Iterator<Integer> it = connectNodeAll[next].iterator();
					while (it.hasNext()) {
						connectNodeAll[start].add(it.next());
					}
				} else {
					q.add(next);
				}
				connectNodeAll[start].add(next);
				visited[next] = true;
			}
		}
		int size = connectNodeAll[start].size();
		cnt[size].add(start);
		if (size > max) max = size;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		connectNode = new ArrayList[N + 1];
		connectNodeAll = new HashSet[N + 1];
		cnt = new ArrayList[N];
		for (int i=0; i<=N; i++) {
			connectNode[i] = new ArrayList<>();
			connectNodeAll[i] = new HashSet<>();
			if (i < N) cnt[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connectNode[b].add(a);
		}
		
		for (int i=1; i<=N; i++) {
			bfs(i, N);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<cnt[max].size(); i++) {
			if (i < cnt[max].size() - 1) sb.append(cnt[max].get(i)).append(" ");
			else sb.append(cnt[max].get(i));
		}
		System.out.print(sb);
		br.close();
	}

}
