package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1865, 웜홀
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 웜홀은 시간이 거꾸로 흘러감 = 음의 가중치를 의미하므로 다익스트라로는 풀 수 없는 문제
 * 	2. 벨만-포드 알고리즘은 아직 공부 전이므로 플로이드-워셜로 풀이
 * 	3. 시작점 -> 임의의 목표지점 -> 시작점으로 이동했을 때 거리가 음수가 되는지 체크
 *
 */
public class BaekJoon_1865 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N, M, W;
	static int[][] dist;
	static boolean flag;
	static boolean[] isVisited;
	
	static void fw() {
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				if (i == k) continue;
				for (int j=0; j<N; j++) {
					if (j == k || j == i) continue;
					if (dist[i][j] <= dist[i][k] + dist[k][j]) continue;
					dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
	}
	
	static void dfs(int curr, int d, int s) {
		System.out.println(curr + " " + d);
		if (d != 0 && curr == s) {
			if (d < 0) flag = true;
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (dist[curr][i] == INF || curr == i) continue;
			if (isVisited[i]) continue;
			isVisited[i] = true;
			dfs(i, d  + dist[curr][i], s);
			isVisited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			dist = new int[N + 1][N + 1];
			for (int[] arr : dist) Arrays.fill(arr, INF);
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				dist[s][e] = dist[e][s] = w;
			}
			for (int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				dist[s][e] = -w;
			}
			
			fw();
			
			for (int[] d : dist) System.out.println(Arrays.toString(d));
			System.out.println();
			flag = false;
			for (int i=1; i<=N; i++) {
				isVisited = new boolean[N + 1];
				isVisited[i] = true;
				dfs(i, 0, i);
				isVisited[i] = false;
				if (flag) break;
			}
			
			if (flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		br.close();
		System.out.print(sb);
	}

}
