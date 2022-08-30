package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3)
public class BaekJoon_15651 {
	static int N, M;
	static boolean[] isVisited;
	static char[] arr;
	static StringBuilder sb;
	
	static void dfs(int pos) {
		if (pos == M) {
			sb.append(arr);
			return;
		}
		for (int i=1; i<=N; i++) {
			arr[pos * 2] = (char)(i + '0');
			dfs(pos + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[M * 2];
		arr[M * 2 - 1] = '\n';
		for (int i=1; i<M*2-1; i+=2) {
			arr[i] = ' ';
		}
		
		sb = new StringBuilder();
		dfs(0);
		System.out.print(sb);
		br.close();
	}

}
