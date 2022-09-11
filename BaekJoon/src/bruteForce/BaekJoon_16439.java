package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16439, 치킨치킨치킨 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. M개의 치킨 중에서 3개의 치킨을 고르는 조합 탐색	
 * 	2. 고른 3개의 치킨에서 각 사람별 최고 선호도를 찾아 sum에 더함
 * 	3. sum과 max(답을 담을 변수)를 비교해 최대 선호도 합을 찾
 *
 */
public class BaekJoon_16439 {
	static int N, M;
	static int[][] preference;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		preference = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) preference[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<M-2; i++) {
			for (int j=i+1; j<M-1; j++) {
				for (int k=j+1; k<M; k++) {
					int sum = 0;
					for (int l=0; l<N; l++) {
						sum += Math.max(Math.max(preference[l][i], preference[l][j]), preference[l][k]);
					}
					max = Math.max(max, sum);
				}
			}
		}
		
		System.out.println(max);
		br.close();
	}

}
