package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1753, 최단경로
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 다익스트라 최단경로 알고리즘 사용
 *
 */
public class BaekJoon_1753 {
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
	static int[] dist;
	static boolean[] isVisited;
	static Node[] adjList;
	
	static void dijkstra(int s) {
		isVisited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true; 
			cnt++;
			if (cnt == V) break;
			
			for (Node next = adjList[curr.v]; next!=null; next=next.next) {
				if (!isVisited[next.v]&& dist[next.v] > dist[curr.v] + next.w) {
					dist[next.v] = dist[curr.v] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		
		adjList = new Node[V + 1];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[start] = new Node(end, weight, adjList[start]);
		}
		br.close();
		
		dijkstra(s);
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=V; i++) {
			if (dist[i] == INF) sb.append("INF\n");
			else sb.append(String.format("%d\n", dist[i]));
		}
		System.out.println(sb);
	}

}
