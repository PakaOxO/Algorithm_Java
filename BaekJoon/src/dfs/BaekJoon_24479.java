package dfs;

import java.io.*;
import java.util.*;

// 깊이 우선 탐색 1
public class BaekJoon_24479 {
	static int N, M;
	static int[][] input;
	static List<Integer>[] edges;
	static boolean[] isVisited;
	static int[] path;
	static int pathIdx;
	static int edgeCnt;
	
	static void visit(int node) {
		if (edgeCnt > M) return;
		
		if (!isVisited[node]) {
			edgeCnt++;
			path[node] = pathIdx++;
			isVisited[node] = true;
		}
		List<Integer> edgeInfo = edges[node];
		
		for (int i=0; i<edgeInfo.size(); i++) {
			int next = edgeInfo.get(i);
			if (isVisited[next]) continue;
			visit(next);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		input = new int[M][2];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		edges = new ArrayList[N + 1];
		
		for (int i=0; i<N+1; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			edges[input[i][0]].add(input[i][1]);
			edges[input[i][1]].add(input[i][0]);
		}
		
		isVisited = new boolean[N+1];
		path = new int[N+1];
		pathIdx = 1;
		visit(R);
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(path[i]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
