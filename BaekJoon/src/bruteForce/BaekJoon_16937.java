package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16937, 두 스티커 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 조합으로 먼저 붙일 두 스티커를 고른다.
 * 
 * 	2. 붙일 스티커를 골랐으면 붙일 수 있는 경우의 수는 4가지이다.
 * 		2.1 H X W 의 공간에 좌측 위에 스티커 하나를 붙인 뒤 남은 스티커를 우측 하단에 붙이는 경우 
 * 		2.2 2.1에 각각의 스티커를 회전 시킬 지 여부를 포함하면 (회전, 회전), (회전, 회전x), (회전x, 회전), (회전x, 회전x) 총 4가지가 추가되어
 * 			총 4가지의 가지수가 나온다.
 * 
 * 	3. 각 가지 수에 대해 두 스티커를 붙일 수 있는지 여부를 확인해야 하는데 완전 탐색으로 직접 붙였다 떼는 경우에는 시간초과나 메모리 초과가 나올 것
 * 		같아 다른 방법을 고민보았는데 찾은 방법은 아래와 같다.
 * 		3.1 세로방향으로 두 개의 스티커를 이어 붙이는 경우 두 스티커 높이(회전 고려)의 합이 H 이하여야 하고,
 * 			두 스티커의 너비 최대 값이 W 이하여야 한다.
 * 		3.2 가로방향으로 두 개의 스티커를 이어 붙이는 경우 두 스티커 너비(회전 고려)의 합이 W 이하여야 하고,
 * 			두 스티커의 높이 최대 값이 H 이하여야 한다.
 * 
 * 	4. 위 3번의 조건 중 하나라도 만족하면 붙일 수 있는 경우이므로 두 스티커 넓이의 합을 현재 최대넓이와 비교해 크면 저장한다.
 *
 */
public class BaekJoon_16937 {
	static int H, W, N;
	static int[][] sticker;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		sticker = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i=0; i<N-1; i++) {
			int a1 = sticker[i][0];
			int b1 = sticker[i][1];
			for (int j=i+1; j<N; j++) {
				int a2 = sticker[j][0];
				int b2 = sticker[j][1];
				if (a1 + a2 <= H && Math.max(b1, b2) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (a1 + b2 <= H && Math.max(a2, b1) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + a2 <= H && Math.max(a1, b2) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + b2 <= H && Math.max(a1, a2) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (a1 + a2 <= W && Math.max(b1, b2) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (a1 + b2 <= W && Math.max(a2, b1) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + a2 <= W && Math.max(a1, b2) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + b2 <= W && Math.max(a1, a2) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
			}
		}
		
		System.out.println(max);
		br.close();
	}

}
