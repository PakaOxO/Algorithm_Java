package bruteForce;

import java.io.*;
import java.util.*;

/***
 * BaekJoon_14620, 꽃길
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. N X N 화단을 순회하면서 뽑을 수 있는 세 위치를 뽑아 조합을 만든다.
 * 	2. 씨앗을 심을 수 있는 위치는 꽃잎이 화단 밖으로 빠져나가는 것을 방지하기 위해 화단 경계에서 상하좌우 1만큼 안쪽으로 골라야한다.
 * 	3. 각각의 씨앗 위치를 고르는 과정에서 price 매개변수에 대여할 때 필요한 금액을 더해주는데 이전에 계산된 비용보다 커질 경우 리턴한다.
 * 	4. 세 개의 씨앗 위치가 다 골라졌을 때 비용을 최소 비용에 저장한다.
 * 	5. 최종적으로 계산된 최소비용을 출력한다.
 * 
 * 	6. **dfs에서 반복문이 아닌 행,열의 위치로 재귀를 돌리는 경우 r, c를 조정하는 부분이 백트래킹 로직보다 상위에 있다면 마지막 데이터(r == N - 2)일 때
 * 		결과값을 확인하지 못하고 r == N - 1 인 부분이 먼저 조건에 걸리므로 바로 return 된다는 문제가 있었음.
 *
 */
public class BaekJoon_14620 {
	static int N;
	static int[][] map;
	static boolean[][] isVisited;
	static int min;
	
	static boolean check(int r, int c) {
		if (isVisited[r][c] || isVisited[r - 1][c] || isVisited[r][c - 1] || isVisited[r][c + 1] || isVisited[r + 1][c]) return false;
		return true;
	}
	
	static void dfs(int r, int c, int cnt, int price) {
		/* 백트래킹 로직 */
		if (price >= min) return;
		if (cnt == 3) {
			min = price;
			return;
		}
		
		/* r, c 체크 */
		if (c == N - 1) {
			r++;
			c = 1;
		}
		if (r == N - 1) return;
		
		
		if (check(r, c)) {
			isVisited[r][c] = true;
			isVisited[r - 1][c] = isVisited[r][c - 1] = isVisited[r][c + 1] = isVisited[r + 1][c] = true;
			dfs(r, c + 1, cnt + 1, price + map[r][c] + map[r - 1][c] + map[r][c - 1] + map[r][c + 1] + map[r + 1][c]);
			isVisited[r][c] = false;
			isVisited[r - 1][c] = isVisited[r][c - 1] = isVisited[r][c + 1] = isVisited[r + 1][c] = false;
		}
		dfs(r, c + 1, cnt, price);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		isVisited = new boolean[N][N];
		min = Integer.MAX_VALUE;
		dfs(1, 1, 0, 0);
		
		System.out.println(min);
		br.close();
	}

}
