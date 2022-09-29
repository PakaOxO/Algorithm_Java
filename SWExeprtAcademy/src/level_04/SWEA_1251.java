package level_04;

import java.io.*;
import java.util.*;

/**
 * SWEA_1251, 하나로 (Kruskal MST)
 * @author kevin-Arpe
 *
 */
public class SWEA_1251 {
	static class Node {
		int x, y;
		
		Node() {}
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		int s, e;
		double w;
		
		Edge() {}
		
		Edge(int s, int e ,double w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static List<Node> nList;
	static List<Edge> edges;
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
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			nList = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				Node node = new Node();
				node.x = Integer.parseInt(st.nextToken());
				nList.add(node);
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				nList.get(i).y = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			edges = new ArrayList<>();
			
			for (int i=0; i<nList.size() - 1; i++) {
				for (int j=i+1; j<nList.size(); j++) {
					double aX = nList.get(i).x;
					double aY = nList.get(i).y;
					double bX = nList.get(j).x;
					double bY = nList.get(j).y;
					
					Edge edge1 = null;
					Edge edge2 = null;
					if (aX == bX) {
						edge1 = new Edge(i, j, Math.abs(aY - bY));
						edge2 = new Edge(j, i, Math.abs(aY - bY));
					} else if (aY == bY) {
						edge1 = new Edge(i, j, Math.abs(aX - bX));
						edge2 = new Edge(j, i, Math.abs(aX - bX));
					} else {
						double dist = Math.sqrt(((double)(aX - bX) * (aX - bX)) + ((double)(aY - bY) * (aY - bY)));
						edge1 = new Edge(i, j, dist);
						edge2 = new Edge(j, i, dist);
					}
					edges.add(edge1);
				}
			}
			Collections.sort(edges, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return Double.compare(o1.w, o2.w);
				}
			});
			
			p = new int[N];
			for (int i=0; i<N; i++) p[i] = i;
			
			int cnt = 0;
			double total = 0;
			for (int i=0; i<edges.size(); i++) {
				Edge e = edges.get(i);
				boolean flag = union(e.s, e.e);
				if (flag) {
					cnt++;
					double dist = e.w * e.w;
					total += dist;
					if (cnt == N - 1) break;
				}
			}
			sb.append("#").append(tc).append(" ").append(String.format("%.0f", total * E)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

}
