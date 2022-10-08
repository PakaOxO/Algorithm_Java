package shortestPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1507, 궁금한 민호 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. Floyd-warshall 알고리즘을 돌리면서 A에서 B로 가는 거리에 최소값이 존재한다면 flag=false로 두고 바로 리턴 
 * 	2. 아니라면 해당 간선을 사용하지 않도록 isNotUse에 true 처리 
 * 		2.1 해당 간선을 사용하지 않게 이전 코드에서는 직접 값을 0으로 수정했었지만 직접 수정할 경우 플로이드-워셜 알고리즘의 반복문을 돌면서
 * 		다른 연결 정보에 영향을 주는 것 같음.. 직접 수정하는 대신 위처럼 다른 배열에 사용하지 않겠다는 처리를 하니 맞았음 
 *
 */
public class BaekJoon_1507 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N;
	static int[][] dist;
	static boolean[][] isNotUse;
	static boolean flag;
	
	static void floydWarshall() {
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				if (i == k) continue;
				for (int j=0; j<N; j++) {
					if (j == i || j == k) continue;
					if (dist[i][j] == dist[i][k] + dist[k][j]) {
						isNotUse[i][j] = true;
					} else if (dist[i][j] > dist[i][k] + dist[k][j]) {
						flag = false;
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N][N];
		isNotUse = new boolean[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		flag = true;
		floydWarshall();
		
		if (flag) {
			int total = 0;
			for (int i=0; i<N; i++) {
				for (int j=i; j<N; j++) {
					if (isNotUse[i][j]) continue;
					total += dist[i][j];
				}
			}
			System.out.println(total);
		} else {
			System.out.println(-1);
		}
	}

}
