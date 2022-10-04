package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1707, 이분 그래프
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 하나의 노드에서 깊이 우선 탐색을 하면서 중복되는 노드를 만나는지 체크
 *
 */
public class BaekJoon_1707 {
	static class Node {
		int v, prev;
		Node next;
		
		Node(int v, int prev) {
			this.v = v;
			this.prev = prev;
		}
		
		Node(int v, Node next) {
			this.v = v;
			this.next = next;
		}
	}
	
	static int V, E;
	static Node[] adjList;
	static int[] isVisited;
	static boolean flag;
	
	static boolean dfs(int v, int c) {
		isVisited[v] = c;
		
		for (Node next=adjList[v]; next!=null; next=next.next) {
			if (isVisited[next.v] == c) {
				return false;
			} else if (isVisited[next.v] == 0) {
				return dfs(next.v, c*-1);
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new Node[V + 1];
			for (int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				adjList[s] = new Node(e, adjList[s]);
				adjList[e] = new Node(s, adjList[e]);
			}
				
			isVisited = new int[V + 1];
			for (int i=1; i<=V; i++) {
				if(isVisited[i] != 0) continue;
				flag = dfs(i, 1);
			}
			
			System.out.println(Arrays.toString(isVisited));
			if (flag) sb.append("YES\n");
			else sb.append("NO\n");
		}
		br.close();
		System.out.print(sb);
	}

}
