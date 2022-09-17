package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11725, 트리의 부모 
 * @author kevin-Arpe 
 * 
 * Sketch Idea
 * 	1. BFS 탐색을 루트노트(1번 노드)부터 시작하며 다음 노드를 큐에 저장할 때 현재노드(curr)가 해당 노드의 부모이므로 배열에 저
 *
 */
public class BaekJoon_11725 {
	static List<Integer>[] connected;
	static int[] parent;
	
	static void bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N + 1];
		q.add(1);
		isVisited[1] = true;
		
		while (q.size() > 0) {
			int curr = q.remove();
			for (int i=0; i<connected[curr].size(); i++) {
				int next = connected[curr].get(i);
				if (isVisited[next]) continue;
				q.add(next);
				isVisited[next] = true;
				parent[next] = curr;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		connected = new ArrayList[N + 1];
		for (int i=1; i<=N; i++) {
			connected[i] = new ArrayList<>();
		}
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connected[a].add(b);
			connected[b].add(a);
		}
		
		parent = new int[N + 1];
		bfs(N);
		
		StringBuilder sb = new StringBuilder();
		for (int i=2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
