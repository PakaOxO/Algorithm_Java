package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21924, 도시 건설 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Prim MST 사용, 간선의 개수가 많이 주어질 경우 50만개까지 주어질 수 있으므로..
 * 	2. 전체 가중치 합과 선택된 간선의 가중치 합은 int의 범위를 벗어날 수 있으므로 long으로 선언 
 *
 */
public class BaekJoon_21924 {
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
	static Node[] adjList;
	static boolean[] isVisited;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		long total = 0;
		adjList = new Node[V + 1];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			total += w;
			adjList[s] = new Node(e, w, adjList[s]);
			adjList[e] = new Node(s, w, adjList[e]);
		}
		br.close();
		
		isVisited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		
		int cnt = 0;
		long minDist = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			
			isVisited[curr.v]= true;
			minDist += curr.w;
			if (++cnt == V) break;
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) {
				if (isVisited[next.v] || dist[next.v] <= next.w) continue;
				dist[next.v] = next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
		}
		
		if (cnt < V) System.out.println(-1);
		else System.out.println(total - minDist);
	}

}
