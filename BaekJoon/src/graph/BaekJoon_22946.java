package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_22946, 원 이동하기 1
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_22946 {
	static class Circle {
		int cNo, x, y, r;
		Circle prev;
		boolean hasOuter;
		
		Circle(int cNo, int x, int y, int r) {
			this.cNo = cNo;
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	static int N, answer;
	static Circle[] c;
	static List<Integer>[] conn;
	static boolean[] isVisited;
	
	static boolean isEmbraced(Circle c1, Circle c2) {
		double dist = Math.sqrt((c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y));
		return dist - Math.max(c1.r,  c2.r) < 0;
	}
	
	static void dfs(int curr, int depth) {
		answer = Math.max(answer, depth);
		
		for (int next : conn[curr]) {
			if (isVisited[next]) continue;
			isVisited[next] = true;
			dfs(next, depth + 1);
			isVisited[next] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		c = new Circle[N];
		conn = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];

		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Circle circle = new Circle(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			c[i] = circle;
		}
		br.close();
		
		Arrays.sort(c, new Comparator<Circle>() {
			@Override
			public int compare(Circle o1, Circle o2) {
				return o1.r - o2.r;
			}
		});
		
		for (int i=0; i<=N; i++) {
			conn[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if (isEmbraced(c[i], c[j])) {
					conn[c[i].cNo].add(c[j].cNo);
					conn[c[j].cNo].add(c[i].cNo);
					c[i].hasOuter = true;
					break;
				}
			}
			
			if (!c[i].hasOuter) {
				conn[c[i].cNo].add(0);
				conn[0].add(c[i].cNo);
			}
		}
		
		answer = 0;
		for (int i=1; i<=N; i++) {
			isVisited[i] = true;
			dfs(i, 0);
			isVisited[i] = false;
		}
		System.out.println(answer);
	}

}
