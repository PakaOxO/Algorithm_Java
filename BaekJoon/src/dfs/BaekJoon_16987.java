package dfs;

import java.io.*;
import java.util.*;

// 계란으로 계란치기
public class BaekJoon_16987 {
	static int N;
	static int[][] eggs;
	static boolean[] isBroken;
	static int max;
	
	static void dfs(int left) {
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		isBroken = new boolean[N];
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
