package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 노드 사이의 거리
public class BaekJoon_1240 {
	private static int answer;
	private static List<List<Node>> graph = new ArrayList<>();
	
	private static class Node {
		int nextNode;
		int distance;
		
		Node(int nextNode, int distance) {
			this.nextNode = nextNode;
			this.distance = distance;
		}
	}
	
	private static void dfs(int from, int to, int prev, int distance) {
		System.out.println(from + " " + to);
		if (from == to) answer = distance;
		for (Node next : graph.get(to)) {
			if (next.nextNode != prev) { 
				dfs(from, next.nextNode, to, distance + next.distance);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int distance = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, distance));
			graph.get(to).add(new Node(from, distance));
		}
		
		for (int i=0; i<M; i++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			dfs(from, to, -1, 0);
			System.out.println(answer);
		}
	}

}
