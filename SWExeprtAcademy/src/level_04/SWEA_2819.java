package level_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 격자판의 숫자 이어 붙이기
public class SWEA_2819 {
	static int[][] board;
	static int[][] drc = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	static Set<Integer> set;
	
	static void travel(int r, int c, int cnt, int num) {
		if (cnt > 6) {
			set.add(num);
			return;
		}
		
		for (int i=0; i<4; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			if (r + dr < 0 || r + dr >= 4 || c + dc < 0 || c + dc >= 4) continue;
			travel(r + dr, c + dc, cnt + 1, num * 10 + board[r][c]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			board = new int[4][4];
			set = new HashSet<>();
			for (int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<4; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					travel(i, j, 0, board[i][j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
