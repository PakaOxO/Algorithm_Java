package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14500, 테트로미노(재풀이)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 테트로미노를 만드는 케이스는 시작위치에서 DFS를 돌면서 depth가 4가 되는 시점에 stop
 * 	2. 해당 DFS의 합이 최대가 되는 시점을 answer로 초기화
 * 	3. 나올 수 있는 최대 합은 만약 최대 숫자로만 이루어진 board가 있다면 max * 4가 최대값이 될 것
 * 	4. DFS에서 지금까지 구한 최대값이 DFS 해당 depth의 sum + (구해야 하는 남은 칸의 개수 * max) 보다 크다면 현재 DFS에서는 max보다 커질 수 없으므로 stop
 * 
 *
 */
public class BaekJoon_14500_2 {
	static int N, M, max, answer;
	static int[][] board;
	static boolean[][] isVisited;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void dfs(int r, int c, int depth, int sum) {
		if (answer >= (4 - depth) * max + sum) return;
		if (depth == 4) {
			if (sum > answer) answer = sum;
			return;
		}
		
		for (int i=0; i<4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc]) continue;
			isVisited[nr][nc] = true;
			dfs(r, c, depth + 1, sum + board[nr][nc]);
			dfs(nr, nc, depth + 1, sum + board[nr][nc]);
			isVisited[nr][nc] = false;
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
				if (board[i][j] > max) max = board[i][j];
			}
		}
		br.close();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				isVisited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				isVisited[i][j] = false;
			}
		}
		System.out.println(answer);
	}

}
