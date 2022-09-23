package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2667, 단지번호 붙이기(DFS 풀이)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. DFS로 재풀이
 *
 */
public class BaekJoon_2667_2 {
	static int N, cnt;
	static int[][] map;
	static List<int[]> building;
	static List<Integer> bCnt;
	
	static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	
	static void dfs(int r, int c) {
		map[r][c] = 0;
		cnt++;
		
		for (int i=0; i<4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (!(0 <= nr && nr < N && 0 <= nc && nc < N) || map[nr][nc] == 0) continue;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		building = new ArrayList<>();
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = (int)(input.charAt(j) - '0');
				if (map[i][j] == 1) building.add(new int[] { i, j });
			}
		}
		br.close();
		
		bCnt = new ArrayList<>();
		for (int[] b : building) {
			if (map[b[0]][b[1]] == 0) continue;
			cnt = 0;
			dfs(b[0], b[1]);
			bCnt.add(cnt);
		}
		Collections.sort(bCnt);
		
		StringBuilder sb = new StringBuilder();
		sb.append(bCnt.size()).append("\n");
		for (int c : bCnt) sb.append(c).append("\n");
		
		System.out.print(sb);
	}

}
