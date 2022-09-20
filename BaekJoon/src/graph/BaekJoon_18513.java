package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18513, 샘터
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 불행도는 샘터에 가까울 수록 낮음
 * 
 * 	2. 때문에 샘터에 가까운 곳부터 집을 배치하는 BFS 탐색 사용
 * 		2.1 모든 샘터의 위치를 큐에 저장한 뒤 하나씩 큐에서 뽑아 내면서 가까운 집의 위치를 선택
 * 		2.2 집을 선택할 때마다 count + 1, 그리고 total + (현재 위치 불행도)
 * 		2.3 탐색의 방법은
 * 			2.3.1 curr 기준 (curr - 1), (curr + 1)로 이동할 수 있는데 두 위치가 pos(이전 방문 장소 및 거리를 저장)에 있는 지 체크해서 없으면 이동
 * 
 * 	3. K개의 집이 선택되었을 때 BFS 탐색 종료
 * 
 * 	4. total(전체 불행도 합계) 출력
 *
 */
public class BaekJoon_18513 {
	static int N, K;
	static long total;
	static Queue<Integer> q;
	static Map<Integer, Integer> pos;
	
	static void bfs() {
		int hCnt = 0;
		
		while (q.size() > 0) {
			int curr = q.poll();
			
			if (!pos.containsKey(curr - 1)) {
				q.offer(curr - 1);
				pos.put(curr - 1, pos.get(curr) + 1);
				total += pos.get(curr - 1);
				hCnt++;
				if (hCnt == K) break;
			}
			if (!pos.containsKey(curr + 1)) {
				q.offer(curr + 1);
				pos.put(curr + 1, pos.get(curr) + 1);
				total += pos.get(curr + 1);
				hCnt++;
				if (hCnt == K) break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		pos = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int p = Integer.parseInt(st.nextToken());
			q.offer(p);
			pos.put(p, 0);
		}
		br.close();
		
		bfs();
		System.out.println(total);
	}

}
