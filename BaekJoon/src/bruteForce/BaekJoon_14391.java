package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14391, 종이 조각
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 시작지점에서 선택할 수 있는 방향은 먼저 2가지
 * 		1.1 하나는 가로로 이을 것인가.
 * 		1.2 다른 하나는 세로로 이을 것인가.
 * 	2. 가로 세로를 정했으면 다음은 1개부터 N또는 M까지 또는 이전에 방문했던 칸을 만날 때까지
 * 	3. 모든 칸을 탐색 완료했다면 숫자의 합을 이전에 저장된 최대값과 비교
 *
 */
public class BaekJoon_14391 {
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	static int max;
	
	static boolean check(int r, int c, int type, int len) {
		if (type == 0) { // 가로
			if (len > M - c) return false;
			for (int i=0; i<len; i++) {
				if (isVisited[r][c + i]) return false;
			}
			return true;
		} else { // 세로
			if (len > N - r) return false;
			for (int i=0; i<len; i++) {
				if (isVisited[r + i][c]) return false;
			}
			return true;
		}
	}
	
	static int visit(int r, int c, int type, boolean val, int len) {
		int sum = map[r][c];
		if (type == 0) { // 가로
			for (int i=1; i<len; i++) {
				isVisited[r][c + i] = val;
				sum = sum * 10 + map[r][c + i];
			}
		} else { // 세로
			for (int i=1; i<len; i++) {
				isVisited[r + i][c] = val;
				sum += sum * 10 + map[r + i][c];
			}
		}
		System.out.println(sum);
		return sum;
	}
	
	static void dfs(int r, int c, int sum) {
		if (c >= M) {
			c = 0;
			r++;
		}
		
		if (r == N) {
			max = Math.max(max, sum);
			return;
		}
		if (isVisited[r][c]) dfs(r, c + 1, sum);
		
		for (int len=4; len>0; len--) {
			if (check(r, c, 0, len)) {
				dfs(r, c + len, sum + visit(r, c, 0, true, len));
				visit(r, c, 0, false, len);
			}
			
			if (check(r, c, 1, len)) {
				dfs(r, c + 1, sum + visit(r, c, 1, true, len));
				visit(r, c, 1, false, len);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = (int)(line.charAt(j) - '0');
			}
		}
		
		isVisited = new boolean[N][M];
		max = 0;
		dfs(0, 0, 0);
		
		System.out.println(max);
		br.close();
	}

}
