package backtracking;

import java.io.*;
import java.util.*;

// 선발 명단
public class BaekJoon_3980 {
	static int[][] players;
	static boolean[] isVisited;
	static int max;

	
	static void dfs(int player, int sum) {
		if (player == 11) {
			if (sum > max) max = sum;
			return;
		}
		
		for (int pos=0; pos<11; pos++) {
			if (players[player][pos] == 0 || isVisited[pos]) continue;
			isVisited[pos] = true;
			dfs(player + 1, sum + players[player][pos]);
			isVisited[pos] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		players = new int[11][11];
		isVisited = new boolean[11];
		for (int tc=1; tc<=T; tc++) {
			for (int i=0; i<11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<11; j++) {
					players[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 0;
			dfs(0, 0);
			sb.append(max).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
