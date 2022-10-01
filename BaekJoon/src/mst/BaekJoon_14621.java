package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14621, 나만 안되는 연애 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 최대 노드 수 1000, 최대 간선 수 10000
 * 		-> Prim MST : O((1000 + 10000)log(1000)) ... 약 3만 3천 
 * 		-> Kruskal MST : O(10000log10000) ... 약 4만 
 * 		... 별로 차이 없지만 Prim으로 구현 
 * 	2. 간선을 입력 받으면서 남초-남초, 여초-여초는 불가능 하므로 간선 리스트에 추가 X
 * 	3. 나머지는 Prim MST 구
 *
 */
public class BaekJoon_14621 {
	static class Node implements Comparable<Node> {
		int v, w;
		Node next;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		Node(int v, int w, Node next) {
			this.v = v;
			this.w = w;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static boolean[] v, isVisited;
	static Node[] adjList;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		v = new boolean[V];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<V; i++) {
			char c = st.nextToken().charAt(0);
			if (c == 'W') v[i] = true;
		}
		
		adjList = new Node[V];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			if (v[s] == v[e]) continue;
			adjList[s] = new Node(e, w, adjList[s]);
			adjList[e] = new Node(s, w, adjList[e]);
		}
		br.close();
		
		isVisited = new boolean[V];
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0));
		dist[0] = 0;
		
		int cnt = 0;
		int answer = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			
			isVisited[curr.v] = true;
			answer += curr.w;
			if (++cnt == V) break;
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) { 
				if (isVisited[next.v] || dist[next.v] <= next.w) continue;
				dist[next.v] = next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
		}
		
		if (cnt < V) System.out.println(-1);
		else System.out.println(answer);
	}

}
