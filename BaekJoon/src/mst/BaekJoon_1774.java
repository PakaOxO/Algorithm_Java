package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1774, 우주신과의 교감
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Prim MST 풀이 방식 채택, 연결 통로는 모든 노드들 간에 생성 될 수 있으므로 Kruskal보단 Prim이 유리 
 * 	2. 위치 정보를 pos 배열에 입력 받은 뒤 1(빵상 아주머니) 위치에서 시작(pq에 삽입)
 * 	3. 만약 미리 연결된 정보를 받았다면 둘 사이의 연결 정보를 connected 배열에 저장 	
 * 	4. pq에서 노드를 선택할 때 curr 위치에서 다음 위치가 connected에 저장되어 있다면 이미 방문한 셈치고 큐에 담음	 	
 * 		4.1 이미 연결되어 있으므로 추가할 거리는 0
 *
 */
public class BaekJoon_1774 {
	static class Node implements Comparable<Node> {
		int v;
		double w;
		
		Node(int v, double w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w < o.w ? -1 : 1;
		}
	}
	
	static final long INF = Long.MAX_VALUE;
	static int V, E;
	static Node[] adjList;
	static int[][] pos;
	static boolean[][] isConnected;
	static boolean[] isVisited;
	static double[] dist;
	
	static double getDist(int a, int b) {
		return Math.sqrt(Math.pow(pos[a][0] - pos[b][0], 2) + Math.pow(pos[a][1] - pos[b][1], 2));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		isVisited = new boolean[V + 1];
		pos = new int[V + 1][2];
		for (int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		isConnected = new boolean[V + 1][V + 1];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			isConnected[s][e] = true;
			isConnected[e][s] = true;
		}
		
		isVisited = new boolean[V + 1];
		dist = new double[V + 1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		dist[1] = 0;
		
		int cnt = 0;
		double answer = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true; 
			answer += curr.w;
			if (++cnt == V) break;
			for (int i=1; i<=V; i++) {
				if (curr.v == i || isVisited[i]) continue;
				
				if (isConnected[curr.v][i]) {
					dist[i] = 0;
					pq.offer(new Node(i, 0));
					continue;
				}
				
				double d = getDist(curr.v, i);
				if (dist[i] <= d) continue;
				dist[i] = d;
				pq.offer(new Node(i, d));
			}
		}
		System.out.println(String.format("%.2f", answer));
	}

}
