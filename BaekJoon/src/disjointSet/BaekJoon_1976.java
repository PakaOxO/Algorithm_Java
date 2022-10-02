package disjointSet;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1976, 여행 가자 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 연결 정보를 확인해 연결 해야하는 도시들끼리 union 연산 수행 
 * 	2. 최종적으로 가야할 도시들의 루트 노드가 같은지 체크 
 *
 */
public class BaekJoon_1976 {
	static int[] p;
	
	static int findSet(int x) {
		if (p[x] != x) p[x] = findSet(p[x]);
		
		return p[x];
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) return false;
		
		p[py] = px;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		p = new int[N];
		for (int i=0; i<N; i++) p[i] = i;
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int check = Integer.parseInt(st.nextToken());
				if (i == j) continue;
				if (check == 1) union(i, j);
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = findSet(Integer.parseInt(st.nextToken()) - 1);
		boolean flag = true;
		for (int i=1; i<M; i++) {
			if (root != findSet(Integer.parseInt(st.nextToken()) - 1)) {
				flag = false;
			}
		}
		br.close();
		
		if (flag) System.out.println("YES");
		else System.out.println("NO");
	}

}
