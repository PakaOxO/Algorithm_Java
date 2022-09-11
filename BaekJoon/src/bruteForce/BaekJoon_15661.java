package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15661, 링크와 스타트
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
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
