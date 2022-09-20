package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1260, DFS와 BFS
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. DFS, BFS 메서드를 작성해 그래프를 탐색하는 순서를 기록한 뒤 모든 탐색이 종료되면 출력
 *
 */
public class BaekJoon_1260 {
	static int N, M, V;
	static boolean[][] graph;
	static boolean[] dfsVisited;
	static StringBuilder dfsPath;
	static StringBuilder bfsPath;
	
	static void dfs(int curr) {
		dfsVisited[curr] = true;
		dfsPath.append(curr).append(" ");
		
		for (int i=1; i<=N; i++) {
			if (dfsVisited[i] || !graph[curr][i]) continue;
			dfs(i);
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		boolean[] isVisited = new boolean[N + 1];
		isVisited[V] = true;
		bfsPath.append(V).append(" ");
		
		while (q.size() > 0) {
			int curr = q.remove();
			for (int i=1; i<=N; i++) {
				if (isVisited[i] || !graph[curr][i]) continue;
				q.add(i);
				isVisited[i] = true;
				bfsPath.append(i).append(" ");
			}
		}
	}
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N + 1][N + 1];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}
		
		dfsPath = new StringBuilder();
		bfsPath = new StringBuilder();
		
		dfsVisited = new boolean[N + 1];
		dfs(V);
		bfs();
		
		System.out.println(dfsPath);
		System.out.println(bfsPath);
		br.close();
	}

}
