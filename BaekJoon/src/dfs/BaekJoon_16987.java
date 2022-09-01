package dfs;

import java.io.*;
import java.util.*;

// 계란으로 계란치기
public class BaekJoon_16987 {
	static int N;
	static int[][] eggs;
	static int max;
	
	static void dfs(int left) {
		if (left >= N) {
			int cnt = 0;
			for (int i=0; i<N; i++) {
				if (eggs[i][0] <= 0) cnt++;
			}
			if (cnt > max) max = cnt;
			return;
		}
		boolean flag = false;
		for (int i=0; i<N; i++) {
			if (i == left) continue;
			if (eggs[i][0] <= 0 || eggs[left][0] <= 0) continue;
			eggs[left][0] -= eggs[i][1];
			eggs[i][0] -= eggs[left][1];
			flag = true;
			dfs(left + 1);
			eggs[left][0] += eggs[i][1];
			eggs[i][0] += eggs[left][1];
		}
		if (!flag) dfs(left + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		dfs(0);
		System.out.println(max);
		br.close();
	}

}
