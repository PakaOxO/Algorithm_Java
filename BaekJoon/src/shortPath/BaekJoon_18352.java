package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18352, 특정 거리의 도시 찾기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 인접 노드에서 탐색 우선 순위는 가까우면서 노드 번호의 크기가 작은 곳 
 * 	2. 다익스트라 알고리즘으로 해당 우선 순위에 맞게 탐색하면서 거리가 주어진 만큼인 노드에 도착하면 해당 노드를 답(sb)에 저장 
 *
 */
public class BaekJoon_18352 {
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
			if (this.w == o.w) {
				return this.v < o.v ? -1 : 1;
			}
			return this.w < o.w ? -1 : 1;
		}
		
	}
	static final int INF = Integer.MAX_VALUE;
	static int V, E, D, S, answer;
	static Node[] adjList;
	static int[] dist;
	static boolean[] isVisited;
	static StringBuilder sb;
	
	static void dijkstra(int s) {
		isVisited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		dist[s] = 0;
		
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			
			if (curr.w == D) sb.append(curr.v).append("\n");
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) { 
				if (isVisited[next.v] || dist[next.v] <= dist[curr.v] + next.w) continue;
				dist[next.v] = dist[curr.v] + next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		adjList = new Node[V + 1];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjList[s] = new Node(e, 1, adjList[s]);
		}
		
		dijkstra(S);
		
		if (sb.length() == 0) sb.append("-1\n");
		System.out.print(sb);
	}

}
