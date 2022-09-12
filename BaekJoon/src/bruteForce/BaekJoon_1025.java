package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1025, 제곱수 찾기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 행, 열이 등차수열인 조건에서 만들 수 있는 수의 조합을 탐색
 * 	2. 숫자를 찾으면 완전제곱수인지 확인해서 완전제곱수이면 max에 저장
 * 	3. 완전제곱수를 찾는 과정에서 이전 max값보다 큰 값이면 max의 값을 교체
 *
 */
public class BaekJoon_1025 {
	static int N, M;
	static int[][] arr;
	static int max;
	
	static void dfs(int dr, int dc, int r, int c, int num) {
		int sqrt = (int)Math.sqrt(num);
		if (sqrt * sqrt == num) {
			max = Math.max(max, num);
		}
		if (dr == 0 && dc == 0) return;
		if (r + dr < 0 || c + dc < 0 || r + dr >= N || c + dc >= M) return;
		dfs(dr, dc, r + dr, c + dc, num * 10 + arr[r+dr][c+dc]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) arr[i][j] = (int)(line.charAt(j) - '0');
		}
		
		max = -1;
		for (int i=-N+1; i<N; i++) {
			for (int j=-M+1; j<M; j++) {
				for (int r=0; r<N; r++) {
					for (int c=0; c<M; c++) {
						dfs(i, j, r, c, arr[r][c]);
					}
				}
			}
		}
		System.out.println(max);
		br.close();
	}

}
