package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11404_2, 플로이드
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 이전에 다익스트라로 풀었던 문제, 플로이드-워셜로 재풀이
 * 	2. 처음에 인접 행렬을 만들 때 중복된 경로에 대한 입력이 들어올 수 있으므로
 * 	미리 적당히 큰 값으로 가중치를 초기화한 뒤 입력 받을 때마다 작은 값으로 초기화
 *
 */
public class BaekJoon_11404_2 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int V, E;
	static int[][] adjArr, dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		adjArr = new int[V + 1][V + 1];
		for (int[] arr : adjArr) Arrays.fill(arr, INF);
		
		for (int i=0; i<E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjArr[s][e] = Math.min(adjArr[s][e], w);
		}
		br.close();
		
		/* dist 초기화 */
		dist = new int[V + 1][V + 1];
		for (int i=1; i<=V; i++) {
			for (int j=1; j<=V; j++) {
				if (i == j) dist[i][j] = 0;
				else if (adjArr[i][j] != 0) dist[i][j] = adjArr[i][j];
				else dist[i][j] = INF;
			}
		}
		
		/* 플로이드 워셜 */
		for (int k=1; k<=V; k++) {
			for (int i=1; i<=V; i++) {
				if (k == i) continue;
				for (int j=1; j<=V; j++) {
					if (j == i || j == k) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=V; i++) {
			for (int j=1; j<=V; j++) {
				sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
