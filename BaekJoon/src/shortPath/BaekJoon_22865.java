package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_22865, 가장 먼 곳
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
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
	static int[] house;
	static int[][] dist;
	static boolean[] isVisited;
	static Node[] adjList;
	
	static void dijkstra(int idx, int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		dist[idx][s] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
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
		
		house = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		house[0] = Integer.parseInt(st.nextToken()) - 1;
		house[1] = Integer.parseInt(st.nextToken()) - 1;
		house[2] = Integer.parseInt(st.nextToken()) - 1;

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
		for (int[] d : dist) Arrays.fill(d, INF);
		for (int i=0; i<3; i++) {
			isVisited = new boolean[V];
			dijkstra(i, house[i]);
		}
		
		int max = 0;
		int answer = 0;
		for (int i=0; i<V; i++) {
			int min = Integer.MAX_VALUE;
			for (int j=0; j<3; j++) {
				if (house[j] == i) continue;
				if (dist[j][i] < min) {
					min = dist[j][i];
				}
			}
			if (min > max) {
				max = min;
				answer = i;
			}
		}
		System.out.println(answer + 1);
	}

}
