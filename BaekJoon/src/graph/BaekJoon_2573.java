package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2573, 빙산(HARD)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 입력을 받으면서 얼음의 위치를 기억해 노드를 만든 후 큐에 저장
 * 	2. 반복문을 큐의 크기(얼음의 개수)만큼 돌리면서 사방 탐색
 * 	3. 바로 녹이지말고 녹은 개수를 노드에 저장한 뒤 해당 분기 끝나면 한번에 녹임(녹아서 다른 얼음을 녹일 때 영향 주는 것 방지)
 * 	4. 전체 큐를 돌면서 저장된 녹일 개수만큼 map의 높이를 줄여줌 0보다 같거나 작아지면 0으로 보정
 * 	5. 높이가 0이된 얼음이 있다면 얼음의 위치 중 하나를 가져와서 dfs탐색
 * 	6. 탐색의 결과 얼음의 개수가 전체 큐의 길이(전체 얼음의 개수)보다 작으면 얼음이 쪼개진 것이므로 해당 날짜를 answer에 저장하고 반복문(while) break
 *
 */
public class BaekJoon_2573 {
	static int N, M, cCnt, answer;
	static int[][] map;
	static boolean[][] isVisited;
	static Queue<Iceberg> queue;
	
	static int[][] drc = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	
	static class Iceberg {
		int r, c, meltingCnt;
		
		Iceberg(int r, int c, int meltingCnt) {
			this.r = r;
			this.c = c;
			this.meltingCnt = meltingCnt;
		}
	}
	
	static void dfs(int r, int c) {
		cCnt++;
		for (int i=0; i<4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || isVisited[nr][nc]) continue;
			isVisited[nr][nc] = true;
			dfs(nr, nc);
			
		}
	}
	
	static void melt() {
		int qSize = queue.size();
		for (int i=0; i<qSize; i++) {
			Iceberg curr = queue.poll();
			map[curr.r][curr.c] = (map[curr.r][curr.c] < curr.meltingCnt) ? 0 : map[curr.r][curr.c] - curr.meltingCnt;
			
			if (map[curr.r][curr.c] > 0) queue.offer(curr);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		queue = new LinkedList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					queue.offer(new Iceberg(i, j, 0));
				}
			}
		}
		br.close();
		
		int day = 1;
		while (true) {
			int qSize = queue.size();
			for (int i=0; i<qSize; i++) {
				Iceberg curr = queue.poll();
				int cnt = 0;
				for (int j=0; j<4; j++) {
					int nr = curr.r + drc[j][0];
					int nc = curr.c + drc[j][1];
					if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
					
					if (map[nr][nc] == 0) cnt++;
				}
				curr.meltingCnt = cnt;
				queue.offer(curr);
			}
			
			melt();
			
			if (queue.size() == 0) break;
			if (queue.size() < qSize) {
				isVisited = new boolean[N][M];
				cCnt = 0;
				
				isVisited[queue.peek().r][queue.peek().c] = true;
				dfs(queue.peek().r, queue.peek().c);
				
				if (cCnt < queue.size()) {
					answer = day;
					break;
				}
			}
			day++;
		}
		System.out.println(answer);
	}

}
