package bitmasking;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14391, 종이 조각
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 종이 조각은 최대 2^N개로 쪼개질 수 있음
 * 	2. 만들 수 있는 모든 조합에서 선택된 친구들은 가로 선택되지 않은 친구들은 세로라 가정
 * 	3. N*M 배열(isVisited) 배열을 돌면서 true면 가로 선택, false면 세로 선택이므로 가로, 세로 숫자 합을 각각 구해서 더함
 * 	4. 합계와 answer을 비교해서 최대값 갱신
 *
 */
public class BaekJoon_14391 {
	static int N, M;
	static int[][] board;
	static boolean[][] isVisited;
	static int answer;
	
	static void check() {
		int sumR = 0;
		for (int i=0; i<N; i++) {
			int numR = 0;
			for (int j=0; j<M; j++) {
				if (isVisited[i][j]) {
					numR = numR * 10 + board[i][j];
					if (j == M - 1) sumR += numR;
				} else {
					sumR += numR;
					numR = 0;
				}
			}
		}
		
		int sumC = 0;
		for (int i=0; i<M; i++) {
			int numC = 0;
			for (int j=0; j<N; j++) {
				if (!isVisited[j][i]) {
					numC = numC * 10 + board[j][i];
					if (j == N - 1) sumC += numC;
				} else {
					sumC += numC;
					numC = 0;
				}
			}
		}
		answer = Math.max(answer, sumR + sumC);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<M; j++) {
				board[i][j] = (int)(input.charAt(j) - '0');
			}
		}
		br.close();
		
		answer = 0;
		for (int i=0; i<(1<<(N*M)); i++) {
			int comb = i;
			int row = 0;
			int col = 0;
			isVisited = new boolean[N][M];
			while (comb > 0) {
				if ((comb & (1 << col)) > 0) {
					isVisited[row][col] = true;
				}
				col++;
				if (col == M) {
					col = 0;
					row++;
					comb = comb >> M;
				}
				if (row == N) break;
			}
			check();
		}
		System.out.println(answer);
	}

}
