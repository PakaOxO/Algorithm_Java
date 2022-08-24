package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1
public class BaekJoon_17070 {
	static int N;
	static int[][] board;
	static int cnt;
	
	static void findPath(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			cnt++;
			return;
		}
		if (dir != 1 && c + 1 < N && board[r][c + 1] == 0) findPath(r, c + 1, 0);
		if (dir != 0 && r + 1 < N && board[r + 1][c] == 0) findPath(r + 1, c, 1);
		if (r + 1 < N && c + 1 < N && board[r + 1][c] == 0 && board[r][c + 1] == 0 && board[r + 1][c + 1] == 0) {
			findPath(r + 1, c + 1, 2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		findPath(0, 1, 0);
		System.out.println(cnt);
		br.close();
	}

}
