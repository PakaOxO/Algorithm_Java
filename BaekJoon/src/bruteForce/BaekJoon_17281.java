package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_17281, 야구
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 4번 타자를 1번 선수로 고정한 뒤 남은 타자를 순열로서 구함
 * 	2. 모든 타자의 순서가 정해지면 야구 play
 * 		2.1 경기는 각 이닝마다 아웃 count와 해당 이닝 점수(score)를 초기화 시켜주며 각 이닝이 끝날 때 마다 sum에 해당 이닝 점수+
 * 
 * 		2.2 1~4루타(홈런) 할 때마다 비트 마스킹으로 해당 타수만큼 LEFT SHIFT 연산
 * 		2.3 또 현재 타자도 해당 타수만큼 이동해야 하므로 SHIFT 연산된 결과에 1 << (hitCnt)를 OR 연산
 * 		2.4 다음 타석에서 남은 주자는 1 << 4 미만의 비트이므로 1 << 4로 나눈 나머지에 해당
 * 		2.5 2.3과 2.4의 결과의 비트수 차이가 다시 홈으로 되돌아온 주자 수에 해당하므로 비트 수 차이를 구해 score에 추가
 * 
 * 		2.6 아웃 수가 3이되면 해당 이닝을 종료
 * 
 * 	3. 각 게임별 점수를 가져와 최대 점수 갱신
 *
 */
public class BaekJoon_17281 {
	static int N, max;
	static int[][] input;
	static int[] queue;
	static boolean[] isVisited;
	
	static void play() {
		int idx = 0;
		int sum = 0;
		
		for (int i=0; i<N; i++) {
			int score = 0;
			int outCnt = 0;
			
			int base = 0;
			while (outCnt < 3) {
				int hitCnt = input[i][queue[idx++]];
				if (idx == 9) idx = 0;
				
				if (hitCnt == 0) {
					outCnt++;
				} else {
					base = base << hitCnt;
					base = base | (1 << hitCnt);
					int next = base % (1 << 4);
					score += Integer.bitCount(base) - Integer.bitCount(next);
					base = next;
				}
			}
			sum += score;
		}
		
		max = Math.max(max, sum);
	}
	
	static void dfs(int depth) {
		if (depth == 3) {
			dfs(depth + 1);
			return;
		}
		
		if (depth == 9) {
			play();
			return;
		}
		
		for (int i=0; i<9; i++) {
			if (isVisited[i]) continue;
			
			queue[depth] = i;
			isVisited[i] = true;
			dfs(depth + 1);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][9];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		isVisited = new boolean[9];
		isVisited[0] = true;
		
		queue = new int[9];
		queue[3] = 0;
		dfs(0);
		
		System.out.println(max);
	}

}
