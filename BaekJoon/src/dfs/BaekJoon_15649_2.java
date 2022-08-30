package dfs;

import java.io.*;
import java.util.*;

// N과 M (1)
public class BaekJoon_15649_2 {
	static int N, M;
	static boolean[] isVisited;
	static StringBuilder sb;
	
	static void dfs(int cnt, String comb) {
		if (cnt == M) {
			sb.append(comb).append("\n");
			return;
		}
		for (int i=1; i<=N; i++) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			if (cnt == 0) dfs(cnt + 1, comb + i);
			else dfs(cnt + 1, comb + " " + i);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(0, "");
		System.out.print(sb);
		br.close();
	}

}
