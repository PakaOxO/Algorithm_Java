package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_22865, 가장 먼 곳
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 다익스트라의 시작점을 어디로 할지 판단만 하면 아주 쉬운 문제...
 * 	2. 다익스트라 구현 코드 내부에서 현재 노드 방문체크를 빼먹어서 틀리고 있었음.. 반성.. 
 *
 */
public class BaekJoon_22865 {
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
	static int A, B, C;
	static int[][] dist;
	static boolean[] isVisited;
	static Node[] adjList;
	
	static void dijkstra(int idx, int s) {
		isVisited = new boolean[V];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		Arrays.fill(dist[idx], INF);
		dist[idx][s] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue; 
			isVisited[curr.v] = true;
			
			if (++cnt == V) break;
			for (Node next=adjList[curr.v]; next!=null; next=next.next) { 
				if (isVisited[next.v] || dist[idx][next.v] <= dist[idx][curr.v] + next.w) continue;
				dist[idx][next.v] = dist[idx][curr.v] + next.w;
				pq.offer(new Node(next.v, dist[idx][next.v]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()) - 1;
		B = Integer.parseInt(st.nextToken()) - 1;
		C = Integer.parseInt(st.nextToken()) - 1;

		E = Integer.parseInt(br.readLine());
		
		adjList = new Node[V];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s] = new Node(e, w, adjList[s]);
			adjList[e] = new Node(s, w, adjList[e]);
		}
		br.close();
		
		dist = new int[3][V];
		dijkstra(0, A);
		dijkstra(1, B);
		dijkstra(2, C);
		
		int max = Integer.MIN_VALUE;
		int answer = 0;
		for (int i=0; i<V; i++) {
			int min = Math.min(dist[0][i], Math.min(dist[1][i], dist[2][i]));
			if (min > max) {
				max = min;
				answer = i;
			}
		}
		System.out.println(answer + 1);
	}

}