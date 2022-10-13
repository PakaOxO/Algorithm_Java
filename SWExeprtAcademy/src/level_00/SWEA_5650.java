package level_00;

import java.io.*;
import java.util.*;

/**
 * SWEA_5650, 핀볼 게임
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 처음에 if/else 노가다로 벽 타입별로 튕겨나가는 방향을 달리해주도록 풀이...
 * 	2. 현재 방향-마주친 벽 타입에 대해 튕겨나가는 방향은 고정되어 있으므로 아래와 같이 nDir 배열을 만들어 해결하면 되었음
 * 	3. 외벽(경계)은 정사각형 벽과 동일한 메커니즘이므로 해당 nDir에 의해 방향이 바뀌도록 수정
 * 	4. 나머지 풀이들은 문제에 주어진 대로 구현하면 되었음.
 *
 */
public class SWEA_5650 {
	static int N, sR, sC, dir, cnt, answer;
	static int[][] board;
	static int[][][] hole;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] nDir = { { 0, 1, 2, 3 },
							{ 2, 3, 1, 0 },
							{ 1, 3, 0, 2 },
							{ 3, 2, 0, 1 },
							{ 2, 0, 3, 1 },
							{ 2, 3, 0, 1 }
						  };
	static List<int[]> start;
	
	static void play() {
		int nr = sR;
		int nc = sC;
		int type;
		while (true) {
			nr += drc[dir][0];
			nc += drc[dir][1];
			type = board[nr][nc];
			
			if ((nr == sR && nc == sC) || type == -1) {
				break;
			}
			
			if (nr == 0 || nc == 0 || nr == N + 1 || nc == N + 1) {
				dir = nDir[5][dir];
				cnt++;
			} else if (type < 6) {
				dir = nDir[type][dir];
				if (type != 0) cnt++;
			} else {
				if (nr == hole[type - 6][0][0] && nc == hole[type - 6][0][1]) {
					nr = hole[type - 6][1][0];
					nc = hole[type - 6][1][1];
				} else {
					nr = hole[type - 6][0][0];
					nc = hole[type - 6][0][1];
				}
				
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N + 2][N + 2];
			start = new ArrayList<>();
			hole = new int[5][2][2];
			for (int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if (board[i][j] == 0) start.add(new int[] { i, j });
					else if (board[i][j] >= 6 && board[i][j] <= 10) {
						if (hole[board[i][j] - 6][0][0] == 0) {
							hole[board[i][j] - 6][0][0] = i;
							hole[board[i][j] - 6][0][1] = j;
						} else {
							hole[board[i][j] - 6][1][0] = i;
							hole[board[i][j] - 6][1][1] = j;
						}
					}
				}
			}
			
			answer = 0;
			for (int s[] : start) {
				for (int i=0; i<4; i++) {
					sR = s[0];
					sC = s[1];
					
					dir = i;
					cnt = 0;
					play();
					answer = Math.max(answer, cnt);
				}
			}
			sb.append(String.format("#%d %d\n", tc, answer));
		}
		br.close();
		
		System.out.print(sb);
	}

}
