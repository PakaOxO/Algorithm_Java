package graph;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2668, 숫자고르기
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 처음 선택된 숫자에서 시작해 루프가 만들어지면 성공적으로 조합이 완성된 경우
 * 
 * 	2. dfs의 시작 노드(root)를 i=1부터 N까지 돌면서 시작
 * 		2.1 단 이전에 입력받으면서 자기자신과 루프가 되는 숫자들은 미리 빼두었으므로 dfs 탐색 X
 * 
 * 	3. dfs을 돌면서 루프가 완성되면 (currNode의 다음 노드가 start node이면) set에 해당 경로를 삽입하고 dfs 탐색 종료
 * 
 * 	4. 모든 탐색이 종료된 후 set의 요소들을 출력
 * 
 */
public class BaekJoon_2668 {
	static int N;
	static int[] arr;
	static boolean[] isVisited;
	static Queue<Integer> queue;
	static Set<Integer> set;
	
	static void dfs(int curr, int start, Queue<Integer> queue) {
		if (isVisited[curr]) return;
		if (arr[curr] == start) {
			for (int i : queue) set.add(i);
			return;
		}
		isVisited[curr] = true;
		queue.offer(curr);
		dfs(arr[curr], start, queue);
		isVisited[curr] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		isVisited = new boolean[N + 1];
		set = new TreeSet<>();
		
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i == arr[i]) {
				set.add(i);
				isVisited[i] = true;
			}
		}
		br.close();
		
		for (int i=1; i<=N; i++) {
			if (isVisited[i]) continue;
			queue = new LinkedList<>();
			dfs(i, i, queue);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(set.size()).append("\n");
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) sb.append(it.next()).append("\n");
		
		System.out.print(sb);
	}

}
