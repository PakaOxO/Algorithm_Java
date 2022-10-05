package shortPath;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_13549, 숨바꼭질 3 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 이동하는데 우선순위는 순간이동(시간소요 X), 그 다음 좌우 이동(시간 1초 소요)
 * 	2. 현재 지점을 시작으로 우선 순위에 따라 이동을 하는데 이동하는 다음 지점의 가중치 누적합은 현재 위치의 누적합 + 소요시간
 * 	3. 우선 순위 큐에서 자동으로 가중치 누적합이 낮은 순으로 정렬이 되므로 다익스트라 알고리즘에서는 자동으로 다음 탐색 지점이 결정됨
 * 	4. 다음 탐색 지점에서 2,3 반복
 *
 */
public class BaekJoon_13549 {
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
	static int[] dist;
	static boolean[] isVisited;
	static int answer;
	
	static void dijkstra(int s, int e) {
		dist = new int[100001];
		Arrays.fill(dist, INF);
		isVisited = new boolean[100001];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		dist[s] = 0;
		
		while (pq.size() > 0) {
			Node curr = pq.poll();
			if (isVisited[curr.v]) continue;
			if (curr.v == e) {
				answer = curr.w;
				break;
			}
			isVisited[curr.v] = true;
			
			int next = curr.v * 2;
			if (curr.v != 0 && next <= 100000 && !isVisited[next] && dist[next] > dist[curr.v]) {
				dist[next] = dist[curr.v];
				pq.offer(new Node(next, dist[next]));
			}
			next = curr.v + 1;
			if (next <= 100000 && !isVisited[next] && dist[next] > dist[curr.v] + 1) {
				dist[next] = dist[curr.v] + 1;
				pq.offer(new Node(next, dist[next]));
			}
			next = curr.v - 1;
			if (next >= 0 && !isVisited[next] && dist[next] > dist[curr.v] + 1) {
				dist[next] = dist[curr.v] + 1;
				pq.offer(new Node(next, dist[next]));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		br.close();
		
		dijkstra(s, e);
		System.out.println(answer);
	}

}
