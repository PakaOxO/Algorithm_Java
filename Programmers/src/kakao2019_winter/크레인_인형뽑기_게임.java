package kakao2019_winter;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
	static int N;
	static int[][] board;
	static int[] moves;
	static Stack<Integer> stack = new Stack<>();
	
	// 해당 위치의 크레인 작동 
	static int lift(int pos) {
		int score = 0;
		pos -= 1;
		
		for (int i=0; i<N; i++) {
			if (board[i][pos] == 0)
				continue;
			
			// 바구니에 담긴 인형이 없으면 새로운 인형을 담고 stop 
			if (stack.isEmpty()) {
				stack.push(board[i][pos]);
				board[i][pos] = 0;
				break;
			}
			
			// 바구니에 인형이 있었으면 최상단 인형과 현재 인형을 비교 
			int top = stack.peek();
			if (top == board[i][pos]) {
				stack.pop();
				score += 2;
			} else {
				stack.push(board[i][pos]);
			}
			board[i][pos] = 0;
			break;
		}
		return score;
	}
	
	static void copyArr(int[][] org_board, int[] org_moves) {
		N = org_board.length;
		int M = org_moves.length;
		
		board = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				board[i][j] = org_board[i][j];
			}
		}
		
		moves = new int[M];
		for (int i=0; i<M; i++) moves[i] = org_moves[i];
	}
	
	public int solution(int[][] board, int[] moves) {
		// 입력값들을 전역 변수 배열에 복사 
		copyArr(board, moves);
		
		int answer = 0;
		// 각 위치의 크레인 작동 
		for (int i=0; i<moves.length; i++) {
			answer += lift(moves[i]);
		}
		
		return answer;
	}
}
