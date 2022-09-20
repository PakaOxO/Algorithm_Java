package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14502, 연구소
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 지도에서 빈 칸에서 3개를 고르는 조합을 뽑음
 * 	2. 뽑힌 세 곳에 벽을 세우고, 바이러스 위치부터 BFS 탐색
 * 		2.1 바이러스가 전파될 수 있는 공간의 최소값을 도출
 * 	3. 안전구역의 개수는 (원래 void의 개수) - (바이러스가 전파된 void) - (벽을 세운 곳, 3개)
 *
 */
public class BaekJoon_14502 {
	static int N, M;
	static int[][] map;
	static List<int[]> posVirus = new ArrayList<>();
	static List<int[]> posVoid = new ArrayList<>();
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int vMin;
	
	static void bfs(int[] v1, int[] v2, int[] v3) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M];
		
		for (int i=0; i<posVirus.size(); i++) {
			q.offer(new int[] { posVirus.get(i)[0], posVirus.get(i)[1] });
			isVisited[posVirus.get(i)[0]][posVirus.get(i)[1]] = true;
		}
		isVisited[v1[0]][v1[1]] = true;
		isVisited[v2[0]][v2[1]] = true;
		isVisited[v3[0]][v3[1]] = true;
		
		int cnt = 0;
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1 || isVisited[nr][nc]) continue;
				q.add(new int[] { nr, nc });
				isVisited[nr][nc] = true;
				cnt++;
				if (cnt >= vMin) return;
			}
		}
		vMin = Math.min(vMin, cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) posVirus.add(new int[] { i, j });
				else if (map[i][j] == 0) posVoid.add(new int[] { i, j });
			}
		}
		br.close();
		
		vMin = Integer.MAX_VALUE;
		int voidSize = posVoid.size();
		for (int i=0; i<voidSize-2; i++) {
			for (int j=i+1; j<voidSize-1; j++) {
				for (int k=j+1; k<voidSize; k++) {
					bfs(posVoid.get(i), posVoid.get(j), posVoid.get(k));
				}
			}
		}
		System.out.println(voidSize - vMin - 3);
	}

}
