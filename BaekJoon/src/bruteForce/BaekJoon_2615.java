package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2615, 오복
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 19X19 오목판을 순회하면서 바둑알을 만나면 탐색 실시
 * 
 * 	2. 탐색의 조건은 다음과 같다.
 * 		2.1 탐색하려는 방향 이전에 동일한 바둑알이 있다면 탐색하지 않는다.(이전 순회에서 탐색했던 바둑알이기 때문)
 * 		2.2 탐색하려는 방향은 가로, 세로, 대각선(우), 대각선(좌) 총 4가지이다.
 * 
 * 	3. 각 탐색에 대해 오목이 성립하면 순회를 종료하고 승자를 출력한다.
 * 
 * 	4. 문제를 꼼꼼히 읽을 것... 출력해야 하는 행,열 위치는 오목 판정 기준 왼쪽 시작점이 되어야 함.(좌하 대각선에서 오른쪽 위 위치를 출력하고 있었음)
 *
 */
public class BaekJoon_2615 {
	static int[][] board;
	
	static void checkV(int r, int c) {
		if (board[r][c] == board[r - 1][c]) return;
		int cnt = 1;
		while (cnt < 5) {
			if (board[r][c] != board[r + cnt][c]) break;
			cnt++;
		}
		if (cnt < 5) return;
		if (board[r][c] == board[r + cnt][c]) return;
		System.out.println(board[r][c]);
		System.out.println(r + " " + c);
		System.exit(0);
	}
	
	static void checkH(int r, int c) {
		if (board[r][c] == board[r][c - 1]) return;
		int cnt = 1;
		while (cnt < 5) {
			if (board[r][c] != board[r][c + cnt]) break;
			cnt++;
		}
		if (cnt < 5) return;
		if (board[r][c] == board[r][c + cnt]) return;
		System.out.println(board[r][c]);
		System.out.println(r + " " + c);
		System.exit(0);
	}
	
	static void checkC1(int r, int c) {
		if (board[r][c] == board[r - 1][c - 1]) return;
		int cnt = 1;
		while (cnt < 5) {
			if (board[r][c] != board[r + cnt][c + cnt]) break;
			cnt++;
		}
		if (cnt < 5) return;
		if (board[r][c] == board[r + cnt][c + cnt]) return;
		System.out.println(board[r][c]);
		System.out.println(r + " " + c);
		System.exit(0);
	}
	
	static void checkC2(int r, int c) {
		if (board[r][c] == board[r - 1][c + 1]) return;
		int cnt = 1;
		while (cnt < 5) {
			if (board[r][c] != board[r + cnt][c - cnt]) break;
			cnt++;
		}
		if (cnt < 5) return;
		if (board[r][c] == board[r + cnt][c - cnt]) return;
		System.out.println(board[r][c]);
		System.out.println((r + 4) + " " + (c - 4));
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[21][21];
		for (int i=1; i<=19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1; j<=19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=19; i++) {
			for (int j=1; j<=19; j++) {
				if (board[i][j] == 0) continue;
				checkH(i, j);
				checkV(i, j);
				checkC1(i, j);
				checkC2(i, j);
			}
		}
		System.out.println(0);
		br.close();
	}

}
