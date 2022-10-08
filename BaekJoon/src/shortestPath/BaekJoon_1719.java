package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1719, 택배
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 플로이드-워셜을 사용해 푸는 문제
 * 	2. 주어지는 그래프는 양방향 그래프, 플로이드-워셜에서 지난 경로를 찾는 방법 체크
 *
 */
public class BaekJoon_1719 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int V, E;
	static int[][] adjArr, path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjArr = new int[V][V];
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (i == j) continue;
				adjArr[i][j] = INF;
			}
		}
		
		path = new int[V][V];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjArr[s][e] = w;
			adjArr[e][s] = w;
			
			path[s][e] = e + 1;
			path[e][s] = s + 1;
		}
		br.close();
		
		
		for (int k=0; k<V; k++) {
			for (int i=0; i<V; i++) {
				if (k == i) continue;
				for (int j=0; j<V; j++) {
					if (j == k || i == j) continue;
					if (adjArr[i][j] > adjArr[i][k] + adjArr[k][j]) {
						adjArr[i][j] = adjArr[i][k] + adjArr[k][j];
						path[i][j] = path[i][k];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<V; i++) {
			for (int j=0; j<V; j++) {
				if (path[i][j] == 0) sb.append("-");
				else sb.append(path[i][j]);
				
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}