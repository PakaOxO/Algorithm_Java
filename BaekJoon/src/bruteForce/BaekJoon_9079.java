package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_9079, 동전 게임 
 * @author kevin-Arpe
 * 
 * Sketch Idea (재욱님 리뷰 참고)
 * 	1. 동전을 flip할 수 있는 가지 수는 총 8가지로
 * 		1.1 가로(1~3행)
 * 		1.2 세로(1~3열)
 * 		1.3 좌우 대각선 
 * 
 * 	2. 8개의 가지수를 완전 탐색하면서 1개~8개 뽑는 조합을 찾아 뒤집어주며 동전뒤집기가 종료되는지 체크
 * 		2.1 동전 뒤집기 게임이 종료되면 그 때의 사용한 flip의 수(cnt)를 min과 비교해 작은 값을 저장
 * 		2.2 종료되지 않으면 다음 조합을 계속해서 탐색
 * 
 * 	3. 최소 flip의 개수를 출력 
 *
 */
public class BaekJoon_9079 {
	static boolean[][] board;
	static int min;
	
	static void reverseH(int r) {
		board[r][0] = !board[r][0];
		board[r][1] = !board[r][1];
		board[r][2] = !board[r][2];
	}
	
	static void reverseV(int c) {
		board[0][c] = !board[0][c];
		board[1][c] = !board[1][c];
		board[2][c] = !board[2][c];
	}
	
	static void reverseC(int type) {
		if (type == 0) {
			board[0][0] = !board[0][0];
			board[1][1] = !board[1][1];
			board[2][2] = !board[2][2];
		} else {
			board[0][2] = !board[0][2];
			board[1][1] = !board[1][1];
			board[2][0] = !board[2][0];
		}
	}
	
	static boolean check() {
		boolean prev = board[0][0];
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (board[i][j] != prev) return false;
			}
		}
		return true;
	}
	
	static void flip(int type) {
		if (type == 0) reverseH(0);
		else if (type == 1) reverseH(1);
		else if (type == 2) reverseH(2);
		else if (type == 3) reverseV(0);
		else if (type == 4) reverseV(1);
		else if (type == 5) reverseV(2);
		else if (type == 6) reverseC(0);
		else reverseC(1);
	}
	
	static void bfs(int start, int cnt) {
		if (check()) {
			min = Math.min(min, cnt);
		}
		if (cnt == 8) {
			return;
		}
		
		for (int i=start; i<8; i++) {
			bfs(i + 1, cnt);
			flip(i);
			bfs(i + 1, cnt + 1);
			flip(i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			board = new boolean[3][3];
			for (int i=0; i<3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<3; j++) {
					if (st.nextToken().charAt(0) == 'T') board[i][j] = true;
				}
			}
			
			min = Integer.MAX_VALUE;
			bfs(0, 0);
			
			if (min == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(min);
		}
		br.close();
	}

}
