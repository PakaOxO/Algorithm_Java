package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1697, 숨바꼭질
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 현재 위치 기준, 좌 또는 우, 아니면 2배의 위치로 이동하면서 BFS 탐색
 * 	2. 동생의 위치에 도착했다면 해당 depth를 answer에 저장하고 리턴
 *
 */
public class BaekJoon_1697 {
	static int N, K, answer;
	static boolean[] isVisited;
	
	static void bfs() {
		if (N == K) return;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { N, 0 });
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			
			if (curr[0] - 1 >= 0 && !isVisited[curr[0] - 1]) {
				if (curr[0] - 1 == K) {
					answer = curr[1] + 1;
					return;
				}
					
				isVisited[curr[0] - 1] = true;
				q.offer(new int[] { curr[0] - 1, curr[1] + 1});
			}
			
			if (curr[0] + 1 < 100001 && !isVisited[curr[0] + 1]) {
				if (curr[0] + 1 == K) {
					answer = curr[1] + 1;
					return;
				}
				
				isVisited[curr[0] + 1] = true;
				q.offer(new int[] { curr[0] + 1, curr[1] + 1});
			}
			
			if (curr[0] * 2 < 100001 && !isVisited[curr[0] * 2]) {
				if (curr[0] * 2 == K) {
					answer = curr[1] + 1;
					return;
				}
				
				isVisited[curr[0] * 2] = true;
				q.offer(new int[] { curr[0] * 2, curr[1] + 1});
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();
		
		isVisited = new boolean[100001];
		bfs();
		System.out.println(answer);
	}

}
