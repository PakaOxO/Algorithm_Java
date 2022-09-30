package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16398, 행성 연결
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 모든 행성간의 연결에 대한 가중치가 주어지므로 간선의 수는 (N-1)!
 * 	2. 정점을 선택하는 쪽이 빠를 것으로 예상되므로 Prim MST 사용
 *
 */
public class BaekJoon_16398 {
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
			return this.w <= o.w ? -1 : 1;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V;
	static Node[] adjList;
	static boolean[] isVisited;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		adjList = new Node[V];
		isVisited = new boolean[V];
		dist = new int[V];
		for (int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<V; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i == j) continue;
				adjList[i] = new Node(j, w, adjList[i]);
			}
		}
		
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0));
		dist[0] = 0;
		
		int cnt = 0;
		long answer = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			answer += dist[curr.v];
			if (++cnt == V) break;
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) {
				if (isVisited[next.v] || dist[next.v] <= next.w) continue;
				
				dist[next.v] = next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
		}
		System.out.println(answer);
	}

}
