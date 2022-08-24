package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class BaekJoon_11725 {
	static int N;
	static List<List<Integer>> conn;
	static int[] parent;
	static boolean[] isVisited;
	
	static void dfs(int idx) {
		if (idx > N) return;
		
		isVisited[idx] = true;
		List<Integer> l = conn.get(idx);
		for (int i=0; i<l.size(); i++) {
			int next = l.get(i);
			if (isVisited[next]) continue;
			
			parent[next] = idx;
			isVisited[next] = true;
			dfs(next);
			isVisited[next] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		conn = new ArrayList<>();
		for (int i=0; i<N+1; i++) {
			conn.add(new ArrayList<>());
		}
		
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			conn.get(n1).add(n2);
			conn.get(n2).add(n1);
		}
		parent = new int[N+1];
		isVisited = new boolean[N+1];
		dfs(1);
		StringBuilder sb = new StringBuilder();
		for (int i=2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
