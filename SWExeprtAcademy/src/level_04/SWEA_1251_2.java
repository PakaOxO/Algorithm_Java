package level_04;

import java.io.*;
import java.util.*;

/**
 * SWEA_1251, 하나로 (Prim MST)
 * @author kevin-Arpe
 *
 */
public class SWEA_1251_2 {
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
	static int[][] pos;
	static boolean[] isVisited;
	static long[] minDist;
	
	static long getDist(int a, int b) {
		return (long)(Math.pow(pos[a][0] - pos[b][0], 2) + Math.pow(pos[a][1] - pos[b][1], 2));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			pos = new int[N][2];
			for (int i=0; i<N; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st2.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			
			isVisited = new boolean[N];
			minDist = new long[N];
			Arrays.fill(minDist, INF);
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			
			int cnt = 0;
			double dist = 0;
			while (pq.size() > 0) {
				Node curr = pq.poll();
				if (isVisited[curr.v]) continue; 
				isVisited[curr.v] = true; 
				dist += curr.w;
				cnt++;
				if (cnt == N) break;
				
				for (int i=0; i<N; i++) {
					long d = getDist(curr.v, i);
					if (isVisited[i] || minDist[i] <= d) continue;
					minDist[i] = d;
					pq.offer(new Node(i, d));
				}
			}
			sb.append(String.format("#%d %d\n", tc, Math.round(dist * E)));
		}
		br.close();
		System.out.println(sb);
	}

}
