package disjointSet;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18116, 로봇 조립 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 집합을 만들어 가면서 질문이 나왔을 때 그 집합의 요소 개수를 반환하면 되는 문제
 * 	2. 최대 주어지는 부품의 개수가 나와 있지 않으므로 최대 주어질 수 있는 간선의 개수만큼 넉넉하게 배열을 만들어 풀이 
 *
 */
public class BaekJoon_18116 {
	static int[] p;
	static int[] rank;
	
	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) return false;
		
		if (rank[px] >= rank[py]) {
			p[py] = px;
			rank[px] += rank[py];
		}
		else {
			p[px] = py;
			rank[py] += rank[px];
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		p = new int[1000001];
		rank = new int[1000001];
		for (int i=1; i<1000001; i++) {
			p[i] = i;
			rank[i] = 1;
		}
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			if (c == 'I') {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			} else {
				sb.append(rank[findSet(Integer.parseInt(st.nextToken()))]).append("\n");
			}
		}
		br.close();
		System.out.print(sb);
	}

}
