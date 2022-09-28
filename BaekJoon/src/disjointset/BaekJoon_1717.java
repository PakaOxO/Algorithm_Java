package disjointset;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1717, 집합의 표현
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 서로소 집합에 대한 연산을 수행하면 되는 문제
 * 	2. 풀이 내에서 makeSet, findSet, union을 구현해 주어진 입력대로 연산을 수행하면 된다.
 *
 */
public class BaekJoon_1717 {
	static int[] p;
	static StringBuilder sb;
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) return;
		
		p[py] = px;
	}
	
	static void operation(int type, int x, int y) {
		if (type == 0) {
			union(x, y);
		} else {
			if (findSet(x) == findSet(y)) sb.append("YES\n");
			else sb.append("NO\n");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int op = Integer.parseInt(st.nextToken());
		
		p = new int[V + 1];
		for (int i=1; i<=V; i++) {
			p[i] = i;
		}
		
		sb = new StringBuilder();
		for (int i=0; i<op; i++) {
			st = new StringTokenizer(br.readLine());
			operation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		br.close();
		
		System.out.println(sb);
	}

}
