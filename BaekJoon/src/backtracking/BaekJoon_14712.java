package backtracking;

import java.io.*;
import java.util.*;

// 넴모넴모 (Easy)
public class BaekJoon_14712 {
	static int N, M;
	static boolean[][] map;
	static int[][] drc = { { -1, -1 }, { -1, 0 }, { 0 , -1 } };
	static int answer;
	
	static boolean check(int r, int c) {
		for (int i=0; i<3; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			if (r + dr < 0 || c + dc < 0) return false;
			if (!map[r + dr][c + dc]) return false;
		}
		return true;
	}
	
	static void dfs(int r, int c) {
		if (c == M) {
			c = 0;
			r++;
		}
		if (r == N) {
			answer++;
			return;
		}
		
		if (check(r, c)) {
			dfs(r, c + 1);
			return;
		}
		
		map[r][c] = true;
		dfs(r, c + 1);
		map[r][c] = false;
		dfs(r, c + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		dfs(0, 0);
		System.out.println(answer);
		br.close();
	}

}
