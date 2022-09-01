package dfs;

import java.io.*;

// N-Queen
public class BaekJoon_9663 {
	static int N;
	static boolean[] isFilledLCross;
	static boolean[] isFilledRCross;
	static boolean[] isFilledVert;
	static int cnt;
	
	static void dfs(int r) {
		if (r == N) {
			cnt++;
			return;
		}
		for (int c=0; c<N; c++) {
			if (isFilledLCross[r + c] || isFilledRCross[r - c + N - 1] || isFilledVert[c]) continue;
			isFilledLCross[r + c] = true;
			isFilledRCross[r - c + N - 1] = true;
			isFilledVert[c] = true;
			dfs(r + 1);
			isFilledLCross[r + c] = false;
			isFilledRCross[r - c + N - 1] = false;
			isFilledVert[c] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		isFilledLCross = new boolean[N * 2 - 1];
		isFilledRCross = new boolean[N * 2 - 1];
		isFilledVert = new boolean[N];
		dfs(0);
		System.out.println(cnt);
		br.close();
	}

}