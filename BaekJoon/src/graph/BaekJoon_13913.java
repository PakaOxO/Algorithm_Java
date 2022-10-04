package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13913, 숨바꼭질
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 현재 위치 기준, 좌 또는 우, 아니면 2배의 위치로 이동하면서 BFS 탐색
 * 	2. 탐색하는 노드 정보를 담을 클래스를 정의해 사용하며 노드 객체는 현재 위치, depth(이동횟수), 이전 경로(prev) 노드 정보를 담음
 * 	3. 동생의 위치에 도착했다면 해당 노드를 last에 저장하고 리턴
 * 	4. 
 *
 */
public class BaekJoon_13913 {
	static class Node {
		int v, depth;
		Node prev;
		
		Node(int v, int depth) {
			this.v = v;
			this.depth = depth;
		}
		
		Node(int v, int depth, Node prev) {
			this.v = v;
			this.depth = depth;
			this.prev = prev;
		}
	}
	
	static int N, K;
	static Node last;
	static boolean[] isVisited;
	
	static void bfs() {
		if (N == K) return;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(N, 0, null));
		
		while (q.size() > 0) {
			Node curr = q.poll();
			
			if (curr.v - 1 >= 0 && !isVisited[curr.v - 1]) {
				if (curr.v - 1 == K) {
					last = new Node(curr.v - 1, curr.depth + 1, curr);
					return;
				}
					
				isVisited[curr.v - 1] = true;
				q.offer(new Node(curr.v - 1, curr.depth + 1, curr));
			}
			
			if (curr.v + 1 < 100001 && !isVisited[curr.v + 1]) {
				if (curr.v + 1 == K) {
					last = new Node(curr.v + 1, curr.depth + 1, curr);
					return;
				}
				
				isVisited[curr.v + 1] = true;
				q.offer(new Node(curr.v + 1, curr.depth + 1, curr));
			}
			
			if (curr.v * 2 < 100001 && !isVisited[curr.v * 2]) {
				if (curr.v * 2 == K) {
					last = new Node(curr.v * 2, curr.depth + 1, curr);
					return;
				}
				
				isVisited[curr.v * 2] = true;
				q.offer(new Node(curr.v * 2, curr.depth + 1, curr));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		br.close();
		
		isVisited = new boolean[100001];
		bfs();
		
		StringBuilder sb = new StringBuilder();
		List<Integer> path;
		int pathCnt = 1;
		if (last != null) {
			path = new ArrayList<>();
			pathCnt = last.depth;
			Node next = last;
			while (next != null) {
				path.add(next.v);
				next = next.prev;
			}
			
			sb.append(pathCnt).append("\n");
			for (int i=path.size()-1; i>=0; i--) {
				sb.append(path.get(i)).append(" ");
			}
		} else {
			sb.append("0\n").append(N);
		}
		
		System.out.println(sb.toString().trim());
	}

}
