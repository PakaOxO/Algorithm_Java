package dfs;

import java.io.*;

// 줄어드는 수
public class BaekJoon_1174 {
	static int N;
	static int[] comb = new int[10];
	static int cnt;
	static boolean hasNum;
	static StringBuilder sb;
	
	static void dfs(int maxIdx, int idx, int prev) {
		if (cnt == 2023) {
			return;
		}
		if (idx == maxIdx) {
			StringBuilder sb2 = new StringBuilder();
			for (int i=0; i<maxIdx; i++) {
				sb2.append(comb[i]).append(" ");
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
			System.out.println(cnt == 1023);
			if (cnt > 1023) {
				System.out.println(cnt);
				hasNum = false;
				break;
			}
			maxIdx++;
		}
		System.out.println(hasNum);
		System.out.println("cnt: " + cnt);
		br.close();
	}

}
