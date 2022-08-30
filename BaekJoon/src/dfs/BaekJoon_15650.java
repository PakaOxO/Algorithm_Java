package dfs;

import java.io.*;
import java.util.StringTokenizer;

// N과 M (2)
public class BaekJoon_15650 {
	static int N, M;
	static StringBuilder sb;
	
	static void dfs(int cnt, int start, String comb) {
		if (cnt == M) {
			sb.append(comb).append("\n");
			return;
		}
		for (int i=start; i<=N; i++) {
			if (cnt == 0) dfs(cnt + 1, i + 1, comb + i);
			else dfs(cnt + 1, i + 1, comb + " " + i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		dfs(0, 1, "");
		System.out.print(sb);
		br.close();
	}

}
