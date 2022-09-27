package level_00;

import java.io.*;
import java.util.*;

/**
 * SWEA_등산로조성, 모의 SW 역량테스트 기출
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class SWEA_등산로조성 {
	static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, K, answer;
	static int[][] map;
	static boolean[][] isVisited;
	static List<Node> start;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static void dfs(Node curr, int depth, int flag) {
		answer = Math.max(answer, depth);
		
		for (int i=0; i<4; i++) {
			int nr = curr.r + drc[i][0];
			int nc = curr.c + drc[i][1];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc]) continue;
			if (flag == 1 && map[nr][nc] >= map[curr.r][curr.c]) continue;
			
			if (map[nr][nc] >= map[curr.r][curr.c]) {
				int gap = map[nr][nc] - map[curr.r][curr.c];
				if (flag == 1 || gap >= K) continue;
				
				Node next = new Node(nr, nc);
				isVisited[nr][nc] = true;
				map[nr][nc] -= (gap + 1);
				
				dfs(next, depth + 1, 1);
				
				map[nr][nc] += (gap + 1);
				isVisited[nr][nc] = false; 
				
			} else {
				Node next = new Node(nr, nc);
				isVisited[nr][nc] = true;
				
				dfs(next, depth + 1, flag);
				
				isVisited[nr][nc] = false; 
				
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			isVisited = new boolean[N][N];
			start = new ArrayList<>();
			
			int max = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) max = map[i][j];
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == max) start.add(new Node(i, j));
				}
			}
			
			answer = 0;
			for (Node s : start) {
				isVisited[s.r][s.c] = true; 
				dfs(s, 1, 0);
				isVisited[s.r][s.c] = false; 
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
