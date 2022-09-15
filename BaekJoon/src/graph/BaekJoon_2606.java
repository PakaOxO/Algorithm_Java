package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2606, 바이러스
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 큐를 활용한 BFS 탐색으로 시작 노드에서 모든 노드를 탐색
 * 	2. 탐색된 노드의 개수를 cnt 변수에 저장
 * 	3. cnt 변수를 출력
 *
 */
public class BaekJoon_2606 {
	static int N;
	static boolean[][] graph;
	static int cnt;
	
	static void bfs() {
		boolean[] isVisited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		isVisited[1] = true;
		
		while (q.size() > 0) {
			int curr = q.remove();
			for (int i=1; i<=N; i++) {
				if (isVisited[i] || !graph[curr][i]) continue;
				q.add(i);
				isVisited[i] = true;
				cnt++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new boolean[N + 1][N + 1];
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}
		
		bfs();
		System.out.println(cnt);
		br.close();
	}

}
