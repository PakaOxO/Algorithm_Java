package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14500, 테트로미오
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 종이 위 테트로미오를 올릴 시작지점을 탐색하면서 각각의 테트로미오에 대해 놓을 수 있는지 확인
 * 	2. 놓을 수 있다면 종이 위에 위치시켰을때 숫자의 합을 계산하여 저장
 * 	3. max보다 크다면 max에 값을 담으며, 모든 탐색이 종료되었을 때 max를 출력
 *
 */
public class BaekJoon_14500 {
	static int[][] drc = { { 0, 1 } , { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int N, M;
	static int[][] paper;
	static boolean[][] isVisited;
	static int maxNum, max;
	
	static void dfs(int r, int c, int cnt, int sum) {
		if (max >= sum + (maxNum * (4 - cnt))) return;
		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i=0; i<4; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			if (r + dr < 0 || c + dc < 0 || r + dr >= N || c + dc >= M || isVisited[r + dr][c + dc]) continue;
			
			isVisited[r + dr][c + dc] = true;
			dfs(r, c, cnt + 1, sum + paper[r + dr][c + dc]);
			dfs(r + dr, c + dc, cnt + 1, sum + paper[r + dr][c + dc]);
			isVisited[r + dr][c + dc] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		maxNum = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (paper[i][j] > maxNum) maxNum = paper[i][j];
			}
		}
		
		isVisited = new boolean[N][M];
		max = 0;
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				isVisited[r][c] = true;
				dfs(r, c, 1, paper[r][c]);
				isVisited[r][c] = false;
			}
		}
		System.out.println(max);
		br.close();
	}

}
