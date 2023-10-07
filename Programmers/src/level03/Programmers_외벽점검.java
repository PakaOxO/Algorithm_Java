package level03;

public class Programmers_외벽점검 {
	public static void main(String[] args) {
		Solution_외벽점검 s = new Solution_외벽점검();
		
		System.out.println(s.solution(12, new int[] { 1, 5, 6, 10 }, new int[] { 1, 2, 3, 4 }));
		System.out.println(s.solution(12, new int[] { 1, 3, 4, 9, 10 }, new int[] { 3, 5, 7 }));
	}
}

/**
 *	Programmers_외벽 점검
 *		- 문제 분류: 그리디 
 */
class Solution_외벽점검 {
	int MAX_DIST = 100;
	int N, M, D;
	int[] weak, dist;
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
		visited = new boolean[M];
		dCount = new int[MAX_DIST + 1];
		answer = D + 1;
		
		/* 메인 로직 */
		// 거리별 이동할 수 있는 사람 수 
		for (int i=0; i<D; i++) {
			dCount[dist[i]]++;
		}
		
		// 시작 지점 
		for (int i=0; i<M; i++) {
			dfs(i, 0);
		}
		
		/* 정답 반환 */
		return answer > D ? -1 : answer;
	}
	
	private void dfs(int pos, int use) {
		if (use >= answer) return;
		if (visited[pos]) {
			answer = Math.min(answer, use);
			return;
		}
		
		for (int i=MAX_DIST; i>0; i--) {
			if (dCount[i] == 0) continue;
			int end = (pos + 1) % M;
			
			while (true) {
				int d = (weak[end] - weak[pos] + N) % N;
				if (end == pos || visited[end] || d > i) {
					end = (end - 1 + M) % M;
					break;
				}
				end = (end + 1) % M;
			}
			
			int j = pos;
			while (true) {
				visited[j] = true;
				if (j == end) break;
				j = (j + 1) % M;
			}
			
			dCount[i]--;
			dfs((end + 1) % M, use + 1);
			dCount[i]++;
			
			j = pos;
			while (true) {
				visited[j] = false;
				if (j == end) break;
				j = (j + 1) % M;
			}
		}
	}
}