package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16973, 직사각형 탈출
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 시작 시점에서 BFS 탐색 시작
 * 		1.1 다음 이동 지역이 이전 방문 지역이거나, 범위를 벗어나거나, 사각형 넓이로 전체 경계 또는 벽에 의해 못 움직일 경우 해당 지역 이동 불가
 * 		1.2 벽에 의해 못움직이는 경우를 찾는 방법은 2가지를 사용했었는데
 * 			1.2.1 하나는 움직인 지점(왼위)에서 사각형 넓이 만큼 탐색하면서 1(벽)이 있는지 체크
 * 			1.2.2 다른 하나는 이전에 입력을 받으면서 누적합을 구하는데 해당 지역에 벽이 있는 경우에는 누적합이 0보다 커짐.
 * 	2. 노드가 목표 지점에 도착했다면 BFS탐색을 종료하고 리턴, 그리고 해당 노드의 depth 값을 반환
 *
 */
public class BaekJoon_16973 {
	static int H, W, squareH, squareW, endR, endC, answer;
	static int[][] board;
	static int[][] prefixSum;
	static boolean[][] isVisited;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static boolean check(int r, int c) {
		if (r < 1 || c < 1 || r > H || c > W || isVisited[r][c]) return false;
		if (r + squareH - 1 > H || c + squareW - 1 > W) return false;
		int sum = prefixSum[r + squareH - 1][c + squareW - 1] - prefixSum[r + squareH - 1][c - 1] - prefixSum[r - 1][c + squareW - 1] + prefixSum[r - 1][c - 1];
		return (sum == 0) ? true : false;
	}
	
	static void bfs(int sR, int sC) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sR, sC, 0 });
		isVisited[sR][sC] = true;
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr[0] + drc[i][0];
				int nc = curr[1] + drc[i][1];
				int depth = curr[2];
				
				if (!check(nr, nc)) continue;
				if (nr == endR && nc == endC) {
					answer = depth + 1;
					return;
				}
				q.offer(new int[] { nr, nc, depth + 1 });
				isVisited[nr][nc] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		board = new int[H + 1][W + 1];
		prefixSum = new int[H + 1][W + 1];
		isVisited = new boolean[H + 1][W + 1];
		for (int i=1; i<=H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + board[i][j];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		squareH = Integer.parseInt(st.nextToken());
		squareW = Integer.parseInt(st.nextToken());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		endR = Integer.parseInt(st.nextToken());
		endC = Integer.parseInt(st.nextToken());
		br.close();
		
		answer = -1;
		bfs(startR, startC);
		System.out.println(answer);
	}

}
