package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2206, 벽 부수고 이동하기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 시작지점(0, 0)에서 시작하는 BFS 탐색 실시, 각 노드 정보에는 현재 위치(r, c)와 탐색 깊이(depth) 그리고 벽을 부수고 왔는지(cnt, 남은 부술 수 있는 횟수)가 포함
 * 	2. 탐색을 진행하며 벽이 있고, 부술 수 있는 횟수가 남아 있으면 다음 큐에 부술 수 있는 횟수를 감소시키고 추가
 * 	3. 벽이 없으면 위치와 depth만 증가시키고 큐에 추가
 * 	4. 탐색을 진행하며 목표지점에 도착하면 해당 depth를 답에 저장하고 탐색 종료
 * 	5. 답을 출력(목표지점에 도착하지 못했다면 answer 초기값인 -1을 출력)
 *
 */
public class BaekJoon_2206 {
	static int N, M;
	static int[][] map;
	static boolean[][][] isVisited;
	static int answer;
	
	static int[][] drc = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 1, 1 });
		isVisited[0][0][1] = true;
			
		while (q.size() > 0) {
			int[] curr = q.poll();
			if (curr[0] == N - 1 && curr[1] == M - 1) {
				answer = curr[2];
				return;
			}
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				int depth = curr[2];
				int cnt = curr[3];
				if (!(0 <= nr && nr < N && 0 <= nc && nc < M)) continue;
				if (map[nr][nc] == 1 && cnt > 0 && !isVisited[nr][nc][cnt - 1]) {
					q.offer(new int[] { nr, nc, depth + 1, cnt - 1 });
					isVisited[nr][nc][cnt - 1] = true;
				} else if (map[nr][nc] == 0 && !isVisited[nr][nc][cnt]) {
					q.offer(new int[] { nr, nc, depth + 1, cnt });
					isVisited[nr][nc][cnt] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M][2];
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = (int)(input.charAt(j) - '0');
			}
		}
		br.close();
		
		answer = -1;
		bfs();
		System.out.println(answer);
	}

}
