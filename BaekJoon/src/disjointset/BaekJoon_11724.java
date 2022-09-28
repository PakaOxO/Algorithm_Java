package disjointset;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_11724, 연결 요소의 개수
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 연결 요소의 개수로 나누어진 각각의 집합은 서로 중복이 없으므로 서로소 집합으로 접근
 * 	2. 주어진 간선 정보를 토대로 서로소 집합을 만듬(union)
 * 	3. 집합이 만들어진 후 각 요소의 부모 노드를 찾는 findSet 연산을 실시해 부모의 개수를 카운트(부모의 개수 = 집합의 개수)
 *
 */
public class BaekJoon_11724 {
	static int[] p;
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		p[py] = px;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		p = new int[V + 1];
		for (int i=1; i<V+1; i++) p[i] = i;
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			union(s, e);
		}
		br.close();
		
		Set<Integer> set = new HashSet<>();
		for (int i=1; i<V+1; i++) {
			set.add(findSet(i));
		}
		
		System.out.println(set.size());
	}

}
