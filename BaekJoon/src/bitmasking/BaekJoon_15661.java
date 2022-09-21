package bitmasking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15661, 링크와 스타트
 * @author kevin-Arpe
 * 
 * Sketch Idea (이전에 백트래킹으로 풀었던 문제)
 * 	1. N개의 요소 중 절반을 뽑아 두 그룹으로 나누어야 함(사실 1, N - 1 그룹으로 한 팀에는 한명만 있는 것도 가능)
 * 	2. 1 << (LEFT SHIFT) N하면 2^N 이므로 뽑을 수 있는 조합의 개수를 의미
 * 		2.1 최소 1명 이상 뽑아야하므로 뽑을 때 i는 1부터 1<<M미만 범위에서 움직임 
 * 		2.2 j는 해당 위치의 선수가 뽑혔는지 확인, i와 AND 비트 연산을 수행해 0이면 미포함 1이면 포함
 * 		2.3 포함된 선수는 A팀에 미포함된 선수는 자동으로 B팀으로 배정
 * 		
 *
 */
public class BaekJoon_15661 {
	static int[][] stats;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		stats = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int min = Integer.MAX_VALUE;
		for (int i=1; i<(1<<N); i++) {
			List<Integer> tA = new ArrayList<>();
			List<Integer> tB = new ArrayList<>();
			for (int j=0; j<N; j++) {
				if ((i & (1 << j)) == 0) {
					tA.add(j);
				} else tB.add(j);
			}
			if (tA.size() != N / 2) continue;
			
			int A = 0;
			int B = 0;
			for (int j=0; j<N/2; j++) {
				for (int k=j+1; k<N/2; k++) {
					A += stats[tA.get(j)][tA.get(k)] + stats[tA.get(k)][tA.get(j)];
					B += stats[tB.get(j)][tB.get(k)] + stats[tB.get(k)][tB.get(j)];
				}
			}
			min = Math.min(min, Math.abs(A - B));
		}
		System.out.println(min);
	}

}
