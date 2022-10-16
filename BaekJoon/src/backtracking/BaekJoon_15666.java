package backtracking;

import java.io.*;
import java.util.*;

// N과 M (12)
public class BaekJoon_15666 {
	static int N, M;
	static int[] arr;
	static int[] comb;
	static StringBuilder sb;
	
	static void dfs(int start, int cnt) {
		if (cnt == M) {
			for (int i=0; i<M; i++) {
				sb.append(comb[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=start, x=-1; i<N; i++) {
			if (arr[i] == x) continue;
			comb[cnt] = arr[i];
			dfs(i, cnt + 1);
			x = arr[i];
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
		comb = new int[M];
		dfs(0, 0);
		
		System.out.print(sb);
		br.close();
	}

}
