package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_22946, 원 이동하기 1
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. int 오버플로우...
 * 	2. 먼저 입력받은 원들을 Circle 객체를 만들어 배열에 저장한 뒤, 반지름을 기준으로 오름차순 정렬한다.
 * 	3. 정렬된 상태에서 앞에서부터 i와 j(i+1~N)을 비교해 포함관계를 체크하고 포함관계가 성립하면 서로 연결관계를 추가한다
 * 		3.1 이때 i의 반지름이 j의 반지름보다 작으므로 i는 j안에 포함된 상태이다.
 * 		3.2 포함 되어있는 Circle 객체의 hasOuter 값을 true로 변경한다 이는 나중에 자신을 포함한 원이 없을 때 좌표평면과 연결하기 위한 변수이다.	
 * 		3.3 자신을 포함하는 부모 원은 단 1개이므로 트리구조의 그래프가 만들어짐을 알 수 있다. 부모는 여러 개의 자식을 가질 수 있으며 최상위 노드는 좌표평면이다.
 * 	4. 모든 연결정보가 완성되면 좌표평면을 포함(문제의 조건)한 모든 원에서 시작하는 dfs 탐색을 실시해 최대 depth값을 answer에 저장한다.
 *
 */
public class BaekJoon_22946 {
	static class Circle {
		int cNo, r;
		long x, y;
		Circle prev;
		boolean hasOuter;
		
		Circle(int cNo, long x, long y, int r) {
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
		double dist = Math.sqrt(((c1.x - c2.x) * (c1.x - c2.x)) + ((c1.y - c2.y) * (c1.y - c2.y)));
		
		return dist < c2.r - c1.r;
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
			Circle circle = new Circle(i + 1, Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Integer.parseInt(st.nextToken()));
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
		for (int i=0; i<=N; i++) {
			isVisited[i] = true;
			dfs(i, 0);
			isVisited[i] = false;
		}
		System.out.println(answer);
	}

}
