package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class BaekJoon_10163 {
	static StringTokenizer st;
	static int[][] board;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[1001][1001];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int fromX = Integer.parseInt(st.nextToken());
			int fromY = Integer.parseInt(st.nextToken());
			int toX = Integer.parseInt(st.nextToken());
			int toY = Integer.parseInt(st.nextToken());
			for (int j=fromY; j<fromY+toY; j++) {
				for (int k=fromX; k<fromX+toX; k++) {
					board[j][k] = i + 1;
				}
			}
		}
		
		cnt = new int[N];
		for (int i=0; i<1001; i++) {
			for (int j=0; j<1001; j++) {
				if (board[i][j] > 0) cnt[board[i][j] - 1]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(cnt[i] + "\n");
		}
		System.out.println(sb);
		br.close();
	}

}
