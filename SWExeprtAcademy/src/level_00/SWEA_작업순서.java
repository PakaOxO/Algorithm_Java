package level_00;

import java.io.*;
import java.util.*;

public class SWEA_작업순서 {
	static class Node {
		int v;
		Node next;
		
		Node(int v, Node next) {
			this.v = v;
			this.next = next;
		}
	}
	
	static int V, E;
	static Node[] adjList;
	static int[] inCnt;
	static Queue<Integer> q;
	static int[] path;
	
	static void findPath() {
		q = new LinkedList<>();
		for (int i=1; i<=V; i++) {
			if (inCnt[i] == 0) q.offer(i);
		}
		
		int cnt = 0;
		while (q.size() > 0) {
			int curr = q.poll();
			path[cnt++] = curr;
			
			for (Node next=adjList[curr]; next!=null; next=next.next) {
				if (inCnt[next.v] == 0) continue;
				
				inCnt[next.v]--;
				if (inCnt[next.v] == 0) q.offer(next.v);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new Node[V + 1];
			inCnt = new int[V + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<E; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				inCnt[e]++;
				adjList[s] = new Node(e, adjList[s]);
			}
			
			path = new int[V];
			findPath();
			
			sb.append("#").append(tc).append(" ");
			for (int i=0; i<V; i++) {
				if (i < V - 1) sb.append(path[i]).append(" ");
				else sb.append(path[i]).append("\n");
			}
		}
		br.close();
		System.out.print(sb);
	}

}
