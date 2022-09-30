package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1647, 도시 분할 계획
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Kruskal MST 사용
 * 	2. 2개의 도시로 쪼개면되므로 크루스칼 알고리즘을 통해 MST를 구하되 V-1개의 간선이 아닌 V-2개의 간선만 선택하도록
 * 	3. V-2개의 간선을 선택하면서 가중치 누적
 * 	4. 누적된 가중치를 출력
 *
 */
public class BaekJoon_1647 {
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
	static Edge[] edges;
	
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
		edges = new Edge[E];
		for (int i=1; i<=V; i++) p[i] = i;
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
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
		});
		
		int answer = 0;
		int cnt = 0;
		for (int i=0; i<E; i++) {
			Edge e = edges[i];
			boolean flag = union(e.s,e.e);
			if (flag) {
				answer += e.w;
				cnt++;
				if (cnt == V - 2) break;
			}
		}
		System.out.println(answer);
	}

}
