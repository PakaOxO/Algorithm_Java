package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

// N과 M (9)
public class BaekJoon_15663 {
	static int N, M;
	static int[] input;
	static boolean[] isVisited;
	static int[] combi;
	static Set<String> set;
	
	static void dfs(int cnt) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<M; i++) {
				sb.append(combi[i]);
				if (i < M - 1) sb.append(" ");
			}
			set.add(sb.toString());
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isVisited[i]) continue;
			
			isVisited[i] = true;
			combi[cnt] = input[i];
			dfs(cnt + 1);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		set = new LinkedHashSet<>();
		
		isVisited = new boolean[N];
		combi = new int[M];
		dfs(0);

		StringBuilder sb = new StringBuilder();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			sb.append(it.next()).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
