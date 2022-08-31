package dfs;

import java.io.*;
import java.util.*;

// N과 M (8)
public class BaekJoon_15657 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;
	
	static void dfs(int start, int cnt, String comb) {
		if (cnt == M) {
			sb.append(comb).append("\n");
			return;
		}
		for (int i=start; i<N; i++) {
			if (cnt == 0) dfs(i, cnt + 1, comb + arr[i]);
			else dfs(i, cnt + 1, comb + " " + arr[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		dfs(0, 0, "");
		
		System.out.print(sb);
		br.close();
	}

}
