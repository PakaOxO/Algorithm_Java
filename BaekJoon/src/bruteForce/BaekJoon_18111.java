package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18111, 마인크래프트
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 입력으로 지형 높이를 탐색하며 최대 높이(hmax), 최소 높이(hmin) 저장
 * 	2. 최대 높이부터 시작해 최소 높이까지 반복문 실행
 * 		2.1 가지고 있는 블럭을 고려해 각각의 지정 높이까지 만드는데 시간을 도출
 * 		2.2 가지고 있는 블럭으로 해당 높이를 만들 수 없으면 return
 * 		2.3 최소 시간과 높이를 저장
 * 	3. 반복문 종료 후 결과값 출력
 * 
 * 다른 풀이 : 맵 각각의 높이(2차원 배열)가 아닌 전체 맵에서 해당 위치의 높이 개수들로 배열을 만들어 푸는 방법
 * 	1. 맵 내 높이의 개수를 입력을 받으며 카운팅
 * 	2. 최대 높이와 최소 높이를 같이 저장
 * 	3. 처음 풀이의 반복문을 돌며 목적 높이에 맞게 블럭 높이를 조정하며 시간 계산
 * 	4. 결과 출력
 *
 */
public class BaekJoon_18111 {
	static int N, M;
	static int[] heights;
	static int time;
	static int height;
	
	static void buildHeight(int h, int B) {
		int t = 0;
		for (int i=0; i<257; i++) {
			if (heights[i] == 0 || i == h) continue;
			if (i > h) {
				int diff = (i - h) * heights[i];
				t += diff * 2;
				B += diff;
			} else {
				int diff = (h - i) * heights[i];
				t += diff;
				B -= diff;
			}
			if (t >= time) return;
		}
		if (B < 0) return;
		
		if (t <= time) {
			time = t;
			height = h;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		heights = new int[257];
		int hmax = Integer.MIN_VALUE;
		int hmin = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				int h = Integer.parseInt(st.nextToken());
				heights[h]++;
				if (h > hmax) hmax = h;
				if (h < hmin) hmin = h;
			}
		}
		
		time = Integer.MAX_VALUE;
		for (int i=hmin; i<=hmax; i++) {
			buildHeight(i, B);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(time).append(" ").append(height);
		System.out.println(sb);
		br.close();
	}

}
