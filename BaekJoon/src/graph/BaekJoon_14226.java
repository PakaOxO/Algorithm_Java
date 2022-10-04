package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14226, 이모티콘
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 너비 우선 탐색을 하면서 현재 이모티콘 개수와 클립보드에 저장된 이모티콘 개수를 체크
 * 	2. 다음 탐색을 종류는 3가지
 * 		2.1 복사 : 현재 이모티콘 개수를 클립보드에 저장
 * 		2.2 붙여넣기 : 현재 클립보드 이모티콘 개수를 현재 이모티콘 개수에 추가(+)
 * 		3.3 삭제 ; 현재 이모티콘 개수를 1개 줄임
 * 
 * 	** 탐색과정에서 최대 몇개까지 이모티콘을 그렸다 지우는지 몰라 인덱스 에러가 많이 났던 문제..
 *
 */
public class BaekJoon_14226 {
	static int N, answer;
	static boolean[][] isVisited;
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 0, 0 });
		
		while (q.size() > 0) {
			int[] curr = q.poll();
			
			if (curr[0] > 0 && curr[0] <= 1000) {
				isVisited[curr[0]][curr[1]] = true;
				q.offer(new int[] { curr[0], curr[0], curr[2] + 1 });
			}
			
			if (curr[1] > 0 && curr[0] + curr[1] <= N && !isVisited[curr[0] + curr[1]][curr[1]]) {
				if (curr[0] + curr[1] == N) {
					answer = curr[2] + 1;
					return;
				}
				isVisited[curr[0] + curr[1]][curr[1]] = true;
				q.offer(new int[] { curr[0] + curr[1], curr[1], curr[2] + 1 });
			}
			
			if (curr[0] > 1 && !isVisited[curr[0] - 1][curr[1]]) {
				if (curr[0] - 1 == N) {
					answer = curr[2] + 1;
					return;
				}
				isVisited[curr[0] - 1][curr[1]] = true;
				q.offer(new int[] { curr[0] - 1, curr[1], curr[2] + 1 });
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
		
		isVisited = new boolean[1001][1001];
		bfs();
		System.out.println(answer);
	}

}
