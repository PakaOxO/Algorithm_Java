package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1922, 네트워크 연결
 * @author kevin-Arpe
 * 
 * Sketch Idea (Prim MST)
 * 	1. 
 *
 */
public class BaekJoon_1922 {
	static class Node implements Comparable<Node> {
		int v, w;
		Node next;
		
		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		Node(int v, int w, Node next) {
			this.v = v;
			this.w = w;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static StringTokenizer st;
	static int V, E;
	static Node[] adjList;
	static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		adjList = new Node[V + 1];
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[s] = new Node(e, w, adjList[s]);
			adjList[e] = new Node(s, w, adjList[e]);
		}
		br.close();
		
		isVisited = new boolean[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		
		int answer = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			isVisited[curr.v] = true;
			answer += curr.w;
			for (Node next=adjList[curr.v]; next!=null; next=next.next) {
				if (isVisited[next.v]) continue;
				pq.offer(new Node(next.v, next.w));
			}
		}
		System.out.println(answer);
	}

}
