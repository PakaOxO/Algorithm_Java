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
	static Queue<int[]> walls;
	static Queue<int[]> queue;
	static boolean answer;
	
	static int[] dr = { -1, 0, 0, 0, 1 };
	static int[] dc = { 0, 1, 0, -1, 0 };
	
	static void moveWall() {
		for (int i=0; i<walls.size(); i++) {
			int[] wall = walls.poll();
			if (wall[0] + 1 == 8) continue;
			wall[0]++;
			
			for (int j=0; j<queue.size(); j++) {
				int[] node = queue.poll();
				if (node[0] == wall[0] && node[1] == wall[1]) continue;
				queue.offer(node);
			}
			walls.offer(wall);
		}
	}
	
	static boolean check(int r, int c) {
		if (r < 0 || c < 0 || r >= 8 || c >= 8) return false;
		for (int[] wall : walls) {
			if (wall[0] == r && wall[1] == c) return false;
		}
		return true;
	}
	
	static void bfs(int r, int c) {
		queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });
		
		int depth = 0;
		while (queue.size() > 0) {
			int[] curr = queue.poll();
			depth = curr[2];
			for (int i=0; i<4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				
				if (!check(nr, nc)) continue;
				queue.offer(new int[] { nr, nc, depth + 1 });
				if (nr == 0 && nc == 7) {
					answer = true;
					return;
				}
			}
			
			if (queue.size() > 0 && queue.peek()[2] > depth) moveWall();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new char[8][8];
		walls = new LinkedList<>();
		for (int i=0; i<8; i++) {
			String input = br.readLine();
			for (int j=0; j<8; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == '#') walls.offer(new int[] { i, j });
			}
		}
		br.close();
		
		answer = false;
		bfs(7, 0);
		
		System.out.println(answer);
	}

}
