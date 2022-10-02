package disjointSet;

import java.io.*;
import java.util.Arrays;

/**
 * BaekJoon_10775, 공항 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. findSet, union에 대한 이해가 필요한 문제 	
 * 	2. 공항에 비행기가 들어오면 gi 이하의 게이트에 주차를 할 수 있으므로 주어진 gi 이하의 게이트와 union을 해야 함. 
 * 	3. union은 최대 gi부터 1까지 가능하고, gi가 주어졌을 때 가장 큰 게이트부터 주차해야 최대한 많은 비행기를 주차할 수 있
 * 	4. union 할 때 마다 가리키는 루트 노드는 현재 루트 노드의 -1, gi부터 시작한다고 하면 gi-1 그 다음 gi나 gi-1에 주차시에는 gi-2로 루트 노드가 바뀜 
 * 	5. 주차를 할 때마다 루트 노드의 숫자가 감소하는데 루트 노드가 0이되었다면 최대 gi부터 1번 게이트까지 모두 주차한 것이므로 더 이상 주차할 공간이 없음. 
 *
 */
public class BaekJoon_10775 {
	static int[] p, cnt;
	
	static int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
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
		p = new int[N + 1];
		
		for (int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		int answer = 0;
		for (int i=0; i<M; i++) {
			int g = Integer.parseInt(br.readLine());
			if (findSet(g) == 0) break;
			union(findSet(g) - 1, g);
			answer++;
		}
		br.close();
		
		System.out.println(answer);
	}

}
