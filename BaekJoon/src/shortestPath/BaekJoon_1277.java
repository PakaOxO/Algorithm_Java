package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1277, 발전소 설치
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 이미 연결된 간선 정보를 인접 연결 리스트에 미리 저장
 * 	2. 다익스트라 탐색을 하면서 
 *
 */
public class BaekJoon_1277 {
	static class Node implements Comparable<Node> {
		int v;
		double w;
		Node next;
		
		Node(int v, double w) {
			this.v = v;
			this.w = w;
		}
		
		Node(int v, double w, Node next) {
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
	static int N, W;
	static double M;
	static int[][] pos;
	static double[] dist;
	static boolean[] isVisited;
	static Node[] adjList;
	
	static double getDist(int s, int e) {
		return Math.sqrt(Math.pow(Math.abs(pos[s][0] - pos[e][0]), 2) + Math.pow(Math.abs(pos[s][1] - pos[e][1]), 2));
	}
	
	static void dijkstra() {
		dist = new double[N];
		Arrays.fill(dist, INF);
		isVisited = new boolean[N];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0));
		dist[0] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			
			if (++cnt == N) break;
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) {
				if (isVisited[next.v]) continue;
				dist[next.v] = dist[curr.v]; 
				pq.offer(new Node(next.v, dist[next.v]));
			}
			
			for (int i=0; i<N; i++) {
				if (curr.v == i || isVisited[i]) continue;
				double d = getDist(curr.v, i);
				if (d > M || dist[i] <= dist[curr.v] + d) continue;
				
				dist[i] = dist[curr.v] + d;
				pq.offer(new Node(i, dist[i]));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		M = Double.parseDouble(br.readLine());
		
		pos = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new Node[N];
		for (int i=0; i<W; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			adjList[s] = new Node(e, 0, adjList[s]);
			adjList[e] = new Node(s, 0, adjList[e]);
		}
		br.close();
		
		dijkstra();
		System.out.println(String.format("%d", (int)(dist[N - 1] * 1000)));
	}

}
