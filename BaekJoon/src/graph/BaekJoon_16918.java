package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16918, 봄버맨
 * @author kevin-Arpe
 * 
 * Sketch Idea
 *
 */
public class BaekJoon_16918 {
	static int R, C, N;
	static char[][] map;
	static int[][] cnt;
	
	static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	
	static void explode(int r, int c, int curr) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		map[r][c] = '.';
		cnt[r][c] = 0;
		
		while (q.size() > 0) {
			int[] now = q.remove();
			for (int i=0; i<4; i++) {
				int nr = now[0] + drc[i][0];
				int nc = now[1] + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if (map[nr][nc] == 'O') {
					if (cnt[nr][nc] == curr) q.add(new int[] { nr, nc });
					map[nr][nc] = '.';
					cnt[nr][nc] = 0;
				}
			}
		}
	}
	
	static void setBomb(int next) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'O') continue;
				map[i][j] = 'O';
				cnt[i][j] = next;
			}
		}
	}
	
	static String getMap() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<R; i++) {
			sb.append(new String(map[i])).append("\n");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		cnt = new int[R][C];
		for (int i=0; i<R; i++) {
			String line = br.readLine();
			for (int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'O') cnt[i][j] = 1;
			}
		}
		
		if (N < 2) {
			System.out.print(getMap());
		} else {
			N--;
			int curr = 1;
			while (true) {
				setBomb(curr + 1);
				N--;
				if (N == 0) break;
				
				for (int i=0; i<R; i++) {
					for (int j=0; j<C; j++) {
						if (map[i][j] != 'O' || cnt[i][j] != curr) continue;
						explode(i, j, curr);
					}
				}
				curr++;
				N--;
				if (N == 0) break;
			}
			System.out.println(getMap());
		}
		br.close();
	}

}
