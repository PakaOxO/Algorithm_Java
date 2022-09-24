package recursive;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14889, 스타트와 링크
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 팀 인원은 무조건 N/2명이므로 N명 중에 N/2명을 뽑는 경우의 수 체크
 * 	2. N/2명을 뽑았다면 전체 N명에서 두명을 뽑는 조합을 체크
 * 		2.1 뽑는 과정에서 뽑힌 두 사람이 다른 팀이라면 다시 뽑음
 * 		2.2 같은 팀인 두 명을 뽑았으면 팀의 stat를 계산하여 최소값(answer) 갱신
 * 	3. 팀의 stat의 최소값을 출력
 *
 */
public class BaekJoon_14889 {
	static int N, answer;
	static int[][] stat;
	static boolean[] isVisited;
	
	static void check() {
		int sumA, sumB;
		sumA = sumB = 0;
		List<Integer> teamA = new ArrayList<>();
		List<Integer> teamB = new ArrayList<>();
		for (int i=0; i<N; i++) {
			if (isVisited[i]) teamA.add(i);
			else teamB.add(i);
		}
		for (int i=0; i<N/2-1; i++) {
			for (int j=i+1; j<N/2; j++) {
				sumA += stat[teamA.get(i)][teamA.get(j)] + stat[teamA.get(j)][teamA.get(i)];
				sumB += stat[teamB.get(i)][teamB.get(j)] + stat[teamB.get(j)][teamB.get(i)];
			}
		}
		answer = Math.min(answer, Math.abs(sumA - sumB));
	}
	
	static void dfs(int start, int cnt) {
		if (cnt == N / 2) {
			check();
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			dfs(i + 1, cnt + 1);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stat = new int[N][N];
		isVisited = new boolean[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(answer);
	}

}
