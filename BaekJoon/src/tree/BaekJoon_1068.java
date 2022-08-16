package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리
public class BaekJoon_1068 {
	static int N;
	static int[] parents;
	static boolean[] isVisited;
	static int answer;
	
	static void deleteNode(int node) {
		parents[node] = -2;
		for (int i=0; i<N; i++) {
			if (parents[i] == node) {
				deleteNode(i);
			}
		}
	}
	
	static void checkLeaf(int node) {
		boolean isLeaf = true;
		isVisited[node] = true;
		if (parents[node] == -2) return;
		for (int i=0; i<N; i++) {
			if (isVisited[i] == false && parents[i] == node) {
				checkLeaf(i);
				isLeaf = false;
			}
		}
		if (isLeaf) answer++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			parents[i] = parent;
			if (parent == -1) root = i;
		}
		int node = Integer.parseInt(br.readLine());
		deleteNode(node);
		
		isVisited = new boolean[N];
		answer = 0;
		checkLeaf(root);
		System.out.println(answer);
		br.close();
	}

}
