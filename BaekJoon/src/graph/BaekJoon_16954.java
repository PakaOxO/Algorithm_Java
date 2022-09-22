package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16954, 움직이는 미로 탈출
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_16954 {
	static char[][] board;
	static boolean[][][] isVisited;
	static Queue<int[]> walls;
	static Queue<int[]> queue;
	static int answer;
	
	static int[] dr = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dc = { 1, 0, -1, 1, 0, -1, 0, -1, 1 };
	
	static void moveWall() {
		int wallSize = walls.size();
		for (int i=0; i<wallSize; i++) {
			int[] wall = walls.poll();
			if (wall[0] == 7) continue;
			wall[0]++;
			
			for (int j=0; j<queue.size(); j++) {
				int[] node = queue.poll();
				if (node[0] == wall[0] && node[1] == wall[1]) break;
				queue.offer(node);
			}
			walls.offer(wall);
		}
	}
	
	static boolean check(int r, int c, int depth) {
		if (r < 0 || c < 0 || r >= 8 || c >= 8 || isVisited[r][c][depth]) return false;
		for (int[] wall : walls) {
			if (wall[0] == r && wall[1] == c) return false;
		}
		return true;
	}
	
	static void bfs(int r, int c) {
		queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });
		isVisited[r][c][0] = true;
		
		int depth = 0;
		while (queue.size() > 0) {
			int[] curr = queue.poll();
			depth = curr[2];
			isVisited[curr[0]][curr[1]][curr[2]] = false;
			for (int i=0; i<9; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if (!check(nr, nc, depth)) continue;
				queue.offer(new int[] { nr, nc, depth + 1 });
				isVisited[nr][nc][depth + 1] = true;
				if (nr == 0 && nc == 7) {
					answer = 1;
					return;
				}
			}
			if (queue.size() > 0 && queue.peek()[2] > depth) moveWall();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[8][8];
		isVisited = new boolean[8][8][16];
		walls = new LinkedList<>();
		for (int i=0; i<8; i++) {
			String input = br.readLine();
			for (int j=0; j<8; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == '#') walls.offer(new int[] { i, j });
			}
		}
		br.close();
		answer = 0;
		bfs(7, 0);
		
		System.out.println(answer);
	}

}
