package dfs;

import java.io.*;
import java.util.*;

// N과 M (1)
public class BaekJoon_15649 {
	static StringBuilder sb;
	static boolean[] isSelected;
	
	static void getComb(int N, int M, int cnt, String comb) {
		if (cnt == M) {
			sb.append(comb).append("\n");
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			if (cnt == 0) getComb(N, M, cnt + 1, comb + i);
			else getComb(N, M, cnt + 1, comb + " " + i);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		isSelected = new boolean[N + 1];
		getComb(N, M, 0, "");
		System.out.print(sb);
		br.close();
	}

}
