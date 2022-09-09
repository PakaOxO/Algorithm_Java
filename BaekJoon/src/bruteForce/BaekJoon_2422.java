package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2422, 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 조합의 가지수에 나오지 말아야 할 조합을 제거하는 문제 
 * 	2. 먼저 나올 수 없는 조합을 돌면서 각각의 아이스크림을 골랐을 때 같이 고르지 못하는 아이스크림을 배열로 저장
 * 	3. 1번부터 N번까지 돌면서 1번을 골랐을 때 같이 고르지 못하는 아이스크림을 제외한 아이스크림 중에서 조합을 찾아 Set에 저장
 * 	4. Set의 특성상 중복된 조합은 저장되지 않으므로 마지막 Set의 크기를 출력 
 * 	-> 실패... Set을 사용하는 것이 메모리를 많이 잡아먹을 뿐 아니라, 선택으로 같이 제외된 조합 아이스크림이 이미 제외되어 있던
 * 		아이스크림이었을 경우 다시 visited를 false로 바꾸는 과정에서 오류가 발생 
 * 
 * 	1. 2차원 배열로 a 메뉴가 선택되었을 때 b 메뉴가 선택이 되지 않으면 b메뉴가 선택되었을 때 a가 선택되지 않아야 하므로
 * 		isVisited[a][b] = isVisited[b][a] = true로 하는 것이 가능
 * 	2. 3가지 메뉴를 고를 뿐인 단순한 조합이므로 재귀보다는 반복문을 사용하는 것이 편할 수 있음
 * 	3. 탐색을 진행하면서 이전에 선택된 메뉴가 i 이번에 선택하는 메뉴가 j라면 isVisited[i][j]가 true이면 선택이 불가
 * 	4. 이와 같은 방법으로 조합의 가지수를 찾을 수 있음 
 * 
 */
public class BaekJoon_2422 {
	static boolean[][] isVisited;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N + 1][N + 1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			isVisited[a][b] = isVisited[b][a] = true;
		}
		
		System.out.println(Arrays.deepToString(isVisited));
		
		for (int i=1; i<=N-2; i++) {
			for (int j=i+1; j<=N-1; j++) {
				if (isVisited[i][j]) continue;
				for (int k=j+1; k<=N; k++) {
					if (isVisited[j][k] || isVisited[i][k]) continue;
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}
