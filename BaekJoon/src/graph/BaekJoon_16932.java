package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16932, 모양 만들기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 메모리가 넉넉하니 먼저 입력을 받으며 0의 위치를 리스트에 저장
 * 	2. 리스트에서 임의의 0의 위치를 하나 뽑아 1로 바꿔줌
 * 		2.1 그 상태에서 전체 맵을 순회하면서 1의 위치를 발견했다면 BFS 탐색
 * 		2.2 탐색의 결과 카운팅한 1의 개수와 max값을 비교해 max를 갱신
 *
 */
public class BaekJoon_16932 {
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int[][] map;
	static List<Point> zero;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
