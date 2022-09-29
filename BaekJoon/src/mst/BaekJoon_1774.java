package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1774, 우주신과의 교감
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Prim MST를 계산하면서 이미 연결되어 있는 거리와 노드를 방문처리
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
	
	static Node[] adjList;
	static int[][] pos;
	static boolean[] isVisited;
	static double[] minDist;
	
	static double getDist(int a, int b) {
		return Math.sqrt(Math.pow(pos[a][0] - pos[b][0], 2) + Math.pow(pos[a][1] - pos[b][1], 2));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		pos = new int[V + 1][2];
		for (int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pos[i][0] = x;
			pos[i][1] = y;
		}
		
		minDist = new double[V + 1];
		Arrays.fill(minDist, Long.MAX_VALUE);
		isVisited = new boolean[V + 1];
		double dist = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int cnt = 0;
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			if (!isVisited[v1]) {
				pq.offer(new Node(v1, 0));
				isVisited[v1] = true;
			}
			if (!isVisited[v2]) {
				pq.offer(new Node(v2, 0));
				isVisited[v2] = true;
			}
			dist += getDist(v1, v2);
		}
		br.close();
		
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			dist += curr.w;
			cnt++;
			if (cnt == V) break;
			
			for (int i=1; i<=V; i++) {
				if (curr.v == i || isVisited[i]) continue;
				double d = getDist(curr.v, i);
				pq.offer(new Node(i, d));
			}
		}
		System.out.println(dist);
	}

}
