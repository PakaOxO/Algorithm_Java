package level03;

import java.util.Arrays;

public class Programmers_외벽점검 {
	public static void main(String[] args) {
		Solution_외벽점검 s = new Solution_외벽점검();
		
		System.out.println(s.solution(12, new int[] { 1, 5, 6, 10 }, new int[] { 1, 2, 3, 4 }));
	}
}

/**
 *	Programmers_외벽 점검
 *		- 문제 분류: 그리디 
 */
class Solution_외벽점검 {
	int MAX_DIST = 8;
	int N, M, D;
	int[] weak, dist;
	boolean[] map;
	boolean[] visited;
	int[] dCount;
	int answer;
	
	public int solution(int n, int[] weak, int[] dist) {
		/* 변수 초기화 */
		N = n;
		M = weak.length;
		D = dist.length;
		this.weak = weak;
		this.dist = dist;
		map = new boolean[N];
		visited = new boolean[M];
		dCount = new int[MAX_DIST + 1];
		answer = D + 1;
		
		/* 메인 로직 */
		// 거리별 이동할 수 있는 사람 수 
		for (int i=0; i<D; i++) {
			dCount[dist[i]]++;
		}
		
		for (int i=0; i<M; i++) {
			map[weak[i]] = true;
		}
		
		// 시작 지점 
		for (int i=0; i<M; i++) {
			dfs(i, 0);
		}
		
		/* 정답 반환 */
		return answer;
	}
	
	private void dfs(int pos, int use) {
		if (use >= answer) return;
		if (visited[pos]) {
			answer = Math.max(answer, use);
			return;
		}
		System.out.println(pos + " " + use + " " + Arrays.toString(visited));
		
		for (int i=MAX_DIST; i>0; i--) {
			if (dCount[i] == 0) continue;
			int end = pos;
			
			while (true) {
				int d = (weak[end] - weak[pos] + N) / N;
				if (visited[end] || d > i || end == pos) {
					end = (end - 1 + N) / N;
					break;
				}
				end = (end + 1) / M;
			}
			
			int j = pos;
			while (true) {
				visited[j] = true;
				if (j == end) break;
				j = (j + 1) / M;
			}
			
			dCount[i]--;
			dfs((end + 1) / M, use + 1);
			dCount[i]++;
			
			j = pos;
			while (true) {
				visited[j] = false;
				if (j == end) break;
				j = (j + 1) / N;
			}
		}
	}
}