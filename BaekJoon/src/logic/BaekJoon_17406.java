package logic;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17406, 배열 돌리기 4
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 배열을 돌리는 방법에 대해 고민을 조금 했던 문제
 * 	2. 나머지는 dfs로 순열을 구한 뒤 순열에 저장된 회전 방법을 가져와 회전시킨 뒤 문제에서 말하는 배열의 최소값을 도출하면 됨
 *
 */
public class BaekJoon_17406 {
	static int N, M, K, min;
	static int[][] original, arr, operations;
	static int[] selected;
	static boolean[] isVisited;
	static int sR, sC, tR, tC;
	
	static void rotate (int val, int r, int c) {
		int temp;
		
		if (r == sR) {
			if (c != tC) {
				temp = arr[r][c + 1];
				arr[r][c + 1] = val;
				rotate(temp, r, c + 1);
			} else {
				temp = arr[r + 1][c];
				arr[r + 1][c] = val;
				rotate(temp, r + 1, c);
			}
		} else if (c == tC) {
			if (r != tR) {
				temp = arr[r + 1][c];
				arr[r + 1][c] = val;
				rotate(temp, r + 1, c);
			} else {
				temp = arr[r][c - 1];
				arr[r][c - 1] = val;
				rotate(temp, r, c - 1);
			}
		} else if (r == tR) {
			if (c != sC) {
				temp = arr[r][c - 1];
				arr[r][c - 1] = val;
				rotate(temp, r, c - 1);
			} else {
				temp = arr[r - 1][c];
				arr[r - 1][c] = val;
				rotate(temp, r - 1, c);
			}
		} else if (c == sC) {
			if (r != sR) {
				temp = arr[r - 1][c];
				arr[r - 1][c] = val;
				if (r - 1 != sR) rotate(temp, r - 1, c);
			}
		}
	}
	
	static void operation(int r, int c, int s) {
		sR = r - s;
		sC = c - s;
		tR = r + s;
		tC = c + s;
		
		while (sR < tR && sC < tC) {
			rotate(arr[sR][sC], sR, sC);
			sR++;
			sC++;
			tR--;
			tC--;
		}
	}
	
	static void copyArr() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				arr[i][j] = original[i][j];
			}
		}
	}
	
	static void getMin() {
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<M; j++) {
				sum += arr[i][j];
			}
			min = Math.min(min, sum);
		}
	}
	
	static void dfs(int depth) {
		if (depth == K) {
			copyArr();
			for (int num : selected) {
				int[] op = operations[num];
				operation(op[0], op[1], op[2]);
			}
			getMin();
			return;
		}
		
		for (int i=0; i<K; i++) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			selected[depth] = i;
			dfs(depth + 1);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		original = new int[N][M];
		arr = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		operations = new int[K][3];
		min = Integer.MAX_VALUE;
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			operations[i][0] = r;
			operations[i][1] = c;
			operations[i][2] = s;
		}
		br.close();
		
		isVisited = new boolean[K];
		selected = new int[K];
		dfs(0);
		System.out.println(min);
	}

}
