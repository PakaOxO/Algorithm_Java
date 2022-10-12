package logic;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14890, 경사로
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_14890 {
	static int N, L, answer;
	static int[][] map;
	
	static void checkHorz() {
		boolean flag;
		for (int i=0; i<N; i++) {
			int levelCnt = 1;
			int prevLevel = map[i][0];
			flag = true; 
			loop:
			for (int j=1; j<N; j++) {
				if (map[i][j] == prevLevel) {
					levelCnt++;
				} else {
					if (map[i][j] > prevLevel) {
						if (levelCnt < L || map[i][j] - prevLevel > 1) {
							flag = false;
							break;
						}
						levelCnt = 1;
						prevLevel = map[i][j];
					} else {
						if (j > N - L || prevLevel - map[i][j] > 1) {
							flag = false;
							break;
						}
						for (int k=1; k<L; k++) {
							if (j + k == N) {
								flag = false;
								break loop;
							}
							if (map[i][j] != map[i][j + k]) {
								flag = false;
								break loop;
							}
						}
						j += L - 1;
						levelCnt = 0;
						prevLevel = map[i][j];
						continue;
					}
				}
			}
			if (flag) {
				answer++;
			}
		}
	}
	
	static void checkVert() {
		boolean flag;
		for (int j=0; j<N; j++) {
			int levelCnt = 1;
			int prevLevel = map[0][j];
			flag = true; 
			loop:
			for (int i=1; i<N; i++) {
				if (map[i][j] == prevLevel) {
					levelCnt++;
				} else {
					if (map[i][j] > prevLevel) {
						if (levelCnt < L || map[i][j] - prevLevel > 1) {
							flag = false;
							break;
						}
						levelCnt = 1;
						prevLevel = map[i][j];
					} else {
						if (i > N - L || prevLevel - map[i][j] > 1) {
							flag = false;
							break;
						}
						for (int k=1; k<L; k++) {
							if (i + k == N) {
								flag = false;
								break loop;
							}
							if (map[i][j] != map[i + k][j]) {
								flag = false;
								break loop;
							}
						}
						i += L - 1;
						levelCnt = 0;
						prevLevel = map[i][j];
						continue;
					}
				}
			}
			if (flag) {
				answer++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		checkHorz();
		checkVert();
		
		System.out.println(answer);
	}

}
