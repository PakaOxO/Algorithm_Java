package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2096, 내려가기
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. RGB문제와 유사한 문제 RGB에서는 이전 선택 값된 것 외의 2개를 선택하면 됐지만
 * 		이 문제에서는 이전 선택된 값 기준 좌우 거리가 1이하인 곳 선택
 * 	2. dp 풀이 구현
 * 	
 * 	** 오영님 풀이에서 팁 참조, 굳이 N행의 dp 배열을 만들 것이 아니라 참조는 어차피 이전 행에서 하므로
 * 		- 2행짜리 배열을 만들어 초기 값 0행에 저장
 * 		- 다음 행의 계산은 0행을 참조하여 1행에 계산해서 삽입
 * 		- 계산이 끝나면 1행의 값을 다시 0행에 넣어 다음 계산 시에 다시 0행의 값을 참조하도록...
 * 		- ** 주의해야할 점은 최종 답을 1행에서 찾는다면 N이 1일때는 for문이 돌지 않으므로 0을 출력하게 됨
 *
 */
public class BaekJoon_2096 {
	static int[][] dpMin, dpMax;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dpMin = new int[2][3];
		dpMax = new int[2][3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		dpMin[0][0] = dpMax[0][0] = Integer.parseInt(st.nextToken());
		dpMin[0][1] = dpMax[0][1] = Integer.parseInt(st.nextToken());
		dpMin[0][2] = dpMax[0][2] = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			dpMin[1][0] = Math.min(dpMin[0][0], dpMin[0][1]) + x;
			dpMin[1][1] = Math.min(dpMin[0][0], Math.min(dpMin[0][1], dpMin[0][2])) + y;
			dpMin[1][2] = Math.min(dpMin[0][1], dpMin[0][2]) + z;
			
			dpMax[1][0] = Math.max(dpMax[0][0], dpMax[0][1]) + x;
			dpMax[1][1] = Math.max(dpMax[0][0], Math.max(dpMax[0][1], dpMax[0][2])) + y;
			dpMax[1][2] = Math.max(dpMax[0][1], dpMax[0][2]) + z;
			
			dpMin[0][0] = dpMin[1][0];
			dpMin[0][1] = dpMin[1][1];
			dpMin[0][2] = dpMin[1][2];
			
			dpMax[0][0] = dpMax[1][0];
			dpMax[0][1] = dpMax[1][1];
			dpMax[0][2] = dpMax[1][2];
		}
		br.close();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(dpMax[0][0], Math.max(dpMax[0][1], dpMax[0][2])));
		sb.append(" ");
		sb.append(Math.min(dpMin[0][0], Math.min(dpMin[0][1], dpMin[0][2])));
		
		System.out.println(sb);
	}

}
