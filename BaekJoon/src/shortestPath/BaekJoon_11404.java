package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11404, 플로이드
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 각각의 시작 지점에서 다른 끝 지점에 대해 모든 최단거리를 구하는 문제
 * 	2. 아직 플로이드-워셜 기법에 대해 공부하기 전이므로 다익스트라로 먼저 풀이
 *
 */
public class BaekJoon_11404 {
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

	static final int INF = Integer.MAX_VALUE;
	static int V, E;
	static Node[] adjList;
	static int[][] dist;
	static boolean[] isVisited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adjList = new Node[V];
		for (int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s] = new Node(e, w, adjList[s]);
		}
		br.close();
		
		dist = new int[V][V];
		for (int i=0; i<V; i++) {
			isVisited = new boolean[V];
			Arrays.fill(dist[i], INF);
			dijkstra(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (j < V - 1) {
					if (dist[i][j] == INF) sb.append(0);
					else sb.append(dist[i][j]);
					
					sb.append(" ");
				}
				else {
					if (dist[i][j] == INF) sb.append(0);
					else sb.append(dist[i][j]);
					
					sb.append("\n");
				}
			}
		}
		System.out.print(sb);
	}

}
