package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2636, 치즈
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 바깥 공기(내부공기는 X)와 접촉된 치즈를 체크하면서 BFS 탐색해야하는 문제
 * 	2. 크게 BFS 탐색 종류를 둘로 나누었는데
 * 		2.1 외부 공기와 접촉된 치즈의 표면을 구하는 탐색과
 * 		2.2 치즈가 공기와 접촉해 녹으면서 드러나는 새로운 면적을 찾는 탐색
 * 	3. 2.2의 탐색과정에서 내부 공기(isVisited)가 false인 부분을 만나면 2.1의 탐색을 다시 실행해 다시 공기와 접촉한 치즈를 찾아 큐에 추가
 * 	4. 모든 탐색을 진행하면서 board에 치즈가 공기에 접촉한 시간(depth)을 누적
 * 	5. 탐색 종료 후 board를 순회하면서 depth(max)가 가장 큰 값과 동일한 치즈의 개수를 카운팅하여 max, cnt를 출력
 *
 */
public class BaekJoon_2636 {
	static int N, M;
	static int[][] board;
	static boolean[][] isVisited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static Queue<int[]> queue;
	static int max;
	static int cnt;
	
	static void getBoundary(int r, int c, int day) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		isVisited[r][c] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc]) continue;
				
				isVisited[nr][nc] = true;
				if (board[nr][nc] == 0) q.offer(new int[] { nr, nc });
				else {
					queue.offer(new int[] { nr, nc });
					board[nr][nc] = day;
					max = day;
				}
			}
		}
	}
	
	static void bfs() {
		while (queue.size() > 0) {
			int[] curr = queue.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (isVisited[nr][nc]) continue;
				
				if (board[nr][nc] == 1) {
					queue.offer(new int[] { nr, nc });
					isVisited[nr][nc] = true;
					board[nr][nc] = board[curr[0]][curr[1]] + 1;
					max = board[nr][nc];
				} else getBoundary(nr, nc, board[curr[0]][curr[1]] + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		isVisited = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		queue = new LinkedList<>();
		max = 0;
		cnt = 0;
		getBoundary(0, 0, 1);
		bfs();
		
		for (int i=1; i<N-1; i++) {
			System.out.println(Arrays.toString(board[i]));
			for (int j=1; j<M-1; j++) {
				if (max > 0 && board[i][j] == max) cnt++;
			}
		}	
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n").append(cnt);
		System.out.println(sb);
	}

}
