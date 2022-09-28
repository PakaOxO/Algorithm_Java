package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1197_2, 최소 스패닝 트리 (Kruskal MST)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 가중치가 낮은 간선을 먼저 선택해 나가는 크루스칼 MST 방식으로 재 풀이
 *
 */
public class BaekJoon_1197_2 {
	static class Edge {
		int s, e, w;
		
		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	
	static int V, E;
	static int[] p;
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) return false;
		
		p[py] = px;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		p = new int[V + 1];
		for (int i=0; i<=V; i++) p[i] = i;
		
		Edge[] edges = new Edge[E];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(s, e, w);
		}
		br.close();
		
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});
		
		int cnt = 0;
		int answer = 0;
		for (int i=0; i<E; i++) {
			Edge e = edges[i];
			
			boolean flag = union(e.s, e.e);
			if (flag) {
				cnt++;
				answer += e.w;
			}
			if (cnt == V - 1) break;
		}
		System.out.println(answer);
	}

}
