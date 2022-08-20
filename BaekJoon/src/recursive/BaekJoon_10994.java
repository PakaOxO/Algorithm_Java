package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 별 찍기
public class BaekJoon_10994 {
	static int N;
	static char[][] board;
	static int rMid;
	static int cMid;
	
	static void dfs(int M) {
		if (M == N) return;
		int rFrom = rMid - (M * 2);
		int rTo = rMid + (M * 2);
		int cFrom = cMid - (M * 2);
		int cTo = cMid + (M * 2);
		for (int i=rFrom; i<=rTo; i++) {
			for (int j=cFrom; j<=cTo; j++) {
				board[i][cFrom] = '*';
				board[i][cTo] = '*';
				if (i == rFrom || i == rTo) {
					board[i][j] = '*';
				}
			}
		}
		dfs(M + 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[4*N-3][4*N-3];
		rMid = (4*N-3) / 2;
		cMid = (4*N-3) / 2;
		
		for (int i=0; i<4*N-3; i++) {
			for (int j=0; j<4*N-3; j++) {
				board[i][j] = ' ';
			}
		}
		
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<4*N-3; i++) {
			for (int j=0; j<4*N-3; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}