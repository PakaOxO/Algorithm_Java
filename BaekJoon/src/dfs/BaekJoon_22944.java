package dfs;

import java.io.*;
import java.util.*;

// 죽음의 비
public class BaekJoon_22944 {
	static int N, D;
	static char[][] map;
	static boolean[] isVisited;
	static List<int[]> points;
	static int type;
	static int endR, endC;
	static int answer;
	
	static boolean canGo(int r, int c, int tR, int tC, int hp, int u) {
		if (hp + u + 1 - (Math.abs(r - tR) + Math.abs(c - tC)) <= 0) return false;
		return true;
	}
	
	static void dfs(int r, int c, int cnt, int hp, int u) {
		if (r == endR && c == endC) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (cnt >= answer || hp <= 0) return;
		
		if (canGo(r, c, endR, endC, hp, u)) {
			int moveCnt = Math.abs(r - endR) + Math.abs(c - endC);
			if (u > 0) {
				if (u + 1 >= moveCnt) dfs(endR, endC, cnt + moveCnt, hp, u + 1 - moveCnt);
				else dfs(endR, endC, cnt + moveCnt, hp + 1 - (moveCnt - u), 0);
			}
			else dfs(endR, endC, cnt + moveCnt, hp + 1 - moveCnt, 0);
		} else {
			for (int i=0; i<points.size(); i++) {
				int tR = points.get(i)[0];
				int tC = points.get(i)[1];
				if (isVisited[i] || !canGo(r, c, tR, tC, hp, u)) continue;
				int moveCnt = Math.abs(r - tR) + Math.abs(c - tC);
				isVisited[i] = true;
				if (u > 0) {
					if (u + 1 >= moveCnt) dfs(tR, tC, cnt + moveCnt, hp, D - 1);
					else dfs(tR, tC, cnt + moveCnt, hp + 1 - (moveCnt - u), D - 1);
				}
				else dfs(tR, tC, cnt + moveCnt, hp + 1 - moveCnt, D - 1);
				isVisited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new char[N][N];
		points = new ArrayList<>();
		int r = 0, c = 0;
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					r = i;
					c = j;
				} else if (map[i][j] == 'E') {
					endR = i;
					endC = j;
				} else if (map[i][j] == 'U') {
					points.add(new int[] { i, j });
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		isVisited = new boolean[points.size()];
		dfs(r, c, 0, H, 0);
		
		if (answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
		br.close();
	}

}
