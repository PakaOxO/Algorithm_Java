package dfs;

import java.io.*;
import java.util.*;

// 외판원 순회 2
public class BaekJoon_10971 {
	static int N;
	static int[][] map;
	static boolean[] isVisited;
	static int start;
	static int min;
	
	static void dfs(int curr, int cnt, int sum) {
		if (cnt == N) {
			if (map[curr][start] == 0) return;
			sum += map[curr][start];
			if (sum < min) min = sum;
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (curr == i || isVisited[i] || map[curr][i] == 0) continue;
			isVisited[i] = true;
			dfs(i, cnt + 1, sum + map[curr][i]);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			isVisited = new boolean[N];
			isVisited[i] = true;
			start = i;
			dfs(i, 1, 0);
		}
		
		System.out.println(min);
		br.close();
	}

}
