package level03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_양과늑대 {

	public static void main(String[] args) {
		Solution_양과늑대 s = new Solution_양과늑대();
		
		System.out.println(s.solution(new int[] { 0,0,1,1,1,0,1,0,1,0,1,1 }, new int[][] { {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9} }));
//		System.out.println(s.solution(new int[] { 0,1,0,1,1,0,1,0,0,1,0 }, new int[][] { {0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10} }));
	}

}

/**
 * Programmers_양과 늑대
 * 	- 문제 분류: 트리, 그래프 탐색
 */
class Solution_양과늑대 {
	static int[] info;
	static int N, M, answer;
	static List<Integer>[] adjList;
	static List<Integer>[] v;
	
	public int solution(int[] info, int[][] edges) {
		/* 변수 초기화 */
		N = info.length;
		M = edges.length;
		this.info = info;
		adjList = new ArrayList[N];
		v = new ArrayList[N];
		answer = 0;
		
		/* 메인 로직 */
		for (int i=0; i<N; i++) v[i] = new ArrayList<Integer>();
		for (int i=0; i<M; i++) {
			int s = edges[i][0];
			int e = edges[i][1];
			
			if (adjList[s] == null) {
				adjList[s] = new ArrayList<Integer>();
			}
			
			if (adjList[e] == null) {
				adjList[e] = new ArrayList<Integer>();
			}
			
			adjList[s].add(e);
			adjList[e].add(-s); // 음의 인덱스는 부모 노드
		}
		
		dfs(0, 1, 0, 0);
		
		/* 정답 반환 */
		return answer;
	}
	
	private void dfs(int idx, int cnt0, int cnt1, int visited) {
		if (cnt0 <= cnt1) return;
		visited = visited | (1 << idx);
		for (int vs : v[idx]) {
			if (vs == visited) return;
		}
		v[idx].add(visited);
		
		answer = Math.max(answer, cnt0);
		
		for (int next : adjList[idx]) {
			if (next <= 0) {
				dfs(-next, cnt0, cnt1, visited);
			} else {
				if (info[next] == 0) {
					dfs(next, cnt0 + ((visited & (1 << next)) > 0 ? 0 : 1), cnt1, visited);
				} else {
					dfs(next, cnt0, cnt1 + ((visited & (1 << next)) > 0 ? 0 : 1), visited);
				}
			}
		}
	}
}