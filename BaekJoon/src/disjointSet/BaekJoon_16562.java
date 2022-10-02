package disjointSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_16562, 친구비 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 친구 연결 정보를 가지고 소인수 집합 생성
 * 	2. 각 집합의 루트 노드는 가장 친구비가 싼 친구로..
 * 	3. 루트 노드들의 친구비 합이 가지고 있는 돈보다 많은지 체크 
 *
 */
public class BaekJoon_16562 {
	static int N, M, K;
	static int[] p, min, cost;
	
	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) return false;
		
		if (cost[px] < cost[py]) {
			p[py] = px;
		} else {
			p[px] = py;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		p = new int[N + 1];
		for (int i=1; i<=N; i++) p[i] = i;
		
		cost = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		br.close();
		
		int total = 0;
		boolean[] isVisited = new boolean[N + 1];
		for (int i=1; i<=N; i++) {
			int p = findSet(i);
			if (isVisited[p]) continue;
			
			total += cost[p];
			isVisited[p] = true;
		}
		if (total <= K) System.out.println(total);
		else System.out.println("Oh no");
	}
}
