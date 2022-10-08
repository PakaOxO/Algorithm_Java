package shortestPath;

import java.io.*;
import java.util.*;


/**
 * BaekJoon_1613, 역사
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 이전에 풀었던 저울문제와 같은 문제
 * 	2. 전후 관계를 증명할 수 있음은 저울의 무게 크기 관계를 나타낼 수 있는가와 같은 질문
 *
 */
public class BaekJoon_1613 {
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
			return this.w < o.w ? -1 : 1;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static Node[] adjList;
	static int[][] dist;
	static boolean[] isVisited;
	
	static void dijkstra(int s) {
		isVisited = new boolean[V + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		
		Arrays.fill(dist[s], INF);
		dist[s][s] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			if (++cnt == V) break;
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) {
				if (isVisited[next.v] || dist[s][next.v] <= dist[s][curr.v] + next.w) continue;
				dist[s][next.v] = dist[s][curr.v] + next.w;
				pq.offer(new Node(next.v, dist[s][next.v]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
	
		adjList = new Node[V + 1];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adjList[s] = new Node(e, 1, adjList[s]);
		}
		
		dist = new int[V + 1][V + 1];
		for (int i=1; i<=V; i++) {
			dijkstra(i);
		}

		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		for (int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (dist[A][B] == INF && dist[B][A] == INF) sb.append("0\n");
			else if (dist[A][B] != INF) sb.append("-1\n");
			else sb.append("1\n");
		}
		br.close();
		System.out.print(sb);
	}

}
