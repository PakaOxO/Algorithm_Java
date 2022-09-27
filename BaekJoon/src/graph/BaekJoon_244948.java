package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_244948, 원 이동하기 2
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 교점은 없으므로 두 원간의 관계가 포함인지 미포함관계인지 체크
 * 		1.1 포함관계이면 서로 연결되었다고 가정
 * 		1.2 미포함 관계이면 서로 연결되지 않았으며 이동은 가능하나 중간에 좌표평면(0)을 방문해야 가능
 *
 */
public class BaekJoon_244948 {
	static class Circle {
		int no, x, y, r;
		boolean hasOuter;
		
		Circle(int no, int x, int y, int r) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.r = r;
			this.hasOuter = false;
		}

		@Override
		public String toString() {
			return "Circle [no=" + no + ", x=" + x + ", y=" + y + ", r=" + r + ", hasOuter=" + hasOuter + "]";
		}
	}
	
	static class Node {
		int num;
		Node prev;
		Node(int num, Node prev) {
			this.num = num;
			this.prev = prev;
		}
	}
	
	static int N, cnt;
	static Circle[] c;
	static List<Integer>[] conn;
	static StringBuilder path;
	
	static boolean isEmbraced(Circle c1, Circle c2) {
		double dist = Math.abs(c1.x - c2.x);
		return dist - Math.max(c1.r, c2.r) < 0;
	}
	
	static void bfs(int start, int end) {
		Queue<Node> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N + 1];
		q.offer(new Node(start, null));
		isVisited[start] = true;
		
		while (q.size() > 0) {
			Node curr = q.poll();
			for (int next : conn[curr.num]) {
				if (isVisited[next]) continue;
				if (next == end) {
					path.append(next).append(" ");
					cnt++;
					while (curr != null) {
						cnt++;
						path.append(curr.num).append(" ");
						curr = curr.prev;
					}
					return;
				}
				q.offer(new Node(next, curr));
				isVisited[next] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		c = new Circle[N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Circle circle = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, Integer.parseInt(st.nextToken()));
			c[i] = circle;
		}
		Arrays.sort(c, new Comparator<Circle>() {
			@Override
			public int compare(Circle o1, Circle o2) {
				return o1.r - o2.r;
			}
		});
		
		conn = new ArrayList[N + 1];
		for (int i=0; i<=N; i++) {
			conn[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if (isEmbraced(c[i], c[j])) {
					conn[c[i].no].add(c[j].no);
					conn[c[j].no].add(c[i].no);
					c[i].hasOuter = true;
				}
				if (c[i].hasOuter) {
					break;
				}
			}
			if (!c[i].hasOuter) {
				conn[c[i].no].add(0); 
				conn[0].add(i + 1);
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		path = new StringBuilder();
		bfs(from, to);
		System.out.println(cnt);
		System.out.println(path.reverse().toString().trim());
	}

}
