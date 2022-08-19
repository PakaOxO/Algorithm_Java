package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 오목 판정
public class SWEA_11315 {
	static char[][] board;

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
				if (flag) continue;
				int cnt = 0;
				for (int j=0; j<N; j++) {
					board[i][j] = line.charAt(j);
					if (board[i][j] == 'o') cnt++;
					else cnt = 0;
				}
				if (cnt == 5) flag = true;
			}
			// 세로 체크, 대각선 체크
			if (!flag) {
				for (int i=0; i<N; i++) {
					if (flag) break;
					int vCnt = 0, cCnt1 = 0, cCnt2 = 0;
					for (int j=0; j<N; j++) {
						if (board[j][i] == 'o') vCnt++;
						else vCnt = 0;
					}
					if (board[i][i] == 'o') cCnt1++;
					if (board[i][N-i-1] == 'o') cCnt2++;
					if (vCnt == 5 || cCnt1 == 5 || cCnt2 == 5) flag = true;
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
