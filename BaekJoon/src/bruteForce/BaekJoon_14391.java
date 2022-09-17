package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14391, 종이 조각
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 완전 탐색을 통해 먼저 첫 번째 가로 줄을 탐색해 고를 수 있는 조합의 수(1~M개의 숫자)를 선택
 * 	2. 첫 가로 줄의 탐색이 끝나면 ~N번 가로 줄까지 반복
 * 	3. 가로 줄 하나하나의 탐색이 끝날 때마다 가로 줄에서 선택된 숫자의 합(이어져 있는 경우 자리수를 늘려가며)을 도출해 sum에 저장
 * 	4. 모든 가로줄의 탐색이 끝나면 남은 건 세로줄인데 가로 줄 선택에 의해 세로 줄은 자동으로 선택되어짐
 * 	5. 가로 줄에서 가로세로 1 크기의 숫자는 이미 탐색을 했으므로 세로 줄은 2이상의 숫자만 나올 수 있음
 * 	6. 세로 줄의 모든 숫자의 합을 기존의 가로 줄 숫자의 합과 더해 최대값과 비교한 뒤 더 크면 저장
 *
 */
public class BaekJoon_14391 {
	static int N, M;
	static int[][] map;
	static boolean[][] isVisited;
	static int max;
	
	static int cal(int r, int c, int type) {
		int sum = 0;
		int total = 0;
		if (type == 0) {
			for (int i=0; i<M; i++) {
				if (isVisited[r][i]) {
					sum = sum * 10 + map[r][i];
				} else {
					total += sum;
					sum = 0;
				}
			}
			total += sum;
		} else {
			for (int j=0; j<M; j++) {
				sum = 0;
				for (int i=0; i<N; i++) {
					if (!isVisited[i][j]) {
						sum = sum * 10 + map[i][j];
					} else {
						if (sum >= 10) {
							total += sum;
						}
						sum = 0;
					}
				}
				total += sum;
			}
		}
		return total;
	}
	
	static void dfs(int r, int c, int sum) {
		if (c == M) {
			dfs(r + 1, 0, sum + cal(r, c, 0));
			return;
		}
		if (r == N) {
			max = Math.max(max, sum + cal(r, c, 1));
			return;
		}
		
		isVisited[r][c] = true;
		dfs(r, c + 1, sum);
		isVisited[r][c] = false;
		dfs(r, c + 1, sum);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = (int)(line.charAt(j) - '0');
			}
		}

		isVisited = new boolean[N][M];
		dfs(0, 0, 0);
		
		System.out.println(max);
		br.close();
	}

}
