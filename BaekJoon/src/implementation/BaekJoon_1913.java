package implementation;

import java.io.*;

// 달팽이
public class BaekJoon_1913 {
	static int[][] snail;
	static boolean[][] isFilled;
	static int[][] drc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int X = Integer.parseInt(br.readLine());
		
		snail = new int[N][N];
		isFilled = new boolean[N][N];
		
		int squareN = N * N;
		int r = -1, c = 0;
		int dir = 0;
		while (squareN > 0) {
			for (int i=dir; i<4; i=(i+1)%4) {
				int dr = drc[i][0];
				int dc = drc[i][1];
				if (r + dr < 0 || r + dr >= N || c + dc < 0 || c + dc >= N || isFilled[r + dr][c + dc]) {
					dir = (dir + 1) % 4;
					continue;
				}
				snail[r + dr][c + dc] = squareN--;
				isFilled[r + dr][c + dc] = true;
				r = r + dr;
				c = c + dc;
				dir = i;
				break;
			}
		}
		int posR = 0;
		int posC = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(snail[i][j]);
				if (snail[i][j] == X) {
					posR = i;
					posC = j;
				}
				if (j < N - 1) sb.append(" ");
			}
			sb.append("\n");
		}
		sb.append(posR + 1).append(" ").append(posC + 1);
		System.out.println(sb);
		br.close();
	}

}
