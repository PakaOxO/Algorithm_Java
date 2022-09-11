package dp;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14501, 퇴사 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 완전 탐색을 돌면서 해당 일차에 상담을 받을지 말지 선택
 * 	2. 상담을 받았으면 해당 상담이 끝나는 날로 이동(그 사이 상담은 받을 수 없음)
 * 	3. 마지막에 받을 수 있는 상담은 N일차를 넘어가면 안되므로 현재 일자 기준으로 상담 종료일이 N일을 넘어가는지 체크
 * 	4. 받을 수 있는 모든 상담 조합으로 받을 수 있는 금액의 최대값 출력 
 *
 */
public class BaekJoon_14501 {
	static int N;
	static int[][] arr;
	static int max;
	
	static void dfs(int idx, int sum) {
		if (idx >= N) {
			max = Math.max(max, sum);
			return;
		}
		
		dfs(idx + 1, sum);
		if (idx + arr[idx][0] <= N) dfs(idx + arr[idx][0], sum + arr[idx][1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(max);
		br.close();
	}

}
