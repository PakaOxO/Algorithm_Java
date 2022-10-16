package backtracking;

import java.io.*;
import java.util.StringTokenizer;

// N과 M (4)
public class BaekJoon_15652 {
	static int N, M;
	static char[] arr;
	static StringBuilder sb;
	
	static void dfs(int start, int cnt) {
		if (cnt == M) {
			sb.append(arr);
			return;
		}
		for (int i=start; i<=N; i++) {
			arr[cnt * 2] = (char)(i + '0');
			dfs(i, cnt + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M * 2];
		for (int i=1; i<M*2; i+=2) arr[i] = ' ';
		arr[M * 2 - 1] = '\n';
		
		sb = new StringBuilder();
		dfs(1, 0);
		System.out.println(sb);
		br.close();
	}

}
