package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_15686, 치킨거리
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력을 받으면서 치킨집과 가정집의 위치를 ArrayList에 저장
 * 	2. M개의 치킨집을 선택하는 조합을 dfs로 탐색
 * 	3. M개가 선택되었으면 각각의 가정집을 순회하면서 가장 짧은 치킨거리를 sum 변수에 합산
 * 	4. 계산된 sum과 min(답을 담을 변수)을 비교해 가장 작은 치킨거리 합을 계산
 * 	5. 가장 작은 치킨거리(min) 출력
 *
 */
public class BaekJoon_15686 {
	static int N, M;
	static List<int[]> hList;
	static List<int[]> cList;
	static int[] selected;
	static int min;
	
	static void dfs(int start, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i=0; i<hList.size(); i++) {
				int minD = Integer.MAX_VALUE;
				for (int j=0; j<M; j++) {
					int d = Math.abs(hList.get(i)[0] - cList.get(selected[j])[0]) + Math.abs(hList.get(i)[1] - cList.get(selected[j])[1]);
					if (d < minD) minD = d;
				}
				sum += minD;
				if (sum >= min) return;
			}
			min = sum;
			return;
		}
		
		for (int i=start; i<cList.size(); i++) {
			selected[cnt] = i;
			dfs(i + 1, cnt + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cList = new ArrayList<>();
		hList = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int type = Integer.parseInt(st.nextToken());
				if (type == 2) cList.add(new int[] { i, j });
				else if (type == 1) hList.add(new int[] { i, j });
			}
		}
		
		min = Integer.MAX_VALUE;
		selected = new int[M];
		dfs(0, 0);
		
		System.out.println(min);
		br.close();
	}

}
