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
 * 	1. 
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
	static boolean[][] isVisited;
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
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc]) continue;
				
				if (board[nr][nc] == 0) {
					isVisited[nr][nc] = true;
					aQ.offer(new Pos(nr, nc));
				} else {
					if (!check(nr, nc)) continue;
					isVisited[nr][nc] = true;
					cQ.offer(new Pos(nr, nc));
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
		isVisited = new boolean[N][M];
		isVisited[0][0] = true;
		
		while (true) {
			if (!aQ.isEmpty()) airBfs();	
			if (!cQ.isEmpty()) melt();
			for (int[] b : board) System.out.println(Arrays.toString(b));
			System.out.println();
			
			if (aQ.isEmpty() && cQ.isEmpty()) break;
		}
		System.out.println(answer);
	}

}
