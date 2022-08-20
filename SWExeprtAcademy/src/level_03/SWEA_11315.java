package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 오목 판정
public class SWEA_11315 {
	static char[][] board;
	static int cCnt;
	
	static boolean checkLeftCross(int i, int j, int N) {
		if (i + 4 >= N || j - 4 < 0) return false;
		for (int k=1; k<=4; k++) {
			if (board[i+k][j-k] != 'o') return false;
		}
		return true;
	}
	
	static boolean checkRightCross(int i, int j, int N) {
		if (i + 4 >= N || j + 4 >= N) return false;
		for (int k=1; k<=4; k++) {
			if (board[i+k][j+k] != 'o') return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			boolean flag = false;
			// 데이터 가져오면서 가로 체크
			for (int i=0; i<N; i++) {
				String line = br.readLine();
				int cnt = 0;
				for (int j=0; j<N; j++) {
					board[i][j] = line.charAt(j);
					if (flag) continue;
					
					if (board[i][j] == 'o') cnt++;
					else cnt = 0;
					if (cnt == 5) flag = true;
				}
			}
			// 세로 체크
			if (!flag) {
				for (int i=0; i<N; i++) {
					if (flag) break;
					int vCnt = 0;
					for (int j=0; j<N; j++) {
						if (board[j][i] == 'o') vCnt++;
						else vCnt = 0;
						if (vCnt == 5) {
							flag = true;
							break;
						}
					}
				}
			}
			// 대각선 체크
			if (!flag) {
				cCnt = 0;
				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						if (board[i][j] != 'o') continue;
						if (checkLeftCross(i, j, N)) {
							flag = true;
							break;
						}
						if (checkRightCross(i, j, N)) {
							flag = true;
							break;
						}
					}
				}
			}
			
			if (flag) {
				sb.append("#").append(tc).append(" YES\n");
			} else sb.append("#").append(tc).append(" NO\n");
		}
		System.out.println(sb);
		br.close();
	}

}
