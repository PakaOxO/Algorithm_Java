
import java.io.*;
import java.util.*;

public class Solution3 {
	static int N;
	static int[][] board;
	static List<int[]> corePos;
	static boolean[] isConnected;
	static int cntConn;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	
	static int maxConn;
	static int answer;
	
	static boolean checkAround(int r, int c) {
		for (int i=0; i<4; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			if (r + dr < 0 || r + dr >= N || c + dc < 0 || c + dc >= N) return true;
		}
		return false;
	}
	
	static int[][] connectTo(int r, int c, int dr, int dc, int[][] board) {
		int[][] b = Arrays.copyOf(board, N);
		while (true) {
			r += dr;
			c += dc;
			b[r][c] = 2;
			if (r == 0 || r == N - 1 || c == 0 || c == N - 1) break;
		}
		return b;
	}
	
	static int checkDir(int r, int c, int dr, int dc, int[][] board) {
		int len = 0;
		while (true) {
			r += dr;
			c += dc;
			if (board[r][c] == 1 || board[r][c] == 2) return -1;
			len++;
			if (r == 0 || r == N - 1 || c == 0 || c == N - 1) break;
		}
		return len;
	}
	
	static void connect(int[][] board, int totalCnt, int totalLen) {
		if (totalCnt >= maxConn) {
			if (totalCnt == maxConn) answer = Math.min(totalLen, answer);
			else {
				maxConn = totalCnt;
				answer = totalLen;
			}
		}
		
		for (int i=0; i<corePos.size(); i++) {
			if (isConnected[i]) continue;
			int r = corePos.get(i)[0];
			int c = corePos.get(i)[1];
			
			for (int j=0; j<4; j++) {
				int dr = drc[j][0];
				int dc = drc[j][1];
				int len = checkDir(r, c, dr, dc, board);
				if (len > 0) {
					int nextBoard[][] = connectTo(r, c, dr, dc, board);
					isConnected[i] = true;
					connect(nextBoard, totalCnt + 1, totalLen + len);
					isConnected[i] = false;
				}
			}
			for (int j=0; j<N; j++) {
				System.out.println(Arrays.toString(board[j]));
			}
			System.out.println();
		}
	}
	
	static void checkCore() {
		for (int i=0; i<corePos.size(); i++) {
			int r = corePos.get(i)[0];
			int c = corePos.get(i)[1];
			if (checkAround(r, c)) {
				isConnected[i] = true;
				cntConn++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			corePos = new ArrayList<>();
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) corePos.add(new int[] { i, j });
				}
			}
			cntConn = 0;
			maxConn = 0;
			isConnected = new boolean[corePos.size()];
			checkCore();
			connect(board, 0, 0);
			
			System.out.println(maxConn);
			System.out.println(answer);
		}
	}

}
