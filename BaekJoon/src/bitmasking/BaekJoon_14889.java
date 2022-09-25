package bitmasking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14889, 스타트와 링크
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 비트마스킹을 사용한 조합에서 뽑는 개수의 조건이 있는 문제
 * 	2. 뽑을 수 있는 모든 가지수(N^2)를 탐색하면서 뽑힌 개수가 N/2가 아니면 다음 조합 탐색으로 넘어가는 로직이 필요
 *
 */
public class BaekJoon_14889 {
	static int[][] stat;
	static List<Integer> teamA;
	static List<Integer> teamB;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int answer = Integer.MAX_VALUE;
		for (int i=0; i<(1<<N); i++) {
			teamA = new ArrayList<>();
			teamB = new ArrayList<>();
			
			for (int j=0; j<N; j++) {
				if ((i & (1 << j)) > 0) {
					teamA.add(j);
				} else teamB.add(j);
			}
			if (teamA.size() != N/2) continue;
			
			int sumA = 0;
			int sumB = 0;
			for (int j=0; j<N/2; j++) {
				for (int k=j+1; k<N/2; k++) {
					sumA += stat[teamA.get(j)][teamA.get(k)] + stat[teamA.get(k)][teamA.get(j)];
					sumB += stat[teamB.get(j)][teamB.get(k)] + stat[teamB.get(k)][teamB.get(j)];
				}
			}
			answer = Math.min(answer, Math.abs(sumA - sumB));
		}
		System.out.println(answer);
	}

}
