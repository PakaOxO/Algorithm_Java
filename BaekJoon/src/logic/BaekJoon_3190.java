package logic;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_3190, 뱀
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 단순 구현 문제, 문제에서 주어진 대로 구현..
 *
 */
public class BaekJoon_3190 {
	static int N, K, L, d;
	static int[][] map;
	static char[] dir;
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Deque<int[]> snail;
	
	static int checkDir(int time) {
		if (dir[time] == 0) return d;
		
		if (dir[time] == 'L') return (d - 1 < 0) ? d - 1 + 4 : d - 1;
		else return (d + 1) % 4;
	}
	
	static boolean move(int r, int c) {
		int nr = r + drc[d][0];
		int nc = c + drc[d][1];
		if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 2) return false;
		
		if (map[nr][nc] == 1) {
			snail.offerFirst(new int[] { nr, nc });
			map[nr][nc] = 2;
		} else {
			snail.offerFirst(new int[] { nr, nc });
			map[nr][nc] = 2;
			int[] tail = snail.pollLast();
			map[tail[0]][tail[1]] = 0;
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		dir = new char[10001];
		for (int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			dir[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
		}
		
		int time = 1;
		d = 1; // 서쪽 방향
		snail = new ArrayDeque<>();
		snail.addFirst(new int[] { 0, 0 });
		map[0][0] = 2;
		
		while (true) {
			int[] head = snail.peekFirst();
			boolean flag = move(head[0], head[1]);
			if (!flag) break;
			
			d = checkDir(time++);
		}
		
		System.out.println(time);
	}

}
