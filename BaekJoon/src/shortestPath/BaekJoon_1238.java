package shortestPath;

import java.io.*;
import java.util.*;


/**
 * BaekJoon_1238, 파티
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 모든 출발지(1~N)에 대해 파티장까지 가는 경로와 파티장에서 모든 출발지로 되돌아가는 경로의 합이 가장 큰 값을 산출
 * 	2. 다익스트라로 모든 경로에 대한 최단거리를 산출한 뒤 1에서 설명한 대로 최대값을 품
 *
 */
public class BaekJoon_1238 {
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
	static int N, M, X;
	static Node[] adjList;
	static int[][] dist;
	static boolean[] isVisited;
	
	static void dijkstra(int s) {
		isVisited = new boolean[N + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		
		Arrays.fill(dist[s], INF);
		dist[s][s] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			if (++cnt == N) break;
			
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		adjList = new Node[N + 1];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[s] = new Node(e, w, adjList[s]);
		}
		br.close();
		
		dist = new int[N + 1][N + 1];
		for (int i=1; i<=N; i++) {
			dijkstra(i);
		}
		
		int max = 0;
		for (int i=1; i<=N; i++) {
			max = Math.max(max, dist[i][X] + dist[X][i]);
		}
		System.out.println(max);
	}

}
