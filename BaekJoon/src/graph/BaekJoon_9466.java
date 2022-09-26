package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9466, 텀 프로젝트(HARD)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. visited와 done의 두가지 방문 체크가 필요했던 문제
 * 	2. 현재 탐색에서 방문한 노드를 체크할 visited와 이미 이전에 탐색했던 노드를 관리할 done으로 구분해서 문제에 접근해야함
 *
 */
public class BaekJoon_9466 {
	static int N, answer;
	static int[] nextNode;
	static int[] visitNo;
	static boolean[] done;
	
	static void dfs(int curr, int cnt) {
		if (done[curr]) return;
		
		visitNo[curr] = cnt;
		int next = nextNode[curr];
		if (visitNo[next] == 0) {
			dfs(next, cnt + 1);
		} else {
			answer -= (visitNo[curr] - (visitNo[next] - 1));
		}
		visitNo[curr] = 0;
		done[curr] = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = N;
			visitNo = new int[N + 1];
			nextNode = new int[N + 1];
			done = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				nextNode[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=1; i<=N; i++) {
				dfs(i, 1);
			}
			
			sb.append(answer).append("\n");
		}
		br.close();
		System.out.print(sb);
	}

}
