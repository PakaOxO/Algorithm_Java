package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15661, 링크와 스타트
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. A팀에 들어갈 인원을 조합으로 뽑으면 B팀에 배정될 인원은 자동으로 결정
 * 	2. A팀 인원을 만들면서 A팀, B팀의 stat 계산
 * 	3. 계산된 stat으로 stat차이를 min과 비교해 최소값 도출
 * 	4. 조합 탐색 종료 후 min 출력
 *
 */
public class BaekJoon_15661 {
	static int N;
	static int[][] info;
	static boolean[] isMemberTeamA;
	static int min;
	
	static void dfs(int start, int cnt) {
		if (cnt == N - 1) return;
		
		if (cnt > 0) {
			int statA = 0;
			int statB = 0;
			for (int i=0; i<N; i++) {
				if (isMemberTeamA[i]) {
					for (int j=0; j<N; j++) {
						if (i == j) continue;
						if (!isMemberTeamA[j]) continue;
						statA += info[i][j];
					}
				} else {
					for (int j=0; j<N; j++) {
						if (i == j) continue;
						if (isMemberTeamA[j]) continue;
						statB += info[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(statA - statB));
		}
		
		for (int i=start; i<N; i++) {
			isMemberTeamA[i] = true;
			dfs(i + 1, cnt + 1);
			isMemberTeamA[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		info = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isMemberTeamA = new boolean[N];
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(min);
		br.close();
	}

}
