package disjointSet;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_4195, 친구 네트워크 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. rank 혹은 cnt 배열을 만들어 친구 관계가 생길 때 마다 해당 집합의 개수를 배열에 저장
 * 	2. 이미 연결되어 있는 관계일 때 출력하는 걸 빼먹어서 틀림..
 *
 */
public class BaekJoon_4195 {
	static Map<String, Integer> numbering;
	static int[] p;
	static long[] rank;
	static StringBuilder sb;
	
	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px == py) {
			if (rank[px] >= rank[py]) sb.append(rank[px]).append("\n");
			else sb.append(rank[py]).append("\n");
			return false;
		}
		
		if (rank[px] >= rank[py]) {
			p[py] = px;
			rank[px] += rank[py];
			sb.append(rank[px]).append("\n");
		} else {
			p[px] = py;
			rank[py] += rank[px];
			sb.append(rank[py]).append("\n");
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			p = new int[200001];
			rank = new long[200001];
			for (int i=1; i<200001; i++) {
				p[i] = i;
				rank[i] = 1;
			}
			
			numbering = new HashMap<>();
			int num = 1;
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				if (!numbering.containsKey(a)) {
					numbering.put(a, num++);
				}
				if (!numbering.containsKey(b)) {
					numbering.put(b, num++);
				}
				union(numbering.get(a), numbering.get(b));
			}
		}
		br.close();
		System.out.print(sb);
	}

}
