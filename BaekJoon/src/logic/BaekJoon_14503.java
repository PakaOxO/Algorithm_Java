package logic;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14503, 로봇 청소기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 문제에서 주어진 대로 구현만 하면 되는 단순 구현 문제
 *
 */
public class BaekJoon_14503 {
	static int N, M, answer;
	static int sR, sC, d;
	
	static int[][] map;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 12시 방향부터 시계방향
	static boolean[][] isCleaned;
	
	static int nextDir(int dir) {
		return dir - 1 + (dir - 1 < 0 ? 4 : 0);
	}
	
	static boolean check(int r, int c, int dir) {
		dir = nextDir(dir);
		int nr = r + drc[dir][0];
		int nc = c + drc[dir][1];
		if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1 || isCleaned[nr][nc]) return false;
		
		return true;
	}
	
	static void clean(int r, int c) {
		map[r][c] = 0;
		isCleaned[r][c] = true;
		answer++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sR = Integer.parseInt(st.nextToken());
		sC = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int r = sR;
		int c = sC;
		isCleaned = new boolean[N][M];
		
		int answer = 0;
		while (true) {
			// 1번
			if (!isCleaned[r][c]) {
				clean(r, c);
			}
			// 2번
			boolean flag = false;
			for (int i=0; i<4; i++) {
				d = nextDir(d);
				int nr = r + drc[d][0];
				int nc = c + drc[d][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1 || isCleaned[nr][nc]) continue;
				
				flag = true;
				break;
			}
			
			// 분기점 
			if (!flag) { // 바라보는 방향 유지한채 후진
				int bDir = (d + 2) % 4;
				int nr = r + drc[bDir][0];
				int nc = c + drc[bDir][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1) break;
				
				r = nr;
				c = nc;
				
			} else { // 청소가 안되어 있는 곳으로 이동
				r = r + drc[d][0];
				c = c + drc[d][1];
			}
		}
		
		System.out.println(answer);
	}

}
