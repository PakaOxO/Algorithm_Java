package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16932, 모양 만들기(HARD)
 * @author kevin-Arpe
 * 
 * Sketch Idea(시간초과)
 * 	1. 먼저 입력을 받으며 0의 위치를 리스트에 저장
 * 	2. 리스트에서 임의의 0의 위치를 하나 뽑아 1로 바꿔줌
 * 		2.1 그 상태에서 전체 맵을 순회하면서 1의 위치를 발견했다면 BFS 탐색
 * 		2.2 탐색의 결과 카운팅한 1의 개수와 max값을 비교해 max를 갱신
 * 
 * 	1. 입력을 받으면서 0의 위치를 큐에 저장
 * 	2. 큐에서 0의 위치를 하나씩 빼면서 주변에 1이 있는지 체크
 * 		2.1 1이 있으면 바로 1의 위치에서 BFS 탐색을 시작해 연결된 1들을 그룹핑(그룹핑 단위는 11부터)
 * 		2.2 그룹핑을 하면서 해당 그룹의 1의 개수를 카운팅, 그룹핑이 끝나면 해당 그룹핑 번호 - 1의 개수 (key-value) 쌍으로 map에 저장
 * 		2.3 주변에 1이 하나라도 있었던 0의 위치는 다시 큐에 삽입하는데 삽입하기 전에 다시 사방 탐색하면서 그룹핑된 요소가 있으면 해당 그룹번호를 set에 저장
 * 		2.4 그룹 번호 set을 돌면서 해당 번호로 다시 Map에서 그룹 개수들을 가져와 sum에 더한 뒤 +1(자기 자신)
 * 		2.5 큐에 다시 넣기 전에 sum과 max를 비교해서 max값 갱신
 *
 */
public class BaekJoon_16932 {
	
	static class Point {
		int r, c, sum;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
			this.sum = 0;
		}
	}
	
	static int N, M, cnt, max;
	static int[][] map;
	static Queue<Point> joint;
	static Map<Integer, Integer> group;
	static int[][] drc = { { 0, -1 }, { 0, 1 }, { 1, 0 },  { -1, 0 } };
	
	static void grouping(int r, int c, int groupingNo) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		map[r][c] = groupingNo;
		cnt = 1;
		
		while(q.size() > 0) {
			Point curr = q.poll();
			for (int i=0; i<4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];
				if (!(0 <= nr && nr < N && 0 <= nc && nc < M) || map[nr][nc] != 1) continue;
				q.offer(new Point(nr, nc));
				map[nr][nc] = groupingNo;
				cnt++;
			}
		}
		group.put(groupingNo, cnt);
	}
	
	static void getJoint() {
		int qSize = joint.size();
		int groupingNo = 11;
		for (int i=0; i<qSize; i++) {
			Point curr = joint.poll();
			boolean flag = false;
			Set<Integer> set = new HashSet<>();
			for (int j=0; j<4; j++) {
				int nr = curr.r + drc[j][0];
				int nc = curr.c + drc[j][1];
				if (!(0 <= nr && nr < N && 0 <= nc && nc < M) || map[nr][nc] == 0) continue;
				
				if (map[nr][nc] == 1) {
					grouping(nr, nc, groupingNo);
					set.add(groupingNo);
				} else if (map[nr][nc] > 10) {
					set.add(map[nr][nc]);
				}
				flag = true;
				groupingNo++;
			}
			
			if (flag) {
				int sum = 0;
				Iterator<Integer> it = set.iterator();
				while (it.hasNext()) sum += group.get(it.next());
				curr.sum = sum + 1;
				joint.offer(curr);
				max = Math.max(max, curr.sum);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		joint = new LinkedList<>();
		group = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) joint.offer(new Point(i, j));
			}
		}
		br.close();
		
		max = 0;
		getJoint();
		System.out.println(max);
	}

}
