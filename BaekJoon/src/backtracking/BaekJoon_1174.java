package backtracking;

import java.io.*;

// 줄어드는 수
public class BaekJoon_1174 {
	static int N;
	static int[] comb = new int[10];
	static int cnt;
	static boolean hasNum;
	static StringBuilder sb;
	
	static void dfs(int maxIdx, int idx, int prev) {
		if (idx > 10) return;
		if (cnt == N) return;
		if (idx == maxIdx) {
			sb = new StringBuilder();
			for (int i=0; i<maxIdx; i++) {
				sb.append(comb[i]);
			}
			cnt++;
			return;
		}
		
		for (int i=0; i<=9; i++) {
			if (i >= prev) break;
			comb[idx] = i;
			dfs(maxIdx, idx + 1, i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cnt = 0;
		hasNum = true;
		sb = new StringBuilder();
		
		int maxIdx= 1;
		while (true) {
			dfs(maxIdx, 0, 10);
			if (maxIdx > 10) {
				hasNum = false;
				break;
			}
			if (cnt == N) break;
			maxIdx++;
		}
		if (!hasNum) System.out.println(-1);
		else System.out.println(sb);
		br.close();
	}

}
