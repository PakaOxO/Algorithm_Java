package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14938, 서강 그라운드
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 시작 지점은 주어지지 않으므로 일단 주어진 간선 정보를 가지고 모든 시작지점에 대해 다익스트라 탐색으로 최단거리 도출
 * 	2. 각 시작 지점에 대한 최단거리를 확인해 주어진 최대 이동거리 M보다 작다면 아이템 개수 합(sum)
 * 	3. 모든 출발지점에 대해 아이템 총 합을 max와 비교해 최대값 갱신
 *
 */
public class BaekJoon_14938 {
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
	static int N, M, R, max;
	static int[] item;
	static int[][] dist;
	static boolean[] isVisited;
	static Node[] adjList;
	
	static void dijkstra(int s) {
		Arrays.fill(dist[s], INF);
		isVisited = new boolean[N];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
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
		R = Integer.parseInt(st.nextToken());

		item = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new Node[N];
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			
			adjList[s] = new Node(e, w, adjList[s]);
			adjList[e] = new Node(s, w, adjList[e]);
		}
		br.close();
		
		max = 0;
		dist = new int[N][N];
		for (int i=0; i<N; i++) {
			dijkstra(i);
			int sum = 0;
			for (int j=0; j<N; j++) {
				if (dist[i][j] <= M) sum += item[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
