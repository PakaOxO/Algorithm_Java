package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1194, 달이 차오른다 가자
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 다음 위치(nr, nc)에 방문했는지 체크하기 위해 이전에 같은 키를 가진 상태에서 방문했는지 체크
 * 		1.1 키의 개수가 a~f까지 6개이므로 나올 수 있는 조합의 개수는 2^6 = 64가지
 * 		1.2 64의 가지수를 배열에 체크하는 것은 어렵기 때문에 비트마스킹을 사용해 a, c 키를 가지고 있는 경우에는 101로 [nr][nc][5]의 방문 체크를 하면 됨
 * 	2. 나머지는 단순 BFS, 노드(Pos)에는 현재 위치(r,c)와 방문 차수(depth) 그리고 해당 위치에서 가지고 있는 키(hasKey)에 대한 값을 가지고 있음
 * 	3. 도착지점에 도달하면 그 때의 depth(curr.depth + 1)을 answer에 저장
 * 	4. 도달하지 못했다면 맨 처음 초기화 한 값인 -1을 도달했다면 새로 세팅된 answer의 값을 출력
 *
 */
public class BaekJoon_1194 {
	static int N, M, answer;
	static char[][] map;
	static Pos start, end;
	
	static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	
	static class Pos {
		int r, c, depth, hasKey;
		
		Pos(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.hasKey = 0;
		}
	}
	
	static boolean check(int hasKey, char door) {
		return (hasKey & (1 << (int)(door - 'a'))) > 0;
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][][] isVisited = new boolean[N][M][1<<6];
		q.offer(start);
		isVisited[start.r][start.c][0] = true;
		
		while (q.size() > 0) {
			Pos curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || isVisited[nr][nc][curr.hasKey] || map[nr][nc] == '#') continue;
				
				Pos next = new Pos(nr, nc, curr.depth + 1);
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					next.hasKey = curr.hasKey | (1 << (int)(map[nr][nc] - 'a'));
					
				} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					if (!check(curr.hasKey, map[nr][nc])) continue;
					next.hasKey = curr.hasKey;
					
				} else if (map[nr][nc] == '1') {
					answer = curr.depth + 1;
					return;
					
				} else {
					next.hasKey = curr.hasKey;
					
				}
				isVisited[nr][nc][curr.hasKey] = true;
				q.offer(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '0') {
					start = new Pos(i, j, 0);
				}
				else if (map[i][j] == '1') end = new Pos(i, j, 0);
			}
		}
		br.close();
		
		answer = -1;
		bfs();
		System.out.println(answer);
	}

}
