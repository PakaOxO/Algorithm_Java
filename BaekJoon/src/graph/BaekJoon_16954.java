package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16954, 움직이는 미로 탈출(HARD)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. BFS로 풀려다가 실패... 재욱님 아이디어로 재풀이
 * 
 * 	2. 초기 시작점에서 DFS로 탐색하면서 가지치기
 * 		2.1 가지치기 조건은 이동하려는 위치가 벽일 경우
 * 		2.2 그리고 이동하려는 위치가 벽 바로 밑일 경우(다음 턴에 죽기 때문)
 * 
 * 	3. 7턴 뒤에 모든 벽은 사라지므로 depth 8까지 살아남았다면 1을 아니면 0을 출력
 *
 */
public class BaekJoon_16954 {
	static char[][] board;
	static boolean[][] isVisited;
	static Queue<int[]> walls;
	
	static int[] dr = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dc = { 1, 0, -1, 1, 0, -1, 0, -1, 1 };
	
	static boolean check(int r, int c, int depth) {
		if (r < 0 || c < 0 || r >= 8 || c >= 8) return false;
		for (int[] wall : walls) {
			if (wall[0] + depth == r && wall[1] == c) return false;
			if (wall[0] + depth + 1 == r && wall[1] == c) return false;
		}
		return true;
	}
	
	static void dfs(int r, int c, int depth) {
		if (depth == 8) {
			System.out.println(1);
			System.exit(0);
		}
		
		for (int i=0; i<9; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!check(nr, nc, depth)) continue;
			dfs(nr, nc, depth + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[8][8];
		isVisited = new boolean[8][8];
		walls = new LinkedList<>();
		for (int i=0; i<8; i++) {
			String input = br.readLine();
			for (int j=0; j<8; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == '#') walls.offer(new int[] { i, j });
			}
		}
		br.close();
		dfs(7, 0, 0);
		
		System.out.println(0);
	}

}