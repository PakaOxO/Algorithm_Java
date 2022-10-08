package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11657, 타임머신 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 벨만-포드 알고리즘은 아직 공부하기 전이므로 플로이드-워셜 알고리즘을 사용 (다익스트라는 음의 가중치 문제는 해결 불가)
 * 	2. 중복된 간선의 정보가 나올 수 있으므로 가중치가 가장 작은 간선으로 입력시마다 간선 초기화  
 *
 */
public class BaekJoon_11657 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int V, E;
	static int[][] dist;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V][V];
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (i == j) continue;
				dist[i][j] = INF;
			}
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			dist[s][e] = Math.min(dist[s][e], w);
		}
		br.close();
		
		for (int k=0; k<V; k++) {
			for (int i=0; i<V; i++) {
				if (i == k) continue;
				for (int j=0; j<V; j++) {
					if (j == k) continue;
					if (dist[i][j] <= dist[i][k] + dist[k][j]) continue;
					dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<V; i++) {
			if (i == 0) {
				if (dist[0][0] < 0) {
					sb.append("-1\n");
					break;
				}
				continue;
			}
			
			if (dist[0][i] < INF >> 2) {
				if (dist[i][i] < 0) {
					sb.delete(0, sb.length());
					sb.append("-1\n");
					break;
				} else {
					sb.append(dist[0][i]).append("\n");
				}
			} else {
				sb.append("-1\n");
			}
		}
		System.out.print(sb);
	}

}
