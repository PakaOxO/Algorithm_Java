package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_22868, 산책(small)
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. start에서 end까지 최단 거리를 정점 번호의 오름차순으로 방문
 * 	2. 해당 방문만 visited를 true로 남겨두고 나머지를 false로 돌림
 * 		2.1 방문 경로는 Node의 prev 속성에 이전 노드를 저장해서 체크
 * 	3. 이번엔 BFS 탐색을 end부터 start까지 돌림. 이때 2번에서 true로 남겨두는 정점 중에 start는 false로 돌려야 제대로 탐색이 완료됨
 *
 */
public class BaekJoon_22868 {
	static class Node {
		int vertex;
		int depth;
		Node prev;
		Node(int vertex, int depth, Node prev) {
			this.vertex = vertex;
			this.depth = depth;
			this.prev = prev;
		}
	}
	static int N, M, start, end, answer;
	static List<Integer>[] conn;
	static boolean[] isVisited;
	static boolean flag;
	
	static void bfs(int from, int to) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(from, 0, null));
		isVisited[from] = true;
		
		while (q.size() > 0) {
			Node curr = q.poll();
			for (int i=0; i<conn[curr.vertex].size(); i++) {
				int next = conn[curr.vertex].get(i);
				if (isVisited[next]) continue;
				if (next == to) {
					answer += curr.depth + 1;
					isVisited = new boolean[N + 1];
					isVisited[curr.vertex] = true; 
					
					while (curr.prev.vertex != from) {
						isVisited[curr.prev.vertex] = true;
						curr = curr.prev;
					}
					return;
				} else {
					q.offer(new Node(next, curr.depth + 1, curr));
					isVisited[next] = true;
				}
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		conn = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if (conn[from] == null) conn[from] = new ArrayList<>();
			conn[from].add(to);
			if (conn[to] == null) conn[to] = new ArrayList<>();
			conn[to].add(from);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		br.close();
		
		for (int i=1; i<=N; i++) {
			if (conn[i] == null) continue;
			Collections.sort(conn[i]);
		}
		
		answer = 0;
		bfs(start, end);
		bfs(end, start);
		System.out.println(answer);
	}

}
