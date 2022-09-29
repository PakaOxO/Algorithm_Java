package level_00;

import java.io.*;
import java.util.*;

public class JeonOl_종교 {
	static int[] p;
	static int V, E;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		p = new int[V + 1];
		for (int i=1; i<=V; i++) p[i] = i;
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		br.close();
		
		Set<Integer> set = new HashSet<>();
		for (int i=1; i<=V; i++) {
			set.add(findSet(i));
		}
		System.out.println(set.size());
	}

}
