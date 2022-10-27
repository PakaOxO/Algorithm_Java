package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BaekJoon_2638, 치즈
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 공기에 접촉된 치즈를 찾기 위해 공기의 위치(0, 0)에서 BFS 탐색으로 2면 이상 접촉된 치즈를 찾아 치즈 큐에 담음
 *  2. 치즈 큐에 담긴 위치는 녹여야하는 위치이므로 0으로 바꿔준 뒤 큐에서 제거, 이 위치는 이제 공기이므로 다음 공기 BFS 탐색시에 필요하기 때문에 공기 큐에 삽입
 *  3. 다시 1번으로 돌아가 탐색
 *  4. 모든 탐색을 진행하면서 공기큐, 치즈큐에 남은 위치가 없다면 모든 프로세스가 종료된 것임. 녹이는 메서드 호출된 회수가 정답이므로 녹일 때마다 answer를 1씩 증가하고
 *      이를 마지막에 출력
 *
 */
public class BaekJoon_2638 {
	static class Pos {
		int r, c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, answer;
	static int[][] board;
	static int[][] isVisited;
	static Queue<Pos> aQ, cQ;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static boolean check(int r, int c) {
		int cnt = 0;
		for (int i=0; i<4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (board[nr][nc] == 0) cnt++;
		}
		
		if (cnt >= 2) return true;
		else return false;
	}
	
	static void airBfs() {
		while (!aQ.isEmpty()) {
			Pos curr = aQ.poll();
			
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				if (board[nr][nc] == 0) {
				    if (isVisited[nr][nc] > 0) continue;
					isVisited[nr][nc] = 1;
					aQ.offer(new Pos(nr, nc));
				} else {
				    if (isVisited[nr][nc] == 2) continue;
					isVisited[nr][nc]++;
					if (isVisited[nr][nc] == 2) cQ.offer(new Pos(nr, nc));
				}
			}
		}
	}
	
	static void melt() {
		while (!cQ.isEmpty()) {
			Pos curr = cQ.poll();
			board[curr.r][curr.c] = 0;
			aQ.offer(curr);
		}
		answer++;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		aQ = new LinkedList<>();
		cQ = new LinkedList<>();
		
		aQ.offer(new Pos(0, 0));
		isVisited = new int[N][M];
		isVisited[0][0] = 1;
		
		while (true) {
			if (!aQ.isEmpty()) airBfs();	
			if (!cQ.isEmpty()) melt();
			
			if (aQ.isEmpty() && cQ.isEmpty()) break;
		}
		System.out.println(answer);
	}

}
