package mst;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1368, 물 대기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 일단 노드 수(논의 수)가 간선의 최대 수에 비해 확연하게 적으므로 Prim MST로 접근..
 * 	2. 처음 풀이는 먼저 cost 배열과 연결링크드리스트를 만든 뒤 연결할 노드를 선택하면서 cost 배열과 비교해 연결할 지 우물을 팔 지 선택	
 * 	3. 이후 소진님 코드 참조해서 연결리스트를 만들 때 cost값 연결하는 비용을 비교해 작은 값을 가중치 값으로 갱신한뒤 연결하도록 수정 
 *
 */
public class BaekJoon_1368 {
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
			return this.w < o.w ? -1 : 1;
		}
	}
	static final int INF = Integer.MAX_VALUE;
	static int[] cost, dist;
	static Node[] adjList;
	static boolean[] isVisited;
	static int N, answer;
	
	static void primMST(int s, int w) {
		dist = new int[N];
		Arrays.fill(dist, INF);
		isVisited = new boolean[N];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, w));
		dist[s] = w;
		
		int cnt = 0;
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			
			isVisited[curr.v] = true;
			answer += curr.w;
			if (++cnt == N) break;
			
			for (Node next=adjList[curr.v]; next!=null; next=next.next) { 
				if (isVisited[next.v] || dist[next.v] <= next.w) continue;
				
				dist[next.v] = next.w;
				pq.offer(new Node(next.v, dist[next.v]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		cost = new int[N];
		int minCost = INF;
		int minIdx = 0;
		for (int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			if (cost[i] < minCost) {
				minCost = cost[i];
				minIdx = i;
			}
		}
		
		adjList = new Node[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i == j) continue;
				w = w < cost[j] ? w : cost[j];
				adjList[i] = new Node(j, w, adjList[i]);
			}
		}
		br.close();
		
		primMST(minIdx, minCost);
		
		System.out.println(answer);
	}

}
