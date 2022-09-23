package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_4179, 불!
 * @author kevin-Arpe
 * 	
 * Sketch Idea
 * 	1. 입력을 받으면서 지훈이의 위치와 불의 위치를 각각 별도의 큐에 저장
 * 	2. 메인 BFS는 지훈이의 위치를 기준으로 실행, 지훈이가 이동하고 나면 이전 위치는 필요 없으므로 큐에 다시 넣지 않고, 새로운 위치만 넣어줌
 * 	3. 지훈이의 정보를 poll하기 전에 depth를 확인해 이전 depth보다 크다면 시간이 한 턴이 끝난 것이므로 불이 이동하는 로직(BFS) 실행
 * 	4. 불이 이동하는 로직 또한 BFS인데 depth(함수 실행시 맨 앞의 depth)보다 큐의 맨 앞의 depth가 커지는 시점에 한 턴이 또 끝난 것이므로 메서드 종료
 * 	5. 3, 4를 반복하다가 3의 과정 중에 지훈이가 map의 경계에 도착했다면 가능, 지훈이 큐의 데이터를 모두 소모했다면 빠져나오지 못한 것임.
 *
 */
public class BaekJoon_4179 {
	static class Point {
		int r, c, depth;
		Point(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
	static int N, M, answer;
	static char[][] map;
	static Queue<Point> fire;
	static Queue<Point> jihoon;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void moveFire() {
		if (fire.isEmpty()) return;
		int depth = fire.peek().depth;
		while (fire.size() > 0) {
			if (depth < fire.peek().depth) break; 
			Point curr = fire.poll();
			depth = curr.depth;
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				if (!(0 <= nr && nr < N && 0 <= nc && nc < M) || map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
				map[nr][nc] = 'F';
				fire.offer(new Point(nr, nc, depth + 1));
			}
		}
	}
	
	static void bfs() {
		int depth = 1;
		while (jihoon.size() > 0) {
			if (depth < jihoon.peek().depth) { 
				moveFire();
			}
			Point curr = jihoon.poll();
			if (map[curr.r][curr.c] == 'F') continue;
			
			depth = curr.depth;
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				if (!(0 <= nr && nr < N && 0 <= nc && nc < M)) {
					answer = curr.depth;
					return;
				}
				if (map[nr][nc] != '.') continue;
				map[nr][nc] = 'J';
				jihoon.offer(new Point(nr, nc, depth + 1));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		fire = new LinkedList<>();
		jihoon = new LinkedList<>();
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'F') fire.offer(new Point(i, j, 0));
				else if (map[i][j] == 'J') jihoon.offer(new Point(i, j, 1));
			}
		}
		br.close();
		bfs();
		
		if (answer == 0) System.out.println("IMPOSSIBLE");
		else System.out.println(answer);
	}

}
