package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11265, 끝나지 않는 파티
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 처음 입력에서 노드, 노드간 거리 정보는 모두 주고 시작하므로 주어진 노드, 간선 정보에 따라 모든 최단거리를 다익스트라를 통해 구함
 * 	2. 다음 구해야하는 시작, 끝, 시간 입력을 받으면서 시작 지점에서 끝 지점까지 거리와 주어진 제한시간을 비교해 정답을 sb에 저장
 * 	3. sb 출력
 *
 */
public class BaekJoon_11265 {
	static class Pos implements Comparable<Pos> {
		int v, w;
		
		Pos(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Pos o) {
			return this.w < o.w ? -1 : 1;
		}
	}
	
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static int[][] adjArr;
	static int[][] dist;
	static boolean[] isVisited;
	
	static void dijkstra(int s) {
		isVisited = new boolean[N];
		Arrays.fill(dist[s], INF);
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(s, 0));
		dist[s][s] = 0;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Pos curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			
			if (++cnt == N) break;
			
			for (int i=0; i<N; i++) {
				if (i == curr.v || adjArr[curr.v][i] == 0 || isVisited[i] || dist[s][i] <= dist[s][curr.v] + adjArr[curr.v][i]) continue;
				
				dist[s][i] = dist[s][curr.v] + adjArr[curr.v][i];
				pq.offer(new Pos(i, dist[s][i]));
			}
		}
		
		for (int i=0; i<N; i++) {
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjArr = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dist = new int[N][N];
		for (int i=0; i<N; i++) {
			dijkstra(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			if (dist[s][e] <= t) sb.append("Enjoy other party\n");
			else sb.append("Stay here\n");
		}
		br.close();
		System.out.print(sb);
	}

}
