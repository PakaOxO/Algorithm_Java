package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1197, 최소 스패닝 트리 (Prim MST)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. MST를 구하되 정점과 간선의 개수가 많아 우선순위큐로 Prim MST 구현
 * 	
 *
 */
public class BaekJoon_1197 {
	static class Edge implements Comparable<Edge> {
		int s, e, w;
		
		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
				
		List<Edge>[] adjList = new ArrayList[V + 1];
		for (int i=0; i<=V; i++) adjList[i] = new ArrayList<>();
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[s].add(new Edge(s, e, w));
			adjList[e].add(new Edge(e, s, w));
		}
		br.close();
		
		boolean[] isVisited = new boolean[V + 1];
		isVisited[1] = true;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(adjList[1]);
		
		int cnt = 1;
		int answer = 0;
		while (cnt < V) {
			Edge edge = pq.poll();
			if (isVisited[edge.e]) continue;
			
			isVisited[edge.e] = true;
			pq.addAll(adjList[edge.e]);
			
			answer += edge.w;
			cnt++;
		}
		System.out.println(answer);
	}
}
