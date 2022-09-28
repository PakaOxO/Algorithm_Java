package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_244948, 원 이동하기 2
 * @author kevin-Arpe
 * 
 * Sketch Idea (시간 초과)
 * 	1. 교점은 없으므로 두 원간의 관계가 포함인지 미포함관계인지 체크
 * 		1.1 포함관계이면 서로 연결되었다고 가정
 * 		1.2 미포함 관계이면 서로 연결되지 않았으며 이동은 가능하나 중간에 좌표평면(0)을 방문해야 가능
 * 		1.3 반지름 길이 차이와 중심 간 거리 크기 비교 
 * 
 * 
 * ***** (다른 풀이)
 * 	1. 트리를 만들기 위해 기존의 N*N 순회를 돌며 포함관계를 체크하는 방법 대신 트리 사용
 * 
 * 	2. 중심좌표가 x축만으로 이루어져 있기 때문(y = 0)에 가능
 * 
 * 		2.1 중심을 기준으로 좌, 우의 위치를 구해 원의 번호화 함께 x 위치 저장(각 원당 2개, center - r, center + r)
 * 		2.2 해당 위치들을 List에 넣고 오름차순으로 정렬
 * 		2.3 정렬된 리스트에서 앞에서 하나씩 꺼내 스택에 넣음
 * 		2.4 스택에 삽입 시에 스택이 비어있으면 가장 바깥 원이므로 좌표평면과 해당 원을 connect
 * 		2.5 스택에 다른 원이 있을 땐
 * 			2.5.1 현재 삽입할 원이랑 top의 원이 같은 원일 때 pop
 * 			2.5.2 다르다면 이미 들어있던 원 안에 지금 넣을 원이 포함된 구조이므로 서로 connect
 * 			2.5.3 맨 마지막에 삽입되는 원은 2.5.1에 의해 pop
 * 
 * 	3.  모든 connect 트리가 만들어졌으면 시작, 끝 정점을 입력 받아 BFS 탐색을 진행하며 경로 찾음
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
		int val;
		Node prev;
		
		Node(int val, Node prev) {
			this.val = val;
			this.prev = prev;
		}
	}
	
	static int N;
	static Circle[] c;
	static List<Integer>[] conn;
	static List<Integer> path;
	
	
	static void bfs(int start, int end) {
		Queue<Node> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N + 1];
		q.offer(new Node(start, null));
		isVisited[start] = true;
		
		while (q.size() > 0) {
			Node curr = q.poll();
			for (int next : conn[curr.val]) {
				if (isVisited[next]) continue;
				if (next == end) {
					path.add(next);
					while (curr != null) {
						path.add(curr.val);
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
		
		int[][] arr = new int[N*2][2];
		for (int i=0; i<N*2; i+=2) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int circleNo = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			arr[i][0] = circleNo;
			arr[i][1] = x - r;
			arr[i+1][0] = circleNo;
			arr[i+1][1] = x + r;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		
		conn = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			conn[i] = new ArrayList<>();
		}
		
		Stack<int[]> stack = new Stack<>();
		for (int i=0; i<N*2; i++) {
			int[] point = arr[i];
			if (stack.size() > 0) {
				if (stack.peek()[0] == point[0]) {
					stack.pop();
				} else {
					conn[stack.peek()[0]].add(point[0]);
					conn[point[0]].add(stack.peek()[0]);
					stack.push(point);
				}
			} else {
				conn[point[0]].add(0);
				conn[0].add(point[0]);
				stack.push(point);
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		br.close();
		
		path = new ArrayList<>();
		bfs(from, to);
		
		StringBuilder sb = new StringBuilder();
		int pathLen = path.size();
		sb.append(pathLen).append("\n");
		for (int i=pathLen-1; i>=0; i--) {
			if (i > 0) sb.append(path.get(i)).append(" ");
			else sb.append(path.get(i));
		}
		System.out.println(sb);
	}

}
