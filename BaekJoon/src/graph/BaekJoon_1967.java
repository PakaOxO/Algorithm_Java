package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1967, 트리의 지름
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 leaf 노드들을 찾아 List에 저장
 * 	2. 각 leaf 노드에서 시작하는 dfs 탐색을 진행해 distance의 최대값을 찾아 출력
 * 	-> 모든 leaf에서 dfs탐색을 진행하므로 시간이 너무 오래걸림
 * 
 * 	(영묵님 코드 참고)
 * 	1. 먼저 루트노드에서 dfs 탐색을 하면서 distance가 최대인 leaf 노드를 찾음
 * 	2. 해당 leaf 노드에서 시작하는 dfs 탐색을 실시해 최대값 도출
 *
 */
public class BaekJoon_1967 {
	static class Node {
		int vertex, weight;
		
		Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int N, max, pointer;
	static List<Node>[] conn;
	static boolean[] isVisited;
	
	static void dfs(int node, int dist) {
		if (dist > max) {
			max = dist;
			pointer = node;
		}
		
		if (conn[node] == null) return;
		for (Node next : conn[node]) {
			if (isVisited[next.vertex]) continue;
			isVisited[next.vertex] = true;
			dfs(next.vertex, dist + next.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		conn = new ArrayList[N + 1];
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			if (conn[from] == null) conn[from] = new ArrayList<>();
			conn[from].add(new Node(to, weight));
			if (conn[to] == null) conn[to] = new ArrayList<>();
			conn[to].add(new Node(from, weight));
		}
		br.close();
		
		max = 0;
		pointer = 0;
		isVisited = new boolean[N + 1];
		isVisited[1] = true;
		dfs(1, 0);
		
		max = 0;
		isVisited = new boolean[N + 1];
		isVisited[pointer] = true;
		dfs(pointer, 0);
		
		System.out.println(max);
	}

}
