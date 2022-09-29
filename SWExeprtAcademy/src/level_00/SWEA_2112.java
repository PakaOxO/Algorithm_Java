package level_00;

import java.io.*;
import java.util.*;

/**
 * SWEA_2112, 보호 필름
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 완전 탐색과 DFS를 사용
 *
 */
public class SWEA_2112 {
	static int D, W, K, min;
	static int[][] film;
	static int[] isChanged;
	
	static boolean check() {
		for (int c=0; c<W; c++) {
			int cnt0 = 0;
			int cnt1 = 0;
			boolean flag = false;
			for (int r=0; r<D; r++) {
				if (isChanged[r] == 1) {
					cnt0++;
					cnt1 = 0;
				} else if(isChanged[r] == 2) {
					cnt1++;
					cnt0 = 0;
				} else if (film[r][c] == 0) {
					cnt0++;
					cnt1 = 0;
				} else if (film[r][c] == 1) {
					cnt1++;
					cnt0 = 0;
				}
				
				if (cnt0 == K || cnt1 == K) {
					flag = true;
					break;
				}
			}
			if (!flag) return false;
		}
		return true;
	}
	
	static void dfs(int depth, int cnt) {
		if (cnt >= min) return;
		if (check()) {
			min = cnt;
			return;
		}
		if (depth == D) return;
		
		isChanged[depth] = 1;
		dfs(depth + 1, cnt + 1);
		
		isChanged[depth] = 2;
		dfs(depth + 1, cnt + 1);
		
		isChanged[depth] = 0;
		dfs(depth + 1, cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			for (int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			isChanged = new int[D];
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		br.close();
		System.out.print(sb);
	}

}
