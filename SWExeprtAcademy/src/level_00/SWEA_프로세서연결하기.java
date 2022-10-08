package level_00;

import java.io.*;
import java.util.*;

/**
 * SWEA_프로세서연결하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 가장자리에 있는 프로세서는 탐색 프로세서에서 제외 
 * 	2. 처음 입력을 받으면서 가장자리인지 아닌지 체크한 뒤 가장자리에 있지 않은 프로세서의 위치를 List에 담음
 * 	3. List에 담긴 프로세서들을 하나씩 4방탐색하면서 전선 연결을 하는데 아래의 조건을 만나면 리턴
 * 		3.1 모든 프로세서 연결에 성공했을 경우
 * 		3.2 이전에 완성된 전선의 길이보다 길어졌을 경우 
 * 		3.3 4방 탐색 중 다른 프로세서에 막혔을 경우 
 * 		3.4 이전 프로세서 연결을 하면서 만들어진 전선과 교차할 경우 
 *  4. 전선이 연결된 곳의 숫자는 2로 변경한다 
 * 
 *
 */
public class SWEA_프로세서연결하기 {
	static int N, min, maxCnt;
	static int[][] board;
	static List<int[]> chip;
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static boolean isBoundary(int r, int c) {
		if (r == 0 || c == 0 || r == N - 1 || c == N - 1) return true;
		return false;
	}
	
	static boolean canConnect(int r, int c, int dr, int dc) {
		int nr = r + dr;
		int nc = c + dc;
		while (true) {
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
			if (board[nr][nc] != 0) {
				return false;
			}
			nr += dr;
			nc += dc;
		}
		return true;
	}
	
	static int connect(int r, int c, int dr, int dc, int fillType) {
		int nr = r + dr;
		int nc = c + dc;
		int cnt = 0;
		while (true) {
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
			board[nr][nc] = fillType;
			
			cnt++;
			nr += dr;
			nc += dc;
		}
		return cnt;
	}
	
	static void dfs(int depth, int cnt, int len) {
		if (depth == chip.size()) {
			if (cnt >= maxCnt) {
				if (cnt > maxCnt) min = len;
				else min = Math.min(min, len);
				maxCnt = cnt;
			}
			return;
		}
		
		int[] cPos = chip.get(depth);
		boolean flag = false;
		for (int i=0; i<4; i++) {
			int dr = drc[i][0];
			int dc = drc[i][1];
			
			if (!canConnect(cPos[0], cPos[1], dr, dc)) continue;
			flag = true;
			int l = connect(cPos[0], cPos[1], dr, dc, 2);
			dfs(depth + 1, cnt + 1, len + l);
			connect(cPos[0], cPos[1], dr, dc, 0);
		}
		
		if (!flag) dfs(depth + 1, cnt, len);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			chip = new ArrayList<>();
			
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						if (isBoundary(i, j)) continue;
						chip.add(new int[] { i, j });
					}
				}
			}
			
			maxCnt = 0;
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			sb.append(String.format("#%d %d\n", tc, min));
		}
		br.close();
		System.out.print(sb);
	}

}
