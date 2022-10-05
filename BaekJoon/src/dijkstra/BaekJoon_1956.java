package dijkstra;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1956, 운동
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 시작-끝, 끝-시작 지점에 대해 다익스트라로 최단 경로를 구한 후
 * 	2. 두 최단 경로를 합한 값을 출력
 *
 */
public class BaekJoon_1956 {
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
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
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
		
		adjList = new Node[V];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s] = new Node(e, w, adjList[s]);
		}
		br.close();
		
		dist = new int[V][V];
		for (int i=0; i<V; i++) {
			Arrays.fill(dist[i], INF);
			isVisited = new boolean[V];
			dijkstra(i);
		}
		
		int min = INF;
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (i == j || dist[i][j] == INF || dist[j][i] == INF) continue;
				min = Math.min(min, dist[i][j] + dist[j][i]);
			}
			
		}
		
		if (min == INF) System.out.println(-1);
		else System.out.println(min);
	}

}
